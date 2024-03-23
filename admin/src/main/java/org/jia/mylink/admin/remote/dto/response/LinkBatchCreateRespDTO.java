package org.jia.mylink.admin.remote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 短链接批量创建响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkBatchCreateRespDTO {

    /**
     * 成功数量
     */
    private Integer total;

    /**
     * 批量创建返回参数
     */
    private List<LinkBaseInfoRespDTO> baseLinkInfos;
}
