package org.jia.mylink.project.common.convention.exception;


import org.jia.mylink.project.common.convention.errorcode.BaseErrorCode;
import org.jia.mylink.project.common.convention.errorcode.IErrorCode;

/**
 * 远程服务调用异常类
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/9
 */

public class RemoteException extends AbstractException {
    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
