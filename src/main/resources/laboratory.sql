/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : laboratory

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-04 17:58:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `push_date` datetime DEFAULT NULL,
  `push_man` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
  `enable` int(11) NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `laboratory_seat_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK60r90eyqs046tqbgpt7gqwmer` (`laboratory_seat_id`),
  KEY `FKa8m1smlfsc8kkjn2t6wpdmysk` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of appointment
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `close_date` datetime DEFAULT NULL,
  `col` int(11) NOT NULL,
  `enable` bit(1) NOT NULL,
  `open_date` datetime DEFAULT NULL,
  `row` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsddwgmnjkebj4s0j0jcqoviq2` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', '2018-12-04 17:02:22', '2', '', '2018-12-04 17:02:22', '2', '1');

-- ----------------------------
-- Table structure for laboratory_seat
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_seat`;
CREATE TABLE `laboratory_seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_type` int(11) DEFAULT '1',
  `laboratory_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf0kpc6xunvc028h8ebcak1hvb` (`laboratory_id`),
  KEY `FKiu1k3vopyrn32d5ktvyk24k9h` (`seat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory_seat
-- ----------------------------
INSERT INTO `laboratory_seat` VALUES ('29', '2', '1', '312');
INSERT INTO `laboratory_seat` VALUES ('28', '2', '1', '311');
INSERT INTO `laboratory_seat` VALUES ('27', '2', '1', '302');
INSERT INTO `laboratory_seat` VALUES ('26', '2', '1', '301');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `col_index` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `row_index` int(11) NOT NULL,
  `row_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=401 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('301', '1', 'A1', '1', null);
INSERT INTO `seat` VALUES ('302', '2', 'A2', '1', null);
INSERT INTO `seat` VALUES ('303', '3', 'A3', '1', null);
INSERT INTO `seat` VALUES ('304', '4', 'A4', '1', null);
INSERT INTO `seat` VALUES ('305', '5', 'A5', '1', null);
INSERT INTO `seat` VALUES ('306', '6', 'A6', '1', null);
INSERT INTO `seat` VALUES ('307', '7', 'A7', '1', null);
INSERT INTO `seat` VALUES ('308', '8', 'A8', '1', null);
INSERT INTO `seat` VALUES ('309', '9', 'A9', '1', null);
INSERT INTO `seat` VALUES ('310', '10', 'A10', '1', null);
INSERT INTO `seat` VALUES ('311', '1', 'B1', '2', null);
INSERT INTO `seat` VALUES ('312', '2', 'B2', '2', null);
INSERT INTO `seat` VALUES ('313', '3', 'B3', '2', null);
INSERT INTO `seat` VALUES ('314', '4', 'B4', '2', null);
INSERT INTO `seat` VALUES ('315', '5', 'B5', '2', null);
INSERT INTO `seat` VALUES ('316', '6', 'B6', '2', null);
INSERT INTO `seat` VALUES ('317', '7', 'B7', '2', null);
INSERT INTO `seat` VALUES ('318', '8', 'B8', '2', null);
INSERT INTO `seat` VALUES ('319', '9', 'B9', '2', null);
INSERT INTO `seat` VALUES ('320', '10', 'B10', '2', null);
INSERT INTO `seat` VALUES ('321', '1', 'C1', '3', null);
INSERT INTO `seat` VALUES ('322', '2', 'C2', '3', null);
INSERT INTO `seat` VALUES ('323', '3', 'C3', '3', null);
INSERT INTO `seat` VALUES ('324', '4', 'C4', '3', null);
INSERT INTO `seat` VALUES ('325', '5', 'C5', '3', null);
INSERT INTO `seat` VALUES ('326', '6', 'C6', '3', null);
INSERT INTO `seat` VALUES ('327', '7', 'C7', '3', null);
INSERT INTO `seat` VALUES ('328', '8', 'C8', '3', null);
INSERT INTO `seat` VALUES ('329', '9', 'C9', '3', null);
INSERT INTO `seat` VALUES ('330', '10', 'C10', '3', null);
INSERT INTO `seat` VALUES ('331', '1', 'D1', '4', null);
INSERT INTO `seat` VALUES ('332', '2', 'D2', '4', null);
INSERT INTO `seat` VALUES ('333', '3', 'D3', '4', null);
INSERT INTO `seat` VALUES ('334', '4', 'D4', '4', null);
INSERT INTO `seat` VALUES ('335', '5', 'D5', '4', null);
INSERT INTO `seat` VALUES ('336', '6', 'D6', '4', null);
INSERT INTO `seat` VALUES ('337', '7', 'D7', '4', null);
INSERT INTO `seat` VALUES ('338', '8', 'D8', '4', null);
INSERT INTO `seat` VALUES ('339', '9', 'D9', '4', null);
INSERT INTO `seat` VALUES ('340', '10', 'D10', '4', null);
INSERT INTO `seat` VALUES ('341', '1', 'E1', '5', null);
INSERT INTO `seat` VALUES ('342', '2', 'E2', '5', null);
INSERT INTO `seat` VALUES ('343', '3', 'E3', '5', null);
INSERT INTO `seat` VALUES ('344', '4', 'E4', '5', null);
INSERT INTO `seat` VALUES ('345', '5', 'E5', '5', null);
INSERT INTO `seat` VALUES ('346', '6', 'E6', '5', null);
INSERT INTO `seat` VALUES ('347', '7', 'E7', '5', null);
INSERT INTO `seat` VALUES ('348', '8', 'E8', '5', null);
INSERT INTO `seat` VALUES ('349', '9', 'E9', '5', null);
INSERT INTO `seat` VALUES ('350', '10', 'E10', '5', null);
INSERT INTO `seat` VALUES ('351', '1', 'F1', '6', null);
INSERT INTO `seat` VALUES ('352', '2', 'F2', '6', null);
INSERT INTO `seat` VALUES ('353', '3', 'F3', '6', null);
INSERT INTO `seat` VALUES ('354', '4', 'F4', '6', null);
INSERT INTO `seat` VALUES ('355', '5', 'F5', '6', null);
INSERT INTO `seat` VALUES ('356', '6', 'F6', '6', null);
INSERT INTO `seat` VALUES ('357', '7', 'F7', '6', null);
INSERT INTO `seat` VALUES ('358', '8', 'F8', '6', null);
INSERT INTO `seat` VALUES ('359', '9', 'F9', '6', null);
INSERT INTO `seat` VALUES ('360', '10', 'F10', '6', null);
INSERT INTO `seat` VALUES ('361', '1', 'G1', '7', null);
INSERT INTO `seat` VALUES ('362', '2', 'G2', '7', null);
INSERT INTO `seat` VALUES ('363', '3', 'G3', '7', null);
INSERT INTO `seat` VALUES ('364', '4', 'G4', '7', null);
INSERT INTO `seat` VALUES ('365', '5', 'G5', '7', null);
INSERT INTO `seat` VALUES ('366', '6', 'G6', '7', null);
INSERT INTO `seat` VALUES ('367', '7', 'G7', '7', null);
INSERT INTO `seat` VALUES ('368', '8', 'G8', '7', null);
INSERT INTO `seat` VALUES ('369', '9', 'G9', '7', null);
INSERT INTO `seat` VALUES ('370', '10', 'G10', '7', null);
INSERT INTO `seat` VALUES ('371', '1', 'H1', '8', null);
INSERT INTO `seat` VALUES ('372', '2', 'H2', '8', null);
INSERT INTO `seat` VALUES ('373', '3', 'H3', '8', null);
INSERT INTO `seat` VALUES ('374', '4', 'H4', '8', null);
INSERT INTO `seat` VALUES ('375', '5', 'H5', '8', null);
INSERT INTO `seat` VALUES ('376', '6', 'H6', '8', null);
INSERT INTO `seat` VALUES ('377', '7', 'H7', '8', null);
INSERT INTO `seat` VALUES ('378', '8', 'H8', '8', null);
INSERT INTO `seat` VALUES ('379', '9', 'H9', '8', null);
INSERT INTO `seat` VALUES ('380', '10', 'H10', '8', null);
INSERT INTO `seat` VALUES ('381', '1', 'I1', '9', null);
INSERT INTO `seat` VALUES ('382', '2', 'I2', '9', null);
INSERT INTO `seat` VALUES ('383', '3', 'I3', '9', null);
INSERT INTO `seat` VALUES ('384', '4', 'I4', '9', null);
INSERT INTO `seat` VALUES ('385', '5', 'I5', '9', null);
INSERT INTO `seat` VALUES ('386', '6', 'I6', '9', null);
INSERT INTO `seat` VALUES ('387', '7', 'I7', '9', null);
INSERT INTO `seat` VALUES ('388', '8', 'I8', '9', null);
INSERT INTO `seat` VALUES ('389', '9', 'I9', '9', null);
INSERT INTO `seat` VALUES ('390', '10', 'I10', '9', null);
INSERT INTO `seat` VALUES ('391', '1', 'J1', '10', null);
INSERT INTO `seat` VALUES ('392', '2', 'J2', '10', null);
INSERT INTO `seat` VALUES ('393', '3', 'J3', '10', null);
INSERT INTO `seat` VALUES ('394', '4', 'J4', '10', null);
INSERT INTO `seat` VALUES ('395', '5', 'J5', '10', null);
INSERT INTO `seat` VALUES ('396', '6', 'J6', '10', null);
INSERT INTO `seat` VALUES ('397', '7', 'J7', '10', null);
INSERT INTO `seat` VALUES ('398', '8', 'J8', '10', null);
INSERT INTO `seat` VALUES ('399', '9', 'J9', '10', null);
INSERT INTO `seat` VALUES ('400', '10', 'J10', '10', null);

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
INSERT INTO `student` VALUES ('广州', '计科本', '电信学院', '1');

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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2018-12-04 14:29:29', '', null, '狮子吃咸鱼', '18807772672', 'admin', '1');
