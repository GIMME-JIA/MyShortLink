package org.jia.mylink.project.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.jia.mylink.project.dao.entity.LinkDO;

/**
 * 短链接分页查询请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/13
 */
@Data
public class LinkPageReqDTO extends Page<LinkDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;

}
