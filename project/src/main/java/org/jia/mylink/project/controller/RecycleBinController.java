package org.jia.mylink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.common.convention.result.Results;
import org.jia.mylink.project.dto.request.RecycleBinPageReqDTO;
import org.jia.mylink.project.dto.request.RecycleBinRecoverReqDTO;
import org.jia.mylink.project.dto.request.RecycleBinRemoveReqDTO;
import org.jia.mylink.project.dto.request.RecycleBinSaveReqDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;
import org.jia.mylink.project.service.impl.RecycleBinServiceImpl;
import org.springframework.web.bind.annotation.*;

/**
 * 短链接回收站控制层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */
@RequiredArgsConstructor
@RequestMapping("/api/short-link/v1/recycle-bin")
@RestController
public class RecycleBinController {
    private final RecycleBinServiceImpl recycleBinService;

    /**
     * 短链接移至回收站
     *
     * @param requestParam 短链接移至回收站请求对象
     */
    @PostMapping("/save")
    public Result<Void> moveToRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        recycleBinService.moveToRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam 回收站分页查询请求对象
     * @return 短链接分页查询响应对象
     */
    @GetMapping("/page")
    public Result<IPage<LinkPageRespDTO>> pageShortLink(RecycleBinPageReqDTO requestParam) {
        return Results.success(recycleBinService.pageLink(requestParam));
    }

    /**
     * 恢复短链接
     *
     * @param requestParam 回收站恢复请求对象
     */
    @PostMapping("/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        recycleBinService.recoverRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 移除短链接
     *
     * @param requestParam 回收站移除请求对象
     */
    @PostMapping("/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        recycleBinService.removeRecycleBin(requestParam);
        return Results.success();
    }
}
