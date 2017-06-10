/*
Navicat MySQL Data Transfer

Source Server         : 荣铠
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : hibernate_first

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-06-08 17:08:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('lebron', '333', 'Lebron@163.com', '110', 'Cleveland', '1');
INSERT INTO `user` VALUES ('me', '116', 'me@qq.com', '8860', 'TianChao', '2');
INSERT INTO `user` VALUES ('paul', '666', 'Paul@sina.com', '119', 'New York', '3');
