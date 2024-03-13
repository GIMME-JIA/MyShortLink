package org.jia.mylink.project.service.impl;


import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.project.common.convention.exception.ServiceException;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dao.mapper.LinkMapper;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;
import org.jia.mylink.project.service.LinkService;
import org.jia.mylink.project.toolkit.HashUtil;
import org.redisson.api.RBloomFilter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.jia.mylink.project.common.constant.ServiceConstant.ENABLE_STATUS_0;
import static org.jia.mylink.project.common.constant.ServiceConstant.MAX_RETRY;
import static org.jia.mylink.project.common.enums.LinkErrorCodeEnum.LINK_IS_DUPLICATE;
import static org.jia.mylink.project.common.enums.LinkErrorCodeEnum.LINK_OUT_OF_MAX_RETRY;

/**
 * 短链接服务实现层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl extends ServiceImpl<LinkMapper, LinkDO> implements LinkService {

    /**
     * 短链接生成缓存穿透布隆过滤器
     */
    private final RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter;


    @Override
    public LinkCreateRespDTO createLink(LinkCreateReqDTO requestParam) {
        String linkSuffix = generateSuffix(requestParam);

        String fullShortUrl = StrBuilder.create(requestParam.getDomain())
                .append("/")
                .append(linkSuffix)
                .toString();

        LinkDO linkDO = LinkDO.builder()
                .domain(requestParam.getDomain())
                .originUrl(requestParam.getOriginUrl())
                .gid(requestParam.getGid())
                .createdType(requestParam.getCreatedType())
                .validDate(requestParam.getValidDate())
                .validDateType(requestParam.getValidDateType())
                .describe(requestParam.getDescribe())
                .shortUri(linkSuffix)
                .enableStatus(ENABLE_STATUS_0)
                .fullShortUrl(fullShortUrl)
                .build();

        try {
            baseMapper.insert(linkDO);

        } catch (DuplicateKeyException duplicateKeyException) {
            throw new ServiceException(LINK_IS_DUPLICATE);
        }
        shortUriCreateCachePenetrationBloomFilter.add(fullShortUrl);

        return LinkCreateRespDTO.builder()
                .gid(requestParam.getGid())
                .originUrl(linkDO.getOriginUrl())
                .fullShortUrl(linkDO.getFullShortUrl())
                .build();
    }

    /**
     * 生成短链接后缀
     *
     * @param requestParam 短链接创建请求对象：用于获取原始链接
     * @return 短链接后缀
     */
    private String generateSuffix(LinkCreateReqDTO requestParam) {
        int customGenerateCount = 0;
        String shortUri;
        while (true) {
            if (customGenerateCount > MAX_RETRY) {
                throw new ServiceException(LINK_OUT_OF_MAX_RETRY);
            }

            String originUrl = requestParam.getOriginUrl();

            originUrl += UUID.randomUUID().toString();

            shortUri = HashUtil.hashToBase62(originUrl);

            if (!shortUriCreateCachePenetrationBloomFilter.contains(requestParam.getDomain() + "/" + shortUri)) {
                break;
            }

            customGenerateCount++;
        }

        return shortUri;
    }
}
