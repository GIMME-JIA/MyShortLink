package org.jia.mylink.admin.common.enums;

import org.jia.mylink.admin.common.convention.errorcode.IErrorCode;

/**
 * 分组异常状态码枚举类
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public enum GroupErrorCodeEnum implements IErrorCode {

    /**
     * 该用户无分组信息
     */
    GROUP_NULL("B000100", "该用户无分组信息")

    ;


    private final String code;

    private final String message;

    GroupErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
