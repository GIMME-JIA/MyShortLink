package org.jia.mylink.admin.remote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接浏览器监控响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsBrowserRespDTO {
    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 占比
     */
    private Double ratio;

}
