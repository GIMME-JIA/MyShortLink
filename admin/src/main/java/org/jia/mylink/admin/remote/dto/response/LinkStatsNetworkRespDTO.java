package org.jia.mylink.admin.remote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接访问网络监控响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsNetworkRespDTO {
    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 访问网络
     */
    private String network;

    /**
     * 占比
     */
    private Double ratio;
}
