package org.jia.mylink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.request.LinkPageReqDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;

/**
 * 短链接服务接口层
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public interface LinkService extends IService<LinkDO> {

    /**
     * 创建短链接
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    LinkCreateRespDTO createLink(LinkCreateReqDTO requestParam);

    /**
     * 分页查询短链接
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    IPage<LinkPageRespDTO> pageLink(LinkPageReqDTO requestParam);
}
