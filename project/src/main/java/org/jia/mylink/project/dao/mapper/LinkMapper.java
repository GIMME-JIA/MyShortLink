package org.jia.mylink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dto.request.LinkPageReqDTO;

/**
 * 短链接持久层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public interface LinkMapper extends BaseMapper<LinkDO> {

    /**
     * 分页统计短链接
     *
     * @param requestParam 短链接分页查询请求对象
     * @return 实体Page
     */
    IPage<LinkDO> pageLink(LinkPageReqDTO requestParam);
}
