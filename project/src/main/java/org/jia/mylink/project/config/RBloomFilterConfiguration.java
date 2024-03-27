package org.jia.mylink.project.config;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 布隆过滤器配置
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/10
 */
@Configuration(value = "rBloomFilterConfigurationByProject")
public class RBloomFilterConfiguration {
    /**
     * 防止短链接创建查询数据库的布隆过滤器
     */
    @Bean
    public RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter(RedissonClient redissonClient) {
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("shortUriCreateCachePenetrationBloomFilter");
        /*
        tryInit 有两个核心参数：
            ● expectedInsertions：预估布隆过滤器存储的元素长度。设为一亿
            ● falseProbability：运行的误判率。设为0.001
        错误率越低，位数组越长，布隆过滤器的内存占用越大。
        错误率越低，散列 Hash 函数越多，计算耗时较长。
         */
        cachePenetrationBloomFilter.tryInit(100000000L, 0.001);
        return cachePenetrationBloomFilter;
    }
}
