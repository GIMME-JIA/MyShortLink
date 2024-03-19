package org.jia.mylink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接基础响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkBaseInfoRespDTO {
    /**
     * 描述信息
     */
    private String describe;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 短链接
     */
    private String fullShortUrl;
}
