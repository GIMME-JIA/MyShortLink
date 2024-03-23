package org.jia.mylink.admin.remote.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分组短链接监控访问记录请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */

@Data
public class LinkGroupStatsAccessRecordReqDTO extends Page {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
