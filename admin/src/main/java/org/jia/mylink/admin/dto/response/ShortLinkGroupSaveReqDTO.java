package org.jia.mylink.admin.dto.response;

import lombok.Data;

/**
 * 短链接创建分组响应实体
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@Data
public class ShortLinkGroupSaveReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组排序
     */
    private Integer sortOrder;

    /**
     * 分组下短链接数量
     */
    private Integer shortLinkCount;
}
