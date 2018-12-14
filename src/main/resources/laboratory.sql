/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : laboratory

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-12-14 21:44:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `push_date` time DEFAULT NULL,
  `push_man` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of appointment
-- ----------------------------

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `close_date` datetime DEFAULT NULL,
  `col` int(11) NOT NULL,
  `enable` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `open_date` datetime DEFAULT NULL,
  `row` int(11) NOT NULL,
  `laboratory_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtq8rf9iclpnmp5ya54u2jpvk9` (`laboratory_type_id`),
  KEY `FKsddwgmnjkebj4s0j0jcqoviq2` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', '2018-12-14 10:18:20', '5', '', '物理一号实验室', '2018-12-14 10:18:20', '5', '1', '1');
INSERT INTO `laboratory` VALUES ('2', '2018-12-14 10:20:22', '8', '', '化学一号', '2018-12-14 10:20:22', '8', '2', '1');

-- ----------------------------
-- Table structure for laboratory_seat
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_seat`;
CREATE TABLE `laboratory_seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_type` int(11) DEFAULT '1',
  `laboratory_id` int(11) DEFAULT NULL,
  `seat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf0kpc6xunvc028h8ebcak1hvb` (`laboratory_id`),
  KEY `FKiu1k3vopyrn32d5ktvyk24k9h` (`seat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of laboratory_seat
-- ----------------------------
INSERT INTO `laboratory_seat` VALUES ('1', '1', '1', '1');
INSERT INTO `laboratory_seat` VALUES ('2', '1', '1', '2');
INSERT INTO `laboratory_seat` VALUES ('3', '1', '1', '3');
INSERT INTO `laboratory_seat` VALUES ('4', '1', '1', '4');
INSERT INTO `laboratory_seat` VALUES ('5', '1', '1', '5');
INSERT INTO `laboratory_seat` VALUES ('6', '1', '1', '11');
INSERT INTO `laboratory_seat` VALUES ('7', '1', '1', '12');
INSERT INTO `laboratory_seat` VALUES ('8', '1', '1', '13');
INSERT INTO `laboratory_seat` VALUES ('9', '1', '1', '14');
INSERT INTO `laboratory_seat` VALUES ('10', '1', '1', '15');
INSERT INTO `laboratory_seat` VALUES ('11', '1', '1', '21');
INSERT INTO `laboratory_seat` VALUES ('12', '1', '1', '22');
INSERT INTO `laboratory_seat` VALUES ('13', '1', '1', '23');
INSERT INTO `laboratory_seat` VALUES ('14', '1', '1', '24');
INSERT INTO `laboratory_seat` VALUES ('15', '1', '1', '25');
INSERT INTO `laboratory_seat` VALUES ('16', '1', '1', '31');
INSERT INTO `laboratory_seat` VALUES ('17', '1', '1', '32');
INSERT INTO `laboratory_seat` VALUES ('18', '1', '1', '33');
INSERT INTO `laboratory_seat` VALUES ('19', '1', '1', '34');
INSERT INTO `laboratory_seat` VALUES ('20', '1', '1', '35');
INSERT INTO `laboratory_seat` VALUES ('21', '1', '1', '41');
INSERT INTO `laboratory_seat` VALUES ('22', '1', '1', '42');
INSERT INTO `laboratory_seat` VALUES ('23', '1', '1', '43');
INSERT INTO `laboratory_seat` VALUES ('24', '1', '1', '44');
INSERT INTO `laboratory_seat` VALUES ('25', '1', '1', '45');
INSERT INTO `laboratory_seat` VALUES ('26', '1', '1', '101');
INSERT INTO `laboratory_seat` VALUES ('27', '1', '2', '1');
INSERT INTO `laboratory_seat` VALUES ('28', '1', '2', '2');
INSERT INTO `laboratory_seat` VALUES ('29', '1', '2', '3');
INSERT INTO `laboratory_seat` VALUES ('30', '1', '2', '4');
INSERT INTO `laboratory_seat` VALUES ('31', '1', '2', '5');
INSERT INTO `laboratory_seat` VALUES ('32', '1', '2', '6');
INSERT INTO `laboratory_seat` VALUES ('33', '1', '2', '7');
INSERT INTO `laboratory_seat` VALUES ('34', '1', '2', '8');
INSERT INTO `laboratory_seat` VALUES ('35', '1', '2', '11');
INSERT INTO `laboratory_seat` VALUES ('36', '1', '2', '12');
INSERT INTO `laboratory_seat` VALUES ('37', '1', '2', '13');
INSERT INTO `laboratory_seat` VALUES ('38', '1', '2', '14');
INSERT INTO `laboratory_seat` VALUES ('39', '1', '2', '15');
INSERT INTO `laboratory_seat` VALUES ('40', '1', '2', '16');
INSERT INTO `laboratory_seat` VALUES ('41', '1', '2', '17');
INSERT INTO `laboratory_seat` VALUES ('42', '1', '2', '18');
INSERT INTO `laboratory_seat` VALUES ('43', '1', '2', '21');
INSERT INTO `laboratory_seat` VALUES ('44', '1', '2', '22');
INSERT INTO `laboratory_seat` VALUES ('45', '1', '2', '23');
INSERT INTO `laboratory_seat` VALUES ('46', '1', '2', '24');
INSERT INTO `laboratory_seat` VALUES ('47', '1', '2', '25');
INSERT INTO `laboratory_seat` VALUES ('48', '1', '2', '26');
INSERT INTO `laboratory_seat` VALUES ('49', '1', '2', '27');
INSERT INTO `laboratory_seat` VALUES ('50', '1', '2', '28');
INSERT INTO `laboratory_seat` VALUES ('51', '1', '2', '31');
INSERT INTO `laboratory_seat` VALUES ('52', '1', '2', '32');
INSERT INTO `laboratory_seat` VALUES ('53', '1', '2', '33');
INSERT INTO `laboratory_seat` VALUES ('54', '1', '2', '34');
INSERT INTO `laboratory_seat` VALUES ('55', '1', '2', '35');
INSERT INTO `laboratory_seat` VALUES ('56', '1', '2', '36');
INSERT INTO `laboratory_seat` VALUES ('57', '1', '2', '37');
INSERT INTO `laboratory_seat` VALUES ('58', '1', '2', '38');
INSERT INTO `laboratory_seat` VALUES ('59', '1', '2', '41');
INSERT INTO `laboratory_seat` VALUES ('60', '1', '2', '42');
INSERT INTO `laboratory_seat` VALUES ('61', '1', '2', '43');
INSERT INTO `laboratory_seat` VALUES ('62', '1', '2', '44');
INSERT INTO `laboratory_seat` VALUES ('63', '1', '2', '45');
INSERT INTO `laboratory_seat` VALUES ('64', '1', '2', '46');
INSERT INTO `laboratory_seat` VALUES ('65', '1', '2', '47');
INSERT INTO `laboratory_seat` VALUES ('66', '1', '2', '48');
INSERT INTO `laboratory_seat` VALUES ('67', '1', '2', '51');
INSERT INTO `laboratory_seat` VALUES ('68', '1', '2', '52');
INSERT INTO `laboratory_seat` VALUES ('69', '1', '2', '53');
INSERT INTO `laboratory_seat` VALUES ('70', '1', '2', '54');
INSERT INTO `laboratory_seat` VALUES ('71', '1', '2', '55');
INSERT INTO `laboratory_seat` VALUES ('72', '1', '2', '56');
INSERT INTO `laboratory_seat` VALUES ('73', '1', '2', '57');
INSERT INTO `laboratory_seat` VALUES ('74', '1', '2', '58');
INSERT INTO `laboratory_seat` VALUES ('75', '1', '2', '61');
INSERT INTO `laboratory_seat` VALUES ('76', '1', '2', '62');
INSERT INTO `laboratory_seat` VALUES ('77', '1', '2', '63');
INSERT INTO `laboratory_seat` VALUES ('78', '1', '2', '64');
INSERT INTO `laboratory_seat` VALUES ('79', '1', '2', '65');
INSERT INTO `laboratory_seat` VALUES ('80', '1', '2', '66');
INSERT INTO `laboratory_seat` VALUES ('81', '1', '2', '67');
INSERT INTO `laboratory_seat` VALUES ('82', '1', '2', '68');
INSERT INTO `laboratory_seat` VALUES ('83', '1', '2', '71');
INSERT INTO `laboratory_seat` VALUES ('84', '1', '2', '72');
INSERT INTO `laboratory_seat` VALUES ('85', '1', '2', '73');
INSERT INTO `laboratory_seat` VALUES ('86', '1', '2', '74');
INSERT INTO `laboratory_seat` VALUES ('87', '1', '2', '75');
INSERT INTO `laboratory_seat` VALUES ('88', '1', '2', '76');
INSERT INTO `laboratory_seat` VALUES ('89', '1', '2', '77');
INSERT INTO `laboratory_seat` VALUES ('90', '1', '2', '78');
INSERT INTO `laboratory_seat` VALUES ('91', '1', '2', '101');

-- ----------------------------
-- Table structure for laboratory_type
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_type`;
CREATE TABLE `laboratory_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of laboratory_type
-- ----------------------------
INSERT INTO `laboratory_type` VALUES ('1', '物理');
INSERT INTO `laboratory_type` VALUES ('2', '化学');
INSERT INTO `laboratory_type` VALUES ('3', '生物');
INSERT INTO `laboratory_type` VALUES ('4', '数学');
INSERT INTO `laboratory_type` VALUES ('5', '海洋');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `col_index` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `row_index` int(11) NOT NULL,
  `row_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('1', '1', 'A1', '1', null);
INSERT INTO `seat` VALUES ('2', '2', 'A2', '1', null);
INSERT INTO `seat` VALUES ('3', '3', 'A3', '1', null);
INSERT INTO `seat` VALUES ('4', '4', 'A4', '1', null);
INSERT INTO `seat` VALUES ('5', '5', 'A5', '1', null);
INSERT INTO `seat` VALUES ('6', '6', 'A6', '1', null);
INSERT INTO `seat` VALUES ('7', '7', 'A7', '1', null);
INSERT INTO `seat` VALUES ('8', '8', 'A8', '1', null);
INSERT INTO `seat` VALUES ('9', '9', 'A9', '1', null);
INSERT INTO `seat` VALUES ('10', '10', 'A10', '1', null);
INSERT INTO `seat` VALUES ('11', '1', 'B1', '2', null);
INSERT INTO `seat` VALUES ('12', '2', 'B2', '2', null);
INSERT INTO `seat` VALUES ('13', '3', 'B3', '2', null);
INSERT INTO `seat` VALUES ('14', '4', 'B4', '2', null);
INSERT INTO `seat` VALUES ('15', '5', 'B5', '2', null);
INSERT INTO `seat` VALUES ('16', '6', 'B6', '2', null);
INSERT INTO `seat` VALUES ('17', '7', 'B7', '2', null);
INSERT INTO `seat` VALUES ('18', '8', 'B8', '2', null);
INSERT INTO `seat` VALUES ('19', '9', 'B9', '2', null);
INSERT INTO `seat` VALUES ('20', '10', 'B10', '2', null);
INSERT INTO `seat` VALUES ('21', '1', 'C1', '3', null);
INSERT INTO `seat` VALUES ('22', '2', 'C2', '3', null);
INSERT INTO `seat` VALUES ('23', '3', 'C3', '3', null);
INSERT INTO `seat` VALUES ('24', '4', 'C4', '3', null);
INSERT INTO `seat` VALUES ('25', '5', 'C5', '3', null);
INSERT INTO `seat` VALUES ('26', '6', 'C6', '3', null);
INSERT INTO `seat` VALUES ('27', '7', 'C7', '3', null);
INSERT INTO `seat` VALUES ('28', '8', 'C8', '3', null);
INSERT INTO `seat` VALUES ('29', '9', 'C9', '3', null);
INSERT INTO `seat` VALUES ('30', '10', 'C10', '3', null);
INSERT INTO `seat` VALUES ('31', '1', 'D1', '4', null);
INSERT INTO `seat` VALUES ('32', '2', 'D2', '4', null);
INSERT INTO `seat` VALUES ('33', '3', 'D3', '4', null);
INSERT INTO `seat` VALUES ('34', '4', 'D4', '4', null);
INSERT INTO `seat` VALUES ('35', '5', 'D5', '4', null);
INSERT INTO `seat` VALUES ('36', '6', 'D6', '4', null);
INSERT INTO `seat` VALUES ('37', '7', 'D7', '4', null);
INSERT INTO `seat` VALUES ('38', '8', 'D8', '4', null);
INSERT INTO `seat` VALUES ('39', '9', 'D9', '4', null);
INSERT INTO `seat` VALUES ('40', '10', 'D10', '4', null);
INSERT INTO `seat` VALUES ('41', '1', 'E1', '5', null);
INSERT INTO `seat` VALUES ('42', '2', 'E2', '5', null);
INSERT INTO `seat` VALUES ('43', '3', 'E3', '5', null);
INSERT INTO `seat` VALUES ('44', '4', 'E4', '5', null);
INSERT INTO `seat` VALUES ('45', '5', 'E5', '5', null);
INSERT INTO `seat` VALUES ('46', '6', 'E6', '5', null);
INSERT INTO `seat` VALUES ('47', '7', 'E7', '5', null);
INSERT INTO `seat` VALUES ('48', '8', 'E8', '5', null);
INSERT INTO `seat` VALUES ('49', '9', 'E9', '5', null);
INSERT INTO `seat` VALUES ('50', '10', 'E10', '5', null);
INSERT INTO `seat` VALUES ('51', '1', 'F1', '6', null);
INSERT INTO `seat` VALUES ('52', '2', 'F2', '6', null);
INSERT INTO `seat` VALUES ('53', '3', 'F3', '6', null);
INSERT INTO `seat` VALUES ('54', '4', 'F4', '6', null);
INSERT INTO `seat` VALUES ('55', '5', 'F5', '6', null);
INSERT INTO `seat` VALUES ('56', '6', 'F6', '6', null);
INSERT INTO `seat` VALUES ('57', '7', 'F7', '6', null);
INSERT INTO `seat` VALUES ('58', '8', 'F8', '6', null);
INSERT INTO `seat` VALUES ('59', '9', 'F9', '6', null);
INSERT INTO `seat` VALUES ('60', '10', 'F10', '6', null);
INSERT INTO `seat` VALUES ('61', '1', 'G1', '7', null);
INSERT INTO `seat` VALUES ('62', '2', 'G2', '7', null);
INSERT INTO `seat` VALUES ('63', '3', 'G3', '7', null);
INSERT INTO `seat` VALUES ('64', '4', 'G4', '7', null);
INSERT INTO `seat` VALUES ('65', '5', 'G5', '7', null);
INSERT INTO `seat` VALUES ('66', '6', 'G6', '7', null);
INSERT INTO `seat` VALUES ('67', '7', 'G7', '7', null);
INSERT INTO `seat` VALUES ('68', '8', 'G8', '7', null);
INSERT INTO `seat` VALUES ('69', '9', 'G9', '7', null);
INSERT INTO `seat` VALUES ('70', '10', 'G10', '7', null);
INSERT INTO `seat` VALUES ('71', '1', 'H1', '8', null);
INSERT INTO `seat` VALUES ('72', '2', 'H2', '8', null);
INSERT INTO `seat` VALUES ('73', '3', 'H3', '8', null);
INSERT INTO `seat` VALUES ('74', '4', 'H4', '8', null);
INSERT INTO `seat` VALUES ('75', '5', 'H5', '8', null);
INSERT INTO `seat` VALUES ('76', '6', 'H6', '8', null);
INSERT INTO `seat` VALUES ('77', '7', 'H7', '8', null);
INSERT INTO `seat` VALUES ('78', '8', 'H8', '8', null);
INSERT INTO `seat` VALUES ('79', '9', 'H9', '8', null);
INSERT INTO `seat` VALUES ('80', '10', 'H10', '8', null);
INSERT INTO `seat` VALUES ('81', '1', 'I1', '9', null);
INSERT INTO `seat` VALUES ('82', '2', 'I2', '9', null);
INSERT INTO `seat` VALUES ('83', '3', 'I3', '9', null);
INSERT INTO `seat` VALUES ('84', '4', 'I4', '9', null);
INSERT INTO `seat` VALUES ('85', '5', 'I5', '9', null);
INSERT INTO `seat` VALUES ('86', '6', 'I6', '9', null);
INSERT INTO `seat` VALUES ('87', '7', 'I7', '9', null);
INSERT INTO `seat` VALUES ('88', '8', 'I8', '9', null);
INSERT INTO `seat` VALUES ('89', '9', 'I9', '9', null);
INSERT INTO `seat` VALUES ('90', '10', 'I10', '9', null);
INSERT INTO `seat` VALUES ('91', '1', 'J1', '10', null);
INSERT INTO `seat` VALUES ('92', '2', 'J2', '10', null);
INSERT INTO `seat` VALUES ('93', '3', 'J3', '10', null);
INSERT INTO `seat` VALUES ('94', '4', 'J4', '10', null);
INSERT INTO `seat` VALUES ('95', '5', 'J5', '10', null);
INSERT INTO `seat` VALUES ('96', '6', 'J6', '10', null);
INSERT INTO `seat` VALUES ('97', '7', 'J7', '10', null);
INSERT INTO `seat` VALUES ('98', '8', 'J8', '10', null);
INSERT INTO `seat` VALUES ('99', '9', 'J9', '10', null);
INSERT INTO `seat` VALUES ('100', '10', 'J10', '10', null);
INSERT INTO `seat` VALUES ('101', '0', null, '0', null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `address` varchar(255) DEFAULT NULL,
  `class_grade` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('广州', '计科', '电信', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `department` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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
  `gender` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2018-12-14 09:20:54', '1', '狮子吃咸鱼', 'cz', '18807772672', 'cz', '1');
