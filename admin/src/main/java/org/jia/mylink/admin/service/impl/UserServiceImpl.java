package org.jia.mylink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.admin.common.convention.exception.ClientException;
import org.jia.mylink.admin.common.convention.exception.ServiceException;
import org.jia.mylink.admin.common.enums.UserErrorCodeEnum;
import org.jia.mylink.admin.dao.entity.UserDO;
import org.jia.mylink.admin.dao.mapper.UserMapper;
import org.jia.mylink.admin.dto.request.UserRegisterReqDTO;
import org.jia.mylink.admin.dto.response.UserRespDTO;
import org.jia.mylink.admin.service.UserService;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static org.jia.mylink.admin.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static org.jia.mylink.admin.common.enums.UserErrorCodeEnum.USER_NAME_EXIST;
import static org.jia.mylink.admin.common.enums.UserErrorCodeEnum.USER_SAVE_ERROR;

/**
 * 用户接口实现层
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


    @Override
    public UserRespDTO getUserbyUserName(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);

        UserDO userDO = baseMapper.selectOne(queryWrapper);

        if(userDO == null){
            throw new ServiceException(UserErrorCodeEnum.USER_NULL);
        }

        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO,result);
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

        try{
             if (lock.tryLock()) {
                UserDO userDO = BeanUtil.toBean(requestParam, UserDO.class);
                int inserted = baseMapper.insert(userDO);

                if(inserted < 1){
                    throw new ClientException((USER_SAVE_ERROR));
                }

                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
            }else {
                throw new ClientException((USER_SAVE_ERROR));
            }
        }finally {
            lock.unlock();
        }

    }
}
