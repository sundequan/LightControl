/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : light

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-06-24 10:48:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '公司名字',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话号码多个逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '桐梓林北路2号', '四川易简天下股份有限公司', '13882525256');
INSERT INTO `company` VALUES ('3', '桐梓林北路3号', '四川易简天下股份有限公司', '13882525253');
INSERT INTO `company` VALUES ('4', '桐梓林北路4号', '百度限公司', '13882525254');
INSERT INTO `company` VALUES ('5', '桐梓林北路5号', '京东份有限公司', '13882525255');
INSERT INTO `company` VALUES ('6', '桐梓林北路6号', '淘宝份有限公司', '13882525256');
