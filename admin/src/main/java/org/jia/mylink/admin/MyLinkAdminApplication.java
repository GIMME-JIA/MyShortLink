package org.jia.mylink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * admin模块启动类
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("org.jia.mylink.admin.remote")
@MapperScan("org.jia.mylink.admin.dao.mapper")
public class MyLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(org.jia.mylink.admin.MyLinkAdminApplication.class, args);
    }
}

