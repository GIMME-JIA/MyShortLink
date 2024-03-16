package org.jia.mylink.project.service;

/**
 * URL服务接口层
 * @author JIA
 * @version 1.0
 * @since 2024/3/16
 */

public interface UrlTitleService {

    /**
     * 根据 URL 获取标题
     *
     * @param url 目标网站地址
     * @return 网站标题
     */
    String getTitleByUrl(String url);
}
