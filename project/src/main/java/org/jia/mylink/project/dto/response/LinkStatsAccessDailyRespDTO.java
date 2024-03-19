package org.jia.mylink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 访问短链接基础监控响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsAccessDailyRespDTO {
    /**
     * 日期
     */
    private String date;

    /**
     * 访问量
     */
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立IP数
     */
    private Integer uip;
}
