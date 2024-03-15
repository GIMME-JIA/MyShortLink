package org.jia.mylink.project.dto.response;

import lombok.Data;

/**
 * 短链接分组查询响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/14
 */
@Data
public class LinkGroupCountQueryRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接数量
     */
    private Integer shortLinkCount;
}
