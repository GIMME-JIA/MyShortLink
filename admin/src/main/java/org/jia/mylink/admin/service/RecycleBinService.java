package org.jia.mylink.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.remote.dto.request.RecycleBinPageReqDTO;
import org.jia.mylink.admin.remote.dto.response.LinkPageRespDTO;


/**
 * 回收站服务接口层
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */

public interface RecycleBinService {
    /**
     * 分页查询回收站短链接
     * @param requestParam 回收站分页查询请求对象
     * @return 短链接分页查询响应对象
     */
    Result<Page<LinkPageRespDTO>> pageLink(RecycleBinPageReqDTO requestParam);

}
