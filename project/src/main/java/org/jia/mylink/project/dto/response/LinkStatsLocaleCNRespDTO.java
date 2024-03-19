package org.jia.mylink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 访问短链接地区记录响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsLocaleCNRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 地区
     */
    private String locale;

    /**
     * 占比
     */
    private Double ratio;
}
