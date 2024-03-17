package org.jia.mylink.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dao.mapper.LinkMapper;
import org.jia.mylink.project.dto.request.LinkRecycleBinPageReqDTO;
import org.jia.mylink.project.dto.request.RecycleBinSaveReqDTO;
import org.jia.mylink.project.dto.response.LinkPageRespDTO;
import org.jia.mylink.project.service.RecycleBinService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import static org.jia.mylink.project.common.constant.RedisCacheConstant.GOTO_SHORT_LINK_KEY;
import static org.jia.mylink.project.common.constant.ServiceConstant.*;

/**
 * 回收站服务实现层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */
@Service
@RequiredArgsConstructor
public class RecycleBinServiceImpl extends ServiceImpl<LinkMapper, LinkDO> implements RecycleBinService {
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void moveToRecycleBin(RecycleBinSaveReqDTO requestParam) {

        LambdaUpdateWrapper<LinkDO> updateWrapper = Wrappers.lambdaUpdate(LinkDO.class)
                .eq(LinkDO::getFullShortUrl, requestParam.getFullShortUrl())
                .eq(LinkDO::getGid, requestParam.getGid())
                .eq(LinkDO::getEnableStatus, ENABLE_STATUS_0)
                .eq(LinkDO::getDelFlag, DEL_FLAG_0);

        LinkDO linkDO = LinkDO.builder()
                .enableStatus(ENABLE_STATUS_1)
                .build();

        baseMapper.update(linkDO, updateWrapper);

        stringRedisTemplate.delete(String.format(GOTO_SHORT_LINK_KEY, requestParam.getFullShortUrl()));
    }

    @Override
    public IPage<LinkPageRespDTO> pageLink(LinkRecycleBinPageReqDTO requestParam) {
        LambdaQueryWrapper<LinkDO> queryWrapper = Wrappers.lambdaQuery(LinkDO.class)
                .in(LinkDO::getGid, requestParam.getGidList())
                .eq(LinkDO::getEnableStatus, ENABLE_STATUS_1)
                .eq(LinkDO::getDelFlag, DEL_FLAG_0)
                .orderByDesc(LinkDO::getUpdateTime);

        IPage<LinkDO> resultPage = baseMapper.selectPage(requestParam,queryWrapper);

        return resultPage.convert(each -> {
            LinkPageRespDTO result = BeanUtil.toBean(each, LinkPageRespDTO.class);
            result.setDomain(PROTOCOL_HTTP + result.getDomain());
            return result;
        });
    }

}
