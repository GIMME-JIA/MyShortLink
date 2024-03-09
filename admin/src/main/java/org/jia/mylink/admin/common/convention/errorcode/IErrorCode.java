package org.jia.mylink.admin.common.convention.errorcode;

/**
 * 平台错误码
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/8
 */

public interface IErrorCode {
    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}
