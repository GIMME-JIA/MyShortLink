package org.jia.mylink.project.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.jia.mylink.project.dao.entity.LinkAccessLogsDO;

/**
 * 访问短链接分组监控记录请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */
@Data
public class LinkGroupStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {
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
