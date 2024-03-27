package org.jia.mylink.project.controller;

import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.common.convention.result.Results;
import org.jia.mylink.project.service.UrlTitleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接URL标题控制层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/16
 */
@RestController
@RequestMapping("/api/short-link/v1/title")
@RequiredArgsConstructor
public class UrlTittleController {

    private final UrlTitleService urlTitleService;

    /**
     * 根据 URL 获取对应网站的标题
     * @param url 短链接url
     * @return 网站标题
     */
    @GetMapping
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return Results.success(urlTitleService.getTitleByUrl(url));
    }

}
