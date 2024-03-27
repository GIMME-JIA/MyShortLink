package org.jia.mylink.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.dto.request.RecycleBinRecoverReqDTO;
import org.jia.mylink.admin.dto.request.RecycleBinRemoveReqDTO;
import org.jia.mylink.admin.dto.request.RecycleBinSaveReqDTO;
import org.jia.mylink.admin.remote.ShortLinkActualRemoteService;
import org.jia.mylink.admin.remote.dto.request.RecycleBinPageReqDTO;
import org.jia.mylink.admin.remote.dto.response.LinkPageRespDTO;
import org.jia.mylink.admin.service.RecycleBinService;
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
@RestController(value = "recycleBinControllerByAdmin")
public class RecycleBinController {

    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    private final RecycleBinService recycleBinService;

    /**
     * 短链接移至回收站
     *
     * @param requestParam 短链接移至回收站请求对象
     */
    @PostMapping("/save")
    public Result<Void> moveToRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        shortLinkActualRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam 回收站短链接分页请求对象
     * @return 短链接分页查询响应对象
     */
    @GetMapping("/page")
    public Result<Page<LinkPageRespDTO>> pageShortLink(RecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageLink(requestParam);
    }

    /**
     * 恢复短链接
     * @param requestParam 回收站短链接恢复请求对象
     */
    @PostMapping("/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        shortLinkActualRemoteService.recoverRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 移除短链接
     */
    @PostMapping("/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        shortLinkActualRemoteService.removeRecycleBin(requestParam);
        return Results.success();
    }

}
