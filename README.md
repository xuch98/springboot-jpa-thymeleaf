# springboot-jpa-thymeleaf
新手上路，在我的博客中有详细记载https://www.cnblogs.com/xuchuan/p/11133917.html

一、开发环境window10 、IDEA 2018.2.4、jdk1.8.0_131、MySQL数据库
二、运行步骤
1.数据库中建表 
create database boot_demo;
use boot_demo;
-- ----------------------------
-- Table structure for `tb_area`
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '区域ID',
  `area_name` varchar(200) DEFAULT NULL COMMENT '区域名称',
  `priority` int(2) DEFAULT '0' COMMENT '优先级',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `uk_area` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('1', '东苑', '1', null, null);
INSERT INTO `tb_area` VALUES ('2', '北苑', '2', null, null);

2.更改配置application.properties中的数据库、用户名、密码。 
3.运行。
