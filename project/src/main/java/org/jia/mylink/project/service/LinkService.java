package org.jia.mylink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dto.biz.LinkStatsRecordDTO;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.request.LinkPageReqDTO;
import org.jia.mylink.project.dto.request.LinkUpdateReqDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;
import org.jia.mylink.project.dto.response.LinkGroupCountQueryRespDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;

import java.util.List;

/**
 * 短链接服务接口层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public interface LinkService extends IService<LinkDO> {

    /**
     * 创建短链接
     *
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    LinkCreateRespDTO createLink(LinkCreateReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    IPage<LinkPageRespDTO> pageLink(LinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内的数量
     *
     * @param requestParam 短链接分组id集合
     * @return 短链接分组查询响应对象
     */
    List<LinkGroupCountQueryRespDTO> listGroupLinkCount(List<String> requestParam);

    /**
     * 修改短链接
     *
     * @param requestParam 短链接修改请求对象
     */
    void updateLink(LinkUpdateReqDTO requestParam);

    /**
     * 短链接跳转原始链接
     *
     * @param shortUri 短链接后缀
     * @param request  HTTP请求
     * @param response HTTP响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * 短链接统计
     *
     * @param fullShortUrl         完整短链接
     * @param gid                  分组标识
     * @param shortLinkStatsRecord 短链接统计实体参数
     */
    void shortLinkStats(String fullShortUrl, String gid, LinkStatsRecordDTO shortLinkStatsRecord);
}
