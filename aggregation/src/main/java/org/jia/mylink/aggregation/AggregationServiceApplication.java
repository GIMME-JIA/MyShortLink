package org.jia.mylink.aggregation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 聚合服务模块启动类
 * @author JIA
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "org.jia.mylink.admin",
        "org.jia.mylink.project"
})
@MapperScan(value = {
        "org.jia.mylink.project.dao.mapper",
        "org.jia.mylink.admin.dao.mapper"
})
public class AggregationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregationServiceApplication.class, args);
    }

}
