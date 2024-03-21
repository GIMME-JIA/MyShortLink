package org.jia.mylink.project.mq.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.jia.mylink.project.common.constant.RedisCacheConstant.SHORT_LINK_STATS_STREAM_TOPIC_KEY;

/**
 * 短链接监控状态保存消息队列生产者
 * @author JIA
 * @version 1.0
 * @since 2024/3/20
 */
@Component
@RequiredArgsConstructor
public class ShortLinkStatsSaveProducer {
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 发送延迟消费短链接统计
     */
    public void send(Map<String, String> producerMap) {
        stringRedisTemplate.opsForStream().add(SHORT_LINK_STATS_STREAM_TOPIC_KEY, producerMap);
    }
}
