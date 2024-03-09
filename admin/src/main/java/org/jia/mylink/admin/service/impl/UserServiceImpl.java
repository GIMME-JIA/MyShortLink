package org.jia.mylink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jia.mylink.admin.common.convention.exception.ServiceException;
import org.jia.mylink.admin.common.enums.UserErrorCodeEnum;
import org.jia.mylink.admin.dao.entity.UserDO;
import org.jia.mylink.admin.dao.mapper.UserMapper;
import org.jia.mylink.admin.dto.response.UserRespDTO;
import org.jia.mylink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/8
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

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
}
