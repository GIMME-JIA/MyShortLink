package org.jia.mylink.admin.dto.request;

import lombok.Data;

/**
 * 短链接分组修改请求实体
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@Data
public class ShortLinkGroupUpdateReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名
     */
    private String name;
}
