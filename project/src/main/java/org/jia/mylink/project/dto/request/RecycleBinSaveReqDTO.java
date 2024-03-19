package org.jia.mylink.project.dto.request;

import lombok.Data;

/**
 * 回收站新增请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */
@Data
public class RecycleBinSaveReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
