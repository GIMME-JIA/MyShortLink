package org.jia.mylink.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * project模块启动类
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */
@SpringBootApplication
@MapperScan("org.jia.mylink.project.dao.mapper")
public class MyLinkProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(org.jia.mylink.project.MyLinkProjectApplication.class, args);
    }
}
