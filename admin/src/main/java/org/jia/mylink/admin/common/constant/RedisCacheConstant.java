package org.jia.mylink.admin.common.constant;

/**
 * redis缓存常量类
 * @author JIA
 * @version 1.0
 * @since 2024/3/10
 */

public class RedisCacheConstant {
    /**
     * 注册用户时分布式锁
     */
    public static final String LOCK_USER_REGISTER_KEY = "short-link_lock_user-register";

    /**
     * 用户登录缓存key前缀
     */
    public static final String KEY_USER_LOGIN = "user:login:";
}
