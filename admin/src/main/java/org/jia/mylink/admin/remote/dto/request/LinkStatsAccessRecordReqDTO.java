package org.jia.mylink.admin.remote.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 短链接监控访问记录请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@Data
public class LinkStatsAccessRecordReqDTO extends Page {

    /**
     * 完整短链接
     */
    private String fullShortUrl;

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
