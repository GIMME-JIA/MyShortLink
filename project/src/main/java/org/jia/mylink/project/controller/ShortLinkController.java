package org.jia.mylink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.common.convention.result.Results;
import org.jia.mylink.project.dto.request.LinkBatchCreateReqDTO;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.request.LinkPageReqDTO;
import org.jia.mylink.project.dto.request.LinkUpdateReqDTO;
import org.jia.mylink.project.dto.response.LinkBatchCreateRespDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;
import org.jia.mylink.project.dto.response.LinkGroupCountQueryRespDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;
import org.jia.mylink.project.service.LinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接管理控制层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@RestController
@RequestMapping(path = "/api/short-link/v1")
// @RequestMapping(path = "/api/short-link/admin/v1")
@RequiredArgsConstructor
public class ShortLinkController {

    private final LinkService linkService;


    /**
     * 短链接跳转原始链接
     *
     * @param shortUri 短链接后缀
     * @param request  HTTP请求
     * @param response HTTP响应
     */
    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, ServletRequest request, ServletResponse response) {

        linkService.restoreUrl(shortUri, request, response);
    }

    /**
     * 创建短链接
     *
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    @PostMapping("/create")
    public Result<LinkCreateRespDTO> createLink(@RequestBody LinkCreateReqDTO requestParam) {
        return Results.success(linkService.createLink(requestParam));
    }

    /**
     * 根据分布式锁创建短链接
     *
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    @PostMapping("/create/by-lock")
    public Result<LinkCreateRespDTO> createShortLinkByLock(@RequestBody LinkCreateReqDTO requestParam) {
        return Results.success(linkService.createShortLinkByLock(requestParam));
    }

    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求对象
     * @return 批量创建短链接响应对象
     */
    @PostMapping("/create/batch")
    public Result<LinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody LinkBatchCreateReqDTO requestParam) {
        return Results.success(linkService.batchCreateShortLink(requestParam));
    }

    /**
     * 分页查询短链接
     *
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    @GetMapping("/page")
    public Result<IPage<LinkPageRespDTO>> pageLink(LinkPageReqDTO requestParam) {
        return Results.success(linkService.pageLink(requestParam));
    }

    /**
     * 查询短链接分组内的数量
     *
     * @param requestParam 短链接分组id集合
     * @return 短链接分组查询响应对象
     */
    @GetMapping("/count")
    public Result<List<LinkGroupCountQueryRespDTO>> listGroupLinkCount(@RequestParam("requestParam") List<String> requestParam) {
        return Results.success(linkService.listGroupLinkCount(requestParam));
    }

    /**
     * 修改短链接
     *
     * @param requestParam 短链接修改请求对象
     */
    @PostMapping("/update")
    public Result<Void> updateLink(@RequestBody LinkUpdateReqDTO requestParam) {
        linkService.updateLink(requestParam);
        return Results.success();
    }


}
