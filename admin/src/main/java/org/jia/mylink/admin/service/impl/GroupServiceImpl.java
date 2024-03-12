package org.jia.mylink.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.admin.common.biz.UserContext;
import org.jia.mylink.admin.common.convention.exception.ClientException;
import org.jia.mylink.admin.dao.entity.GroupDO;
import org.jia.mylink.admin.dao.mapper.GroupMapper;
import org.jia.mylink.admin.service.GroupService;
import org.jia.mylink.admin.toolkit.RandomGenerator;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


import static org.jia.mylink.admin.common.constant.RedisCacheConstant.LOCK_GROUP_CREATE_KEY;
import static org.jia.mylink.admin.common.constant.ServiceConstant.GROUP_MAX_NUMBER;
import static org.jia.mylink.admin.common.constant.ServiceConstant.OUT_OF_GROUP_MAX_NUM;


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

    @Override
    public void saveGroup(String groupName) {
        saveGroup(UserContext.getUsername(),groupName);
    }

    @Override
    public void saveGroup(String username, String groupName) {
        RLock lock = redissonClient.getLock(String.format(LOCK_GROUP_CREATE_KEY, username));

        lock.lock();

        try {
            LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                    .eq(GroupDO::getUsername, username)
                    .eq(GroupDO::getDelFlag, 0);
            List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);

            if(CollUtil.isNotEmpty(groupDOList) && groupDOList.size() == GROUP_MAX_NUMBER){
                throw new ClientException(String.format(OUT_OF_GROUP_MAX_NUM,GROUP_MAX_NUMBER));
            }

            String gid;
            do {
                gid = RandomGenerator.generateRandom();
            }while (!hasGid(username,gid));

            GroupDO groupDO = GroupDO.builder()
                    .gid(gid)
                    .sortOrder(0)
                    .username(username)
                    .name(groupName)
                    .build();

            baseMapper.insert(groupDO);

        }finally {
            lock.unlock();
        }
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
