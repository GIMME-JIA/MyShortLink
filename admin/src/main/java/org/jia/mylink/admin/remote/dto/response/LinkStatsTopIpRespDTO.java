package org.jia.mylink.admin.remote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接高频访问IP监控响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsTopIpRespDTO {
    /**
     * 统计
     */
    private Integer cnt;

    /**
     * IP
     */
    private String ip;
}
