package org.jia.mylink.admin.common.convention.exception;

import lombok.Getter;
import org.jia.mylink.admin.common.convention.errorcode.IErrorCode;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 抽象规约异常类：抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 *
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/9
 */
@Getter
public abstract class AbstractException extends RuntimeException{
    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
