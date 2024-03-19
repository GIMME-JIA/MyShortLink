package org.jia.mylink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量创建短链接响应对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/19
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
     * 批量创建响应对象
     */
    private List<LinkBaseInfoRespDTO> baseLinkInfos;
}
