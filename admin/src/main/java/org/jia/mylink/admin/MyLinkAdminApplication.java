package org.jia.mylink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * admin模块启动类
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/7
 */
@SpringBootApplication
@MapperScan("org.jia.mylink.admin.dao.mapper")
public class MyLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(org.jia.mylink.admin.MyLinkAdminApplication.class, args);
    }
}

