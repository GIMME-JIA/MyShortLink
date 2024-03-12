package org.jia.mylink.admin.dto.request;

import lombok.Data;

/**
 * 短链接分组创建请求实体
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@Data
public class ShortLinkGroupSaveReqDTO {
    /**
     * 短链接分组名
     */
    private String name;
}
