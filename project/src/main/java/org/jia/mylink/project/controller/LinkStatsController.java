package org.jia.mylink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.common.convention.result.Results;
import org.jia.mylink.project.dto.request.LinkGroupStatsAccessRecordReqDTO;
import org.jia.mylink.project.dto.request.LinkGroupStatsReqDTO;
import org.jia.mylink.project.dto.request.LinkStatsAccessRecordReqDTO;
import org.jia.mylink.project.dto.request.LinkStatsReqDTO;
import org.jia.mylink.project.dto.response.LinkStatsAccessRecordRespDTO;
import org.jia.mylink.project.dto.response.LinkStatsRespDTO;
import org.jia.mylink.project.service.LinkStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接监控控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */
@RestController
@RequestMapping("/api/short-link/v1/stats")
@RequiredArgsConstructor
public class LinkStatsController {
    private final LinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping
    public Result<LinkStatsRespDTO> shortLinkStats(LinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

    /**
     * 访问分组短链接指定时间内监控数据
     */
    @GetMapping("/group")
    public Result<LinkStatsRespDTO> groupShortLinkStats(LinkGroupStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.groupShortLinkStats(requestParam));
    }

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     */
    @GetMapping("/access-record")
    public Result<IPage<LinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(LinkStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }

    /**
     * 访问分组短链接指定时间内访问记录监控数据
     */
    @GetMapping("/access-record/group")
    public Result<IPage<LinkStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(LinkGroupStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.groupShortLinkStatsAccessRecord(requestParam));
    }
}
