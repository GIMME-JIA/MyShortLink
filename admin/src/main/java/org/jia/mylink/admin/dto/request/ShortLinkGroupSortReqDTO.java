package org.jia.mylink.admin.dto.request;

import lombok.Data;

/**
 * 短链接分组排序请求实体
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@Data
public class ShortLinkGroupSortReqDTO {
    /**
     * 分组ID
     */
    private String gid;

    /**
     * 排序次序
     */
    private Integer sortOrder;
}
