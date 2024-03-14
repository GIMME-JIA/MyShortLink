package org.jia.mylink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.common.convention.result.Results;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.request.LinkPageReqDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;
import org.jia.mylink.project.service.LinkService;
import org.springframework.web.bind.annotation.*;

/**
 * 短链接管理控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@RestController
@RequestMapping(path = "/api/short-link/admin/v1")
// @RequestMapping(path = "/api/short-link/admin/v1/link")
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

    /**
     * 分页查询短链接
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    @GetMapping("/page")
    public Result<IPage<LinkPageRespDTO>> pageLink(LinkPageReqDTO requestParam){
        return Results.success(linkService.pageLink(requestParam));
    }



}
