package org.jia.mylink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 访问短链接高频ip记录响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
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
