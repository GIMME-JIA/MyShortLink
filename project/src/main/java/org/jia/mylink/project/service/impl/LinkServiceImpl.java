package org.jia.mylink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dao.mapper.LinkMapper;
import org.jia.mylink.project.service.LinkService;
import org.springframework.stereotype.Service;

/**
 * 短链接服务实现层
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl extends ServiceImpl<LinkMapper, LinkDO> implements LinkService {

}
