package org.jia.mylink.project.controller;

import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.common.convention.result.Results;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;
import org.jia.mylink.project.service.LinkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接管理控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@RestController
@RequestMapping(path = "/api/short-link/admin/v1/link")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    /**
     * 创建短链接
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    @PostMapping("/create")
    public Result<LinkCreateRespDTO> createLink(@RequestBody LinkCreateReqDTO requestParam){
        return Results.success(linkService.createLink(requestParam));
    }

}
