package org.jia.mylink.project.service.impl;

import lombok.SneakyThrows;
import org.jia.mylink.project.service.UrlTitleService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.jia.mylink.project.common.constant.ServiceConstant.REQUEST_GET;
import static org.jia.mylink.project.common.constant.ServiceConstant.TITTLE_FETCH_ERROR;

/**
 * URL接口实现层
 * @author JIA
 * @version 1.0
 * @since 2024/3/16
 */
@Service
public class UrlTitleServiceImpl implements UrlTitleService {
    @SneakyThrows
    @Override
    public String getTitleByUrl(String url) {
        URL targetUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) targetUrl.openConnection();
        connection.setRequestMethod(REQUEST_GET);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Document document = Jsoup.connect(url).get();
            return document.title();
        }
        return TITTLE_FETCH_ERROR;
    }


}
