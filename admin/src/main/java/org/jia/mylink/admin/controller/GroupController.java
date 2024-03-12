package org.jia.mylink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.dto.request.ShortLinkGroupSaveReqDTO;
import org.jia.mylink.admin.dto.request.ShortLinkGroupSortReqDTO;
import org.jia.mylink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import org.jia.mylink.admin.dto.response.ShortLinkGroupListRespDTO;
import org.jia.mylink.admin.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接分组管理控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@RestController
@RequestMapping(path = "/api/short-link/admin/v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 创建短链接分组
     * @param requestParam 短链接创建分组请求实体
     */
    @PostMapping
    public Result<Void> saveGroup(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }


    /**
     * 查询短链接分组集合
     * @return 短链接分组集合
     */
    @GetMapping
    public Result<List<ShortLinkGroupListRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组名称
     * @param requestParam 短链接分组修改请求实体
     */
    @PutMapping
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * 删除短链接分组
     */
    @DeleteMapping
    public Result<Void> updateGroup(@RequestParam String gid) {
        groupService.deleteGroup(gid);
        return Results.success();
    }

    /**
     * 排序短链接分组
     * @param requestParam 短链接分组排序请求实体
     */
    @PostMapping("/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam) {
        groupService.sortGroup(requestParam);
        return Results.success();
    }

}
