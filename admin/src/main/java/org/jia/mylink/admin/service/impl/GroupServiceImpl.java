package org.jia.mylink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.admin.dao.entity.GroupDO;
import org.jia.mylink.admin.dao.mapper.GroupMapper;
import org.jia.mylink.admin.service.GroupService;
import org.springframework.stereotype.Service;

/**
 * 分组服务实现层
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

}
