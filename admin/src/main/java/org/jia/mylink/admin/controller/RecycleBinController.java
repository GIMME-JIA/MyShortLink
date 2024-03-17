package org.jia.mylink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.remote.LinkRemoteService;
import org.jia.mylink.admin.remote.dto.request.RecycleBinPageReqDTO;
import org.jia.mylink.admin.remote.dto.request.RecycleBinSaveReqDTO;
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
@RestController
public class RecycleBinController {

    // TODO (JIA,2024/3/14,11:57)后续重构为SpringCloud Feign调用
    LinkRemoteService linkRemoteService = new LinkRemoteService(){};

    private final RecycleBinService recycleBinService;

    /**
     * 短链接移至回收站
     *
     * @param requestParam 短链接移至回收站请求对象
     */
    @PostMapping("/save")
    public Result<Void> moveToRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        linkRemoteService.moveToRecycleBin(requestParam);
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


}
