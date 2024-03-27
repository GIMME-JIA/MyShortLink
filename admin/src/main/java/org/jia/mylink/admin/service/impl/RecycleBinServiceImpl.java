package org.jia.mylink.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.common.biz.UserContext;
import org.jia.mylink.admin.common.convention.exception.ServiceException;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.dao.entity.GroupDO;
import org.jia.mylink.admin.dao.mapper.GroupMapper;
import org.jia.mylink.admin.remote.ShortLinkActualRemoteService;
import org.jia.mylink.admin.remote.dto.request.RecycleBinPageReqDTO;
import org.jia.mylink.admin.remote.dto.response.LinkPageRespDTO;
import org.jia.mylink.admin.service.RecycleBinService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jia.mylink.admin.common.constant.ServiceConstant.DEL_FLAG_0;

/**
 * 回收站服务实现层
 * @author JIA
 * @version 1.0
 * @since 2024/3/17
 */
@Service(value = "recycleBinServiceImplByAdmin")
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements RecycleBinService {


    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    private final GroupMapper groupMapper;


    @Override
    public Result<Page<LinkPageRespDTO>> pageLink(RecycleBinPageReqDTO requestParam) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, DEL_FLAG_0);
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(groupDOList)) {
            throw new ServiceException("用户无分组信息");
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        return shortLinkActualRemoteService.pageRecycleBinShortLink(requestParam.getGidList(), requestParam.getCurrent(), requestParam.getSize());
    }
}
