package org.jia.mylink.admin.dto.request;

import lombok.Data;

/**
 * 用户注册请求实体
 * @author JIA
 * @version 1.0
 * @since 2024/3/10
 */
@Data
public class UserRegisterReqDTO {

    /**
     * 用户名
     */
    private String username;


    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

}
