package org.jia.mylink.project.common.constant;

/**
 * 服务层常量类
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public class ServiceConstant {

    public static final Integer MAX_RETRY = 10;

    public static final Integer DEL_FLAG_0 = 0;
    public static final Long DEL_TIME_0L = 0L;
    public static final Integer DEL_FLAG_1 = 1;

    public static final Integer ENABLE_STATUS_0 = 0;

    /**
     * http协议
     */
    public static final String PROTOCOL_HTTP = "http://";

    /**
     * 重定向页面路径
     */
    public static final String PATH_NOT_FOUND = "/page/notfound";


    /**
     * 80端口
     */
    public static final Integer PORT_80 = 80;

    /**
     * cookie最大过期时间
     */
    public static final Integer COOKIE_MAX_AGE = 60 * 60 * 24 * 30;

    /**
     * cookie名称
     */
    public static final String COOKIE_NAME = "uv";

    /**
     * 标题获取失败
     */
    public static final String TITTLE_FETCH_ERROR = "Error while fetching title.";

    /**
     * GET请求
     */
    public static final String REQUEST_GET = "GET";
}
