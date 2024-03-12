package org.jia.mylink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.admin.common.convention.exception.ClientException;
import org.jia.mylink.admin.common.convention.exception.ServiceException;
import org.jia.mylink.admin.common.enums.UserErrorCodeEnum;
import org.jia.mylink.admin.dao.entity.UserDO;
import org.jia.mylink.admin.dao.mapper.UserMapper;
import org.jia.mylink.admin.dto.request.UserLoginReqDTO;
import org.jia.mylink.admin.dto.request.UserRegisterReqDTO;
import org.jia.mylink.admin.dto.request.UserUpdateReqDTO;
import org.jia.mylink.admin.dto.response.UserLoginRespDTO;
import org.jia.mylink.admin.dto.response.UserRespDTO;
import org.jia.mylink.admin.service.UserService;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.jia.mylink.admin.common.constant.RedisCacheConstant.*;
import static org.jia.mylink.admin.common.constant.ServiceConstant.DEL_FLAG_0;
import static org.jia.mylink.admin.common.enums.UserErrorCodeEnum.*;

/**
 * 用户服务实现层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/8
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {


    /**
     * 用户注册缓存穿透布隆过滤器
     */
    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;


    private final RedissonClient redissonClient;


    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public UserRespDTO getUserbyUserName(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);

        UserDO userDO = baseMapper.selectOne(queryWrapper);

        if (userDO == null) {
            throw new ServiceException(UserErrorCodeEnum.USER_NULL);
        }

        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        return !userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void registerUser(UserRegisterReqDTO requestParam) {
        String username = requestParam.getUsername();

        if (!hasUsername(username)) {
            throw new ClientException(USER_NAME_EXIST);
        }

        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + username);     // 只有相同用户名才会获取同一把锁

        try {
            if (lock.tryLock()) {
                UserDO userDO = BeanUtil.toBean(requestParam, UserDO.class);
                int inserted = baseMapper.insert(userDO);

                if (inserted < 1) {
                    throw new ClientException((USER_SAVE_ERROR));
                }

                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
            } else {
                throw new ClientException((USER_SAVE_ERROR));
            }
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void updateUser(UserUpdateReqDTO requestParam) {
        // TODO (JIA,2024/3/11,10:47) 验证当前用户名是否为登录用户
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername());

        baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class), updateWrapper);
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {

        String key = KEY_USER_LOGIN + requestParam.getUsername();

        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword())
                .eq(UserDO::getDelFlag, DEL_FLAG_0);
        UserDO userDO = baseMapper.selectOne(queryWrapper);

        if (userDO == null) {
            throw new ClientException(USER_LOGIN_ERROR);
        }


        Boolean hasLogin = stringRedisTemplate.hasKey(key);
        if (hasLogin != null && hasLogin) {
            throw new ClientException(USER_HAS_LOGIN);
        }

        /**
         * Hash
         * Key:login_用户名
         * Value：
         *  key：token标识
         *  val：json字符串（用户信息）
         */

        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForHash().put(key, token, JSON.toJSONString(userDO));
        stringRedisTemplate.expire(key, TIME_OUT_30, TimeUnit.DAYS);

        return new UserLoginRespDTO(token);

    }

    @Override
    public Boolean checkLogin(String username, String token) {
        return stringRedisTemplate.opsForHash().get(KEY_USER_LOGIN + username, token) != null;
    }

    @Override
    public void logout(String username, String token) {
        if (!checkLogin(username,token)) {
            throw new ClientException(USER_NOT_LOGIN);
        }

        stringRedisTemplate.delete(KEY_USER_LOGIN + username);
    }


}
