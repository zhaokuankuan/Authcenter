CREATE DATABASE `shiro`;

CREATE TABLE `user` (
   `id` varchar(100) NOT NULL,
   `login_name` varchar(100) DEFAULT NULL,
   `real_name` varchar(100) DEFAULT NULL,
   `password` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `role` (
   `id` varchar(100) NOT NULL,
   `name` varchar(100) DEFAULT NULL,
   `code` varchar(100) DEFAULT NULL,
   `sort` tinyint(4) DEFAULT NULL,
   `type` tinyint(4) DEFAULT NULL,
   `remark` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 CREATE TABLE `resource` (
   `id` varchar(100) NOT NULL,
   `resource_name` varchar(100) DEFAULT NULL,
   `type` tinyint(4) DEFAULT NULL,
   `code` varchar(100) DEFAULT NULL,
   `pid` varchar(100) DEFAULT NULL,
   `des` varchar(100) DEFAULT NULL,
   `sort` tinyint(4) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `authority` (
   `id` varchar(100) NOT NULL,
   `name` varchar(100) DEFAULT NULL,
   `code` varchar(100) DEFAULT NULL,
   `url` varchar(100) DEFAULT NULL,
   `method` varchar(100) DEFAULT NULL,
   `controller` varchar(100) DEFAULT NULL,
   `des` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `user_role_r` (
   `id` varchar(100) NOT NULL,
   `user_id` varchar(100) NOT NULL,
   `role_id` varchar(100) DEFAULT NULL,
   `yw_id` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `role_resource_r` (
   `id` varchar(100) NOT NULL,
   `role_id` varchar(100) DEFAULT NULL,
   `resource_id` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `resource_authority_r` (
   `id` varchar(100) NOT NULL,
   `resource_id` varchar(100) DEFAULT NULL,
   `authority_id` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 CREATE TABLE `role_business` (
   `id` varchar(100) NOT NULL,
   `role_id` varchar(100) DEFAULT NULL,
   `class_pk` varchar(100) DEFAULT NULL,
   `class_name` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8


