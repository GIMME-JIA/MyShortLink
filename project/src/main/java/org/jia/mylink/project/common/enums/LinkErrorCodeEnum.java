package org.jia.mylink.project.common.enums;

import org.jia.mylink.project.common.convention.errorcode.IErrorCode;

/**
 * 短链接异常状态码枚举类
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public enum LinkErrorCodeEnum implements IErrorCode {


    /**
     * 短链接生成频繁
     */
    LINK_OUT_OF_MAX_RETRY("B000100","短链接生成频繁"),
    LINK_IS_DUPLICATE("B000101","短链接已存在"),
    LINK_IS_NOT_EXIST("B000102","短链接不存在"),
    LINK_IS_BEING_VISITED("B000200","短链接正在被访问")

        ;

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
