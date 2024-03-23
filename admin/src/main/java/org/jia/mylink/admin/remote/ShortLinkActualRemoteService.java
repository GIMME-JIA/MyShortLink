package org.jia.mylink.admin.remote;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.dto.request.RecycleBinRecoverReqDTO;
import org.jia.mylink.admin.dto.request.RecycleBinRemoveReqDTO;
import org.jia.mylink.admin.dto.request.RecycleBinSaveReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkBatchCreateReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkCreateReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkUpdateReqDTO;
import org.jia.mylink.admin.remote.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接中台远程调用服务(Feign实现)
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@FeignClient(value = "short-link-project", url = "${aggregation.remote-url:}")
@RequestMapping("/api/short-link/v1")
public interface ShortLinkActualRemoteService {

    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建响应
     */
    @PostMapping("/create")
    Result<LinkCreateRespDTO> createShortLink(@RequestBody LinkCreateReqDTO requestParam);

    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 短链接批量创建响应
     */
    @PostMapping("/create/batch")
    Result<LinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody LinkBatchCreateReqDTO requestParam);

    /**
     * 修改短链接
     *
     * @param requestParam 修改短链接请求参数
     */
    @PostMapping("/update")
    void updateShortLink(@RequestBody LinkUpdateReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param gid      分组标识
     * @param orderTag 排序类型
     * @param current  当前页
     * @param size     当前数据多少
     * @return 查询短链接响应
     */
    @GetMapping("/page")
    Result<Page<LinkPageRespDTO>> pageShortLink(@RequestParam("gid") String gid,
                                                     @RequestParam("orderTag") String orderTag,
                                                     @RequestParam("current") Long current,
                                                     @RequestParam("size") Long size);

    /**
     * 查询分组短链接总量
     *
     * @param requestParam 分组短链接总量请求参数
     * @return 查询分组短链接总量响应
     */
    @GetMapping("/count")
    Result<List<LinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam);

    /**
     * 根据 URL 获取标题
     *
     * @param url 目标网站地址
     * @return 网站标题
     */
    @GetMapping("/title")
    Result<String> getTitleByUrl(@RequestParam("url") String url);

    /**
     * 保存回收站
     *
     * @param requestParam 请求参数
     */
    @PostMapping("/recycle-bin/save")
    void saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询回收站短链接
     *
     * @param gidList 分组标识集合
     * @param current 当前页
     * @param size    当前数据多少
     * @return 查询短链接响应
     */
    @GetMapping("/recycle-bin/page")
    Result<Page<LinkPageRespDTO>> pageRecycleBinShortLink(@RequestParam("gidList") List<String> gidList,
                                                          @RequestParam("current") Long current,
                                                          @RequestParam("size") Long size);

    /**
     * 恢复短链接
     *
     * @param requestParam 短链接恢复请求参数
     */
    @PostMapping("/recycle-bin/recover")
    void recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam);

    /**
     * 移除短链接
     *
     * @param requestParam 短链接移除请求参数
     */
    @PostMapping("/recycle-bin/remove")
    void removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam);


    /**
     * 访问单个短链接指定时间内监控数据
     *
     * @param fullShortUrl 完整短链接
     * @param gid          分组标识
     * @param startDate    开始时间
     * @param endDate      结束时间
     * @return 短链接监控信息
     */
    @GetMapping("/stats")
    Result<LinkStatsRespDTO> oneShortLinkStats(@RequestParam("fullShortUrl") String fullShortUrl,
                                                    @RequestParam("gid") String gid,
                                                    @RequestParam("startDate") String startDate,
                                                    @RequestParam("endDate") String endDate);

    /**
     * 访问分组短链接指定时间内监控数据
     *
     * @param gid       分组标识
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 分组短链接监控信息
     */
    @GetMapping("/stats/group")
    Result<LinkStatsRespDTO> groupShortLinkStats(@RequestParam("gid") String gid,
                                                 @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate);

    /**
     * 访问单个短链接指定时间内监控访问记录数据
     *
     * @param fullShortUrl 完整短链接
     * @param gid          分组标识
     * @param startDate    开始时间
     * @param endDate      结束时间
     * @return 短链接监控访问记录信息
     */
    @GetMapping("/stats/access-record")
    Result<Page<LinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(@RequestParam("fullShortUrl") String fullShortUrl,
                                                                               @RequestParam("gid") String gid,
                                                                               @RequestParam("startDate") String startDate,
                                                                               @RequestParam("endDate") String endDate);

    /**
     * 访问分组短链接指定时间内监控访问记录数据
     *
     * @param gid       分组标识
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 分组短链接监控访问记录信息
     */
    @GetMapping("/stats/access-record/group")
    Result<Page<LinkStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(@RequestParam("gid") String gid,
                                                                                    @RequestParam("startDate") String startDate,
                                                                                    @RequestParam("endDate") String endDate);

}
