package org.jia.mylink.project.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.jia.mylink.project.dao.entity.LinkDO;

import java.util.List;

/**
 * 回收站分页查询请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */
@Data
public class LinkRecycleBinPageReqDTO extends Page<LinkDO> {
    /**
     * 分组标识
     */
    private List<String> gidList;
}
