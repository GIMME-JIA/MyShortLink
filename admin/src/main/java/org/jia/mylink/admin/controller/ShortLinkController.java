package org.jia.mylink.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.remote.ShortLinkActualRemoteService;
import org.jia.mylink.admin.remote.dto.request.LinkBatchCreateReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkCreateReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkPageReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkUpdateReqDTO;
import org.jia.mylink.admin.remote.dto.response.LinkBaseInfoRespDTO;
import org.jia.mylink.admin.remote.dto.response.LinkBatchCreateRespDTO;
import org.jia.mylink.admin.remote.dto.response.LinkCreateRespDTO;
import org.jia.mylink.admin.remote.dto.response.LinkPageRespDTO;
import org.jia.mylink.admin.toolkit.EasyExcelWebUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接管理控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/14
 */
@RestController(value = "shortLinkControllerByAdmin")
@RequiredArgsConstructor
// @RequestMapping(path = "/api/short-link/v1")
@RequestMapping(path = "/api/short-link/admin/v1")
public class ShortLinkController {

    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 创建短链接
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    @PostMapping("/create")
    public Result<LinkCreateRespDTO> createLink(@RequestBody LinkCreateReqDTO requestParam){
        return shortLinkActualRemoteService.createShortLink(requestParam);
    }

    /**
     * 批量创建短链接
     * @param requestParam 短链接批量创建请求对象
     * @param response HTTP响应
     */
    @SneakyThrows
    @PostMapping("/create/batch")
    public void batchCreateShortLink(@RequestBody LinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<LinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkActualRemoteService.batchCreateShortLink(requestParam);
        if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
            List<LinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
            EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", LinkBaseInfoRespDTO.class, baseLinkInfos);
        }
    }



    /**
     * 修改短链接
     * @param requestParam 短链接修改请求对象
     */
    @PostMapping("/update")
    public Result<Void> updateLink(@RequestBody LinkUpdateReqDTO requestParam){
        shortLinkActualRemoteService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    @GetMapping("/page")
    public Result<Page<LinkPageRespDTO>> pageLink(LinkPageReqDTO requestParam){
        return shortLinkActualRemoteService.pageShortLink(requestParam.getGid(), requestParam.getOrderTag(), requestParam.getCurrent(), requestParam.getSize());
    }





}
