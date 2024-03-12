package org.jia.mylink.project.common.enums;

import org.jia.mylink.project.common.convention.errorcode.IErrorCode;

/**
 * 短链接异常状态码枚举类
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public class LinkErrorCodeEnum implements IErrorCode {


    private final String code;

    private final String message;

    LinkErrorCodeEnum(String code, String message) {
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
