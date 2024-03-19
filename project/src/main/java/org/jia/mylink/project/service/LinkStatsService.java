package org.jia.mylink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jia.mylink.project.dto.request.LinkGroupStatsAccessRecordReqDTO;
import org.jia.mylink.project.dto.request.LinkGroupStatsReqDTO;
import org.jia.mylink.project.dto.request.LinkStatsAccessRecordReqDTO;
import org.jia.mylink.project.dto.request.LinkStatsReqDTO;
import org.jia.mylink.project.dto.response.LinkStatsAccessRecordRespDTO;
import org.jia.mylink.project.dto.response.LinkStatsRespDTO;

/**
 * 短链接监控服务接口层
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */

public interface LinkStatsService {
    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam
     * @return 访问短链接监控响应对象
     */
    LinkStatsRespDTO oneShortLinkStats(LinkStatsReqDTO requestParam);

    /**
     * 获取分组短链接监控数据
     *
     * @param requestParam
     * @return 访问短链接监控响应对象
     */
    LinkStatsRespDTO groupShortLinkStats(LinkGroupStatsReqDTO requestParam);

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam
     * @return 访问短链接监控记录响应对象
     */
    IPage<LinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(LinkStatsAccessRecordReqDTO requestParam);

    /**
     * 访问分组短链接指定时间内访问记录监控数据
     *
     * @param requestParam
     * @return 访问短链接监控记录响应对象
     */
    IPage<LinkStatsAccessRecordRespDTO> groupShortLinkStatsAccessRecord(LinkGroupStatsAccessRecordReqDTO requestParam);

}
