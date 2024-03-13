-- 数据库逻辑结构

-- 创建库mylink_database
drop database if exists mylink_database;
create database if not exists mylink_database;
use mylink_database;


-- 分表前
# drop table if exists t_user;
# CREATE TABLE `t_user` (
#                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
#                           `username` VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
#                           `password` varchar(512) DEFAULT NULL COMMENT '密码',
#                           `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
#                           `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
#                           `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
#                           `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
#                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
#                           `update_time` datetime DEFAULT NULL COMMENT '修改时间',
#                           `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
#                           PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `t_group`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;


CREATE TABLE `t_link` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                          `domain` varchar(128) DEFAULT NULL COMMENT '域名',
                          `short_uri` varchar(8) DEFAULT NULL COMMENT '短链接',
                          `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
                          `origin_url` varchar(1024) DEFAULT NULL COMMENT '原始链接',
                          `click_num` int(11) DEFAULT 0 COMMENT '点击量',
                          `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',
                          `enable_status` tinyint(1) DEFAULT NULL COMMENT '启用标识 （0：启用）（1：未启用）',
                          `created_type` tinyint(1) DEFAULT NULL COMMENT '创建类型 0：控制台 1：接口',
                          `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：用户自定义',
                          `valid_date` datetime DEFAULT NULL COMMENT '有效期',
                          `describe` varchar(1024) DEFAULT NULL COMMENT '描述',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                          `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `idx_unique_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_0`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716344307570487299
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_1`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1726253659068588035
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_10`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1726262175087058946
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_11`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716835884998893571
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_12`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716356833762906114
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_13`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716777589441347586
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_14`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716835562859589634
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_15`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1725312189079834626
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_2`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1726260205890691074
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_3`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716826815625977859
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_4`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716777824704053251
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_5`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716835362095034371
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_6`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716991700406161411
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_7`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1716834641844936706
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_8`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;

CREATE TABLE `t_user_9`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
    `password`      varchar(512)                         DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256)                         DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128)                         DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512)                         DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)                           DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime                             DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                             DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)                           DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1726852231086505986
  DEFAULT CHARSET = utf8mb4;;



CREATE TABLE `t_link_0`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_1`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_10`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_11`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_12`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_13`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_14`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_15`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_2`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_3`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_4`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_5`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_6`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_7`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_8`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_9`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `click_num`       int(11) DEFAULT '0' COMMENT '点击量',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `total_pv`        int(11) DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_time`        bigint(20) DEFAULT '0' COMMENT '删除时间戳',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;