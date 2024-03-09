package org.jia.mylink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jia.mylink.admin.dao.entity.UserDO;
import org.jia.mylink.admin.dto.response.UserRespDTO;

/**
 * 用户接口层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/8
 */

public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户响应实体
     */
    UserRespDTO getUserbyUserName(String username);
}
