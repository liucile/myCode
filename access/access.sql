/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : access

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-10 11:16:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `privilage`
-- ----------------------------
DROP TABLE IF EXISTS `privilage`;
CREATE TABLE `privilage` (
  `privilage_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pname` varchar(32) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`privilage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of privilage
-- ----------------------------
INSERT INTO `privilage` VALUES ('1', 'index_button_user', '/access/index/user');
INSERT INTO `privilage` VALUES ('2', 'index_button_admin', '/access/index/admin');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rname` varchar(32) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', 'user');
INSERT INTO `role` VALUES ('2', '管理员', 'admin');

-- ----------------------------
-- Table structure for `role_privilage`
-- ----------------------------
DROP TABLE IF EXISTS `role_privilage`;
CREATE TABLE `role_privilage` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `privilage_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_privilage_id` (`role_id`),
  KEY `privilage_role_id` (`privilage_id`),
  CONSTRAINT `privilage_role_id` FOREIGN KEY (`privilage_id`) REFERENCES `privilage` (`privilage_id`),
  CONSTRAINT `role_privilage_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of role_privilage
-- ----------------------------
INSERT INTO `role_privilage` VALUES ('1', '1', '1');
INSERT INTO `role_privilage` VALUES ('2', '2', '2');
INSERT INTO `role_privilage` VALUES ('3', '2', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL,
  `uname` varchar(16) NOT NULL,
  `upwd` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', 'user');
INSERT INTO `user` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_user_id` (`role_id`),
  KEY `user_role_id` (`user_id`),
  CONSTRAINT `role_user_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_role_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
