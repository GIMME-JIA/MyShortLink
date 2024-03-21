package org.jia.mylink.project.mq.producer;

import cn.hutool.core.lang.UUID;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.project.dto.biz.LinkStatsRecordDTO;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static org.jia.mylink.project.common.constant.RedisCacheConstant.DELAY_QUEUE_STATS_KEY;

/**
 * 延迟消费短链接统计发送者
 * @author JIA
 * @version 1.0
 * @since 2024/3/20
 */
@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsProducer {

    private final RedissonClient redissonClient;

    /**
     * 发送延迟消费短链接统计
     *
     * @param statsRecord 短链接统计实体参数
     */
    public void send(LinkStatsRecordDTO statsRecord) {
        statsRecord.setKeys(UUID.fastUUID().toString());
        RBlockingDeque<LinkStatsRecordDTO> blockingDeque = redissonClient.getBlockingDeque(DELAY_QUEUE_STATS_KEY);
        RDelayedQueue<LinkStatsRecordDTO> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
        delayedQueue.offer(statsRecord, 5, TimeUnit.SECONDS);
    }
}
