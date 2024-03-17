package org.jia.mylink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dto.request.LinkRecycleBinPageReqDTO;
import org.jia.mylink.project.dto.request.RecycleBinSaveReqDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;

/**
 * 回收站服务接口
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */

public interface RecycleBinService extends IService<LinkDO> {
    /**
     * 短链接移至回收站
     * @param requestParam 短链接移至回收站请求对象
     */
    void moveToRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询回收站短链接
     * @param requestParam 回收站分页查询请求对象
     * @return 短链接分页查询响应对象
     */
    IPage<LinkPageRespDTO> pageLink(LinkRecycleBinPageReqDTO requestParam);
}
