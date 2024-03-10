-- 数据库逻辑结构

-- 创建库mylink_database
drop database if exists mylink_database;
create database if not exists mylink_database;
use mylink_database;

-- 用户表
drop table if exists t_user;
CREATE TABLE `t_user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                          `username` VARCHAR(256) COMMENT '用户名' UNIQUE DEFAULT NULL,
                          `password` varchar(512) DEFAULT NULL COMMENT '密码',
                          `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                          `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                          `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                          `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                          `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

