package org.jia.mylink.admin.remote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接操作系统监控响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsOsRespDTO {
    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 占比
     */
    private Double ratio;
}
