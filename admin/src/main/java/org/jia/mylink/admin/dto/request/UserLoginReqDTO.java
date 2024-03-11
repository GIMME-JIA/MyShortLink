package org.jia.mylink.admin.dto.request;

import lombok.Data;

/**
 * 用户登录请求实体
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@Data
public class UserLoginReqDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
