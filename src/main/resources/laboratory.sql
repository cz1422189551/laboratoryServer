/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : laboratory

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-12-20 20:20:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `push_date` time DEFAULT NULL,
  `push_man` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of announcement
-- ----------------------------

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` int(11) NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `minute` int(11) NOT NULL,
  `laboratory_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXr218bwndc7nbylup3ytpntf0l` (`date`),
  KEY `IDXo8xu7qfjleec8gra9x52fcf4j` (`appointment_date`),
  KEY `FKiscjaljj5jmbn14pafyd31ofr` (`laboratory_id`),
  KEY `FKa8m1smlfsc8kkjn2t6wpdmysk` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('47', '2018-12-21 09:00:00', '2018-12-20 17:22:05', '2018-12-21', '1', '2018-12-21 10:00:00', '60', '1', '2');
INSERT INTO `appointment` VALUES ('48', '2018-12-21 10:00:00', '2018-12-20 17:25:37', '2018-12-21', '1', '2018-12-21 11:00:00', '60', '1', '1');
INSERT INTO `appointment` VALUES ('49', '2018-12-24 08:30:00', '2018-12-20 19:54:42', '2018-12-24', '-1', '2018-12-24 09:00:00', '30', '1', '1');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `close_date` datetime DEFAULT NULL,
  `col` int(11) NOT NULL,
  `enable` bit(1) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_date` datetime DEFAULT NULL,
  `row` int(11) NOT NULL,
  `seat_count` int(11) NOT NULL,
  `laboratory_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `available_type` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtq8rf9iclpnmp5ya54u2jpvk9` (`laboratory_type_id`),
  KEY `FKsddwgmnjkebj4s0j0jcqoviq2` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', '2018-12-18 16:49:32', '5', '', '物理一号楼', '2018-12-18 16:48:23', '5', '1', '1', '3', '1', null);
INSERT INTO `laboratory` VALUES ('2', '2018-12-18 16:49:40', '8', '', '化学一号', '2018-12-18 16:49:49', '8', '64', '2', '3', '2', null);

-- ----------------------------
-- Table structure for laboratory_type
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_type`;
CREATE TABLE `laboratory_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory_type
-- ----------------------------
INSERT INTO `laboratory_type` VALUES ('1', '物理');
INSERT INTO `laboratory_type` VALUES ('2', '化学');
INSERT INTO `laboratory_type` VALUES ('3', '生物');
INSERT INTO `laboratory_type` VALUES ('4', '海洋');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `class_grade` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('上海', '计科', '电信', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `department` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('电信', '教授', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2018-12-18 10:35:30', '1', 'HelloWorld8133', 'cz', '18807772673', 'cz', '1');
INSERT INTO `user` VALUES ('2', '2018-12-18 10:40:19', '2', '哈哈', 'q', '13197670831', 'q', '2');
INSERT INTO `user` VALUES ('3', '2018-12-18 16:48:50', '1', 'admin', 'admin', '18807772672', 'admin', '3');
