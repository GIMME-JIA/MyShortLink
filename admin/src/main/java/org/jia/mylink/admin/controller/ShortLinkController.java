package org.jia.mylink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.remote.LinkRemoteService;
import org.jia.mylink.admin.remote.dto.request.LinkCreateReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkPageReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkUpdateReqDTO;
import org.jia.mylink.admin.remote.dto.response.LinkCreateRespDTO;
import org.jia.mylink.admin.remote.dto.response.LinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 短链接管理控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/14
 */
@RestController
@RequestMapping(path = "/api/short-link/v1")
// @RequestMapping(path = "/api/short-link/admin/v1/link")
public class ShortLinkController {

    // TODO (JIA,2024/3/14,11:57)后续重构为SpringCloud Feign调用
    LinkRemoteService linkRemoteService = new LinkRemoteService(){};

    /**
     * 创建短链接
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    @PostMapping("/create")
    public Result<LinkCreateRespDTO> createLink(@RequestBody LinkCreateReqDTO requestParam){
        LinkRemoteService linkRemoteService = new LinkRemoteService(){};
        return linkRemoteService.createLink(requestParam);
    }

    /**
     * 分页查询短链接
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    @GetMapping("/page")
    public Result<IPage<LinkPageRespDTO>> pageLink(LinkPageReqDTO requestParam){
        return linkRemoteService.pageLink(requestParam);
    }

    /**
     * 修改短链接
     * @param requestParam 短链接修改请求对象
     */
    @PutMapping("/update")
    public Result<Void> updateLink(@RequestBody LinkUpdateReqDTO requestParam){
        linkRemoteService.updateLink(requestParam);
        return Results.success();
    }


}
