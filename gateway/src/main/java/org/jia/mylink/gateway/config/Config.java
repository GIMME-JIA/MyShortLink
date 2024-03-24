package org.jia.mylink.gateway.config;

import lombok.Data;

import java.util.List;

/**
 * 过滤器配置类
 * @author JIA
 * @version 1.0
 * @since 2024/3/24
 */

@Data
public class Config {

    /**
     * 白名单前置路径
     */
    private List<String> whitePathList;
}

