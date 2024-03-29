package org.jia.mylink.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录相应实体
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {
    /**
     * 用户token
     */
    private String token;
}
