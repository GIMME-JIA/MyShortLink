package org.jia.mylink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jia.mylink.project.dao.entity.LinkStatsTodayDO;
import org.jia.mylink.project.dao.mapper.LinkStatsTodayMapper;
import org.jia.mylink.project.service.LinkStatsTodayService;
import org.springframework.stereotype.Service;

/**
 * 短链接今日统计持久层
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */
@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {

}
