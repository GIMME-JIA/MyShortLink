package org.jia.mylink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.admin.common.biz.UserContext;
import org.jia.mylink.admin.common.convention.exception.ClientException;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.dao.entity.GroupDO;
import org.jia.mylink.admin.dao.mapper.GroupMapper;
import org.jia.mylink.admin.dto.request.ShortLinkGroupSortReqDTO;
import org.jia.mylink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import org.jia.mylink.admin.dto.response.ShortLinkGroupListRespDTO;
import org.jia.mylink.admin.remote.LinkRemoteService;
import org.jia.mylink.admin.remote.dto.response.LinkGroupCountQueryRespDTO;
import org.jia.mylink.admin.service.GroupService;
import org.jia.mylink.admin.toolkit.RandomGenerator;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.jia.mylink.admin.common.constant.RedisCacheConstant.LOCK_GROUP_CREATE_KEY;
import static org.jia.mylink.admin.common.constant.ServiceConstant.*;


/**
 * 短链接分组服务实现层
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    private final RedissonClient redissonClient;

    // TODO (JIA,2024/3/14,11:57)后续重构为SpringCloud Feign调用
    LinkRemoteService linkRemoteService = new LinkRemoteService(){};

    @Value("${short-link.group.max-num}")
    private Integer groupMaxNum;

    @Override
    public void saveGroup(String groupName) {
        // TODO (JIA,2024/3/14,12:21) 此处获取的用户名为空
        saveGroup(UserContext.getUsername(),groupName);
    }

    @Override
    public void saveGroup(String username, String groupName) {
        RLock lock = redissonClient.getLock(String.format(LOCK_GROUP_CREATE_KEY, username));

        lock.lock();

        try {
            LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                    .eq(GroupDO::getUsername, username)
                    .eq(GroupDO::getDelFlag, DEL_FLAG_0);
            List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);

            if(CollUtil.isNotEmpty(groupDOList) && groupDOList.size() == groupMaxNum){
                throw new ClientException(String.format(OUT_OF_GROUP_MAX_NUM,groupMaxNum));
            }

            String gid;
            do {
                gid = RandomGenerator.generateRandom();
            }while (!hasGid(username,gid));

            GroupDO groupDO = GroupDO.builder()
                    .gid(gid)
                    .sortOrder(SORT_ORDER_0)
                    .username(username)
                    .name(groupName)
                    .build();

            baseMapper.insert(groupDO);

        }finally {
            lock.unlock();
        }
    }

    @Override
    public List<ShortLinkGroupListRespDTO> listGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, DEL_FLAG_0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);

        Result<List<LinkGroupCountQueryRespDTO>> listResult = linkRemoteService
                .listGroupLinkCount(groupDOList.stream().map(GroupDO::getGid).toList());

        List<ShortLinkGroupListRespDTO> shortLinkGroupListRespDTOList = BeanUtil.copyToList(groupDOList, ShortLinkGroupListRespDTO.class);

        shortLinkGroupListRespDTOList.forEach(each -> {
            Optional<LinkGroupCountQueryRespDTO> first = listResult.getData().stream()
                    .filter(item -> Objects.equals(item.getGid(), each.getGid()))
                    .findFirst();
            first.ifPresent(item->each.setShortLinkCount(first.get().getShortLinkCount()));
        });

        return shortLinkGroupListRespDTOList;
    }

    @Override
    public void updateGroup(ShortLinkGroupUpdateReqDTO requestParam) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, requestParam.getGid())
                .eq(GroupDO::getDelFlag, DEL_FLAG_0);

        GroupDO groupDO = new GroupDO();
        groupDO.setName(requestParam.getName());

        baseMapper.update(groupDO, updateWrapper);
    }

    @Override
    public void deleteGroup(String gid) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getDelFlag, DEL_FLAG_0);

        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(DEL_FLAG_1);

        baseMapper.update(groupDO, updateWrapper);
    }

    @Override
    public void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam) {
        requestParam.forEach(shortLink->{
            GroupDO groupDO = GroupDO.builder()
                    .sortOrder(shortLink.getSortOrder())
                    .build();

            LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                    .eq(GroupDO::getUsername, UserContext.getUsername())
                    .eq(GroupDO::getGid, shortLink.getGid())
                    .eq(GroupDO::getDelFlag, DEL_FLAG_0);

            baseMapper.update(groupDO,updateWrapper);
        });
    }


    /**
     * 判断gid是否可用
     * @param username 用户名
     * @param gid id
     * @return true：不存在；false：已存在
     */
    private boolean hasGid(String username, String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, Optional.ofNullable(username).orElse(UserContext.getUsername()));
        GroupDO hasGroupFlag = baseMapper.selectOne(queryWrapper);
        return hasGroupFlag == null;
    }
}
