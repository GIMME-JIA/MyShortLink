use mylink_database;

CREATE TABLE `t_link_access_logs`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `ip`             varchar(64)  DEFAULT NULL COMMENT 'IP',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `locale`         varchar(256) DEFAULT NULL COMMENT '地区',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_access_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `pv`             int(11) DEFAULT NULL COMMENT '访问量',
    `uv`             int(11) DEFAULT NULL COMMENT '独立访客数',
    `uip`            int(11) DEFAULT NULL COMMENT '独立IP数',
    `hour`           int(3) DEFAULT NULL COMMENT '小时',
    `weekday`        int(3) DEFAULT NULL COMMENT '星期',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_access_stats` (`full_short_url`,`gid`,`date`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_browser_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_browser_stats` (`full_short_url`,`gid`,`date`,`browser`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_device_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_browser_stats` (`full_short_url`,`gid`,`date`,`device`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_locale_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家标识',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_locale_stats` (`full_short_url`,`gid`,`date`,`adcode`,`province`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_network_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_browser_stats` (`full_short_url`,`gid`,`date`,`network`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_os_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_os_stats` (`full_short_url`,`gid`,`date`,`os`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;

CREATE TABLE `t_link_stats_today_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;