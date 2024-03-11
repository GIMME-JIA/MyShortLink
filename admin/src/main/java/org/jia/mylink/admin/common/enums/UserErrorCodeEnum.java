package org.jia.mylink.admin.common.enums;

import org.jia.mylink.admin.common.convention.errorcode.IErrorCode;

/**
 * 用户异常状态码枚举类
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/8
 */

public enum UserErrorCodeEnum implements IErrorCode {

    /**
     * 用户记录不存在
     */
    USER_NULL("B000200", "用户记录不存在"),

    /**
     * 用户记录已存在
     */
    USER_EXIST("B000201", "用户记录已存在"),

    /**
     * 用户记录新增失败
     */
    USER_SAVE_ERROR("B000202", "用户记录新增失败"),

    /**
     * 用户名已存在
     */
    USER_NAME_EXIST("B000205", "用户名已存在"),

    /**
     * 用户名不存在
     */
    USER_NAME_NOT_EXIST("B000206", "用户名不存在"),


    /**
     * 账号或密码错误
     */
    USER_LOGIN_ERROR("B000208", "账号或密码错误"),

    /**
     * 用户已登录
     */
    USER_HAS_LOGIN("B000210","用户已登录")

    ;

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
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
