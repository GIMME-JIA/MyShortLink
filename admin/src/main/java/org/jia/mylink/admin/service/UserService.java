package org.jia.mylink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jia.mylink.admin.dao.entity.UserDO;
import org.jia.mylink.admin.dto.request.UserLoginReqDTO;
import org.jia.mylink.admin.dto.request.UserRegisterReqDTO;
import org.jia.mylink.admin.dto.request.UserUpdateReqDTO;
import org.jia.mylink.admin.dto.response.UserLoginRespDTO;
import org.jia.mylink.admin.dto.response.UserRespDTO;

/**
 * 用户服务接口层
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

    /**
     * 查询用户名是否可使用
     *
     * @param username 用户名
     * @return true：不存在，可以使用；false：已存在，不可再使用
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 用户注册请求实体
     */
    void registerUser(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户信息
     *
     * @param requestParam 用户信息修改请求实体
     */
    void updateUser(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     *
     * @param requestParam 用户登录请求实体
     * @return 用户登录相应实体 Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 校验用户是否处于登录状态
     *
     * @param username 用户名
     * @param token    登录标识
     * @return true：处于登录状态；false：token过期了，序重新登录
     */
    Boolean checkLogin(String username, String token);

    /**
     * 用户退出登录
     * @param username 用户名
     * @param token 登录标识
     */
    void logout(String username, String token);
}
