package org.jia.mylink.admin.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.jia.mylink.admin.common.serialize.PhoneDesensitizationSerializer;

/**
 * 用户响应实体（信息脱敏）
 * @author JIA
 * @version 1.0
 * @since 2024/3/8
 */
@Data
public class UserRespDTO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
