/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50724
Source Host           : 132.232.119.142:3306
Source Database       : laboratory

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-24 10:49:37
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
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('1', '物理实验室1号开放', '2018-12-22 18:55:52', 'admin', '物理实验室1号开放');
INSERT INTO `announcement` VALUES ('2', '物理实验室2号开放', '2018-12-22 18:56:20', 'admin', '物理实验室2号开放');
INSERT INTO `announcement` VALUES ('4', '公告1', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告1');
INSERT INTO `announcement` VALUES ('5', '公告2', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告2');
INSERT INTO `announcement` VALUES ('6', '公告3', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告3');
INSERT INTO `announcement` VALUES ('7', '公告4', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告4');
INSERT INTO `announcement` VALUES ('8', '公告5', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告5');
INSERT INTO `announcement` VALUES ('9', '公告6', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告6');
INSERT INTO `announcement` VALUES ('10', '公告7', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告7');
INSERT INTO `announcement` VALUES ('11', '公告8', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告8');
INSERT INTO `announcement` VALUES ('12', '公告9', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告9');
INSERT INTO `announcement` VALUES ('13', '公告10', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告10');
INSERT INTO `announcement` VALUES ('14', '公告11', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告11');
INSERT INTO `announcement` VALUES ('15', '公告12', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告12');
INSERT INTO `announcement` VALUES ('16', '公告13', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告13');
INSERT INTO `announcement` VALUES ('17', '公告14', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告14');
INSERT INTO `announcement` VALUES ('18', '公告15', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告15');
INSERT INTO `announcement` VALUES ('19', '公告16', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告16');
INSERT INTO `announcement` VALUES ('20', '公告17', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告17');
INSERT INTO `announcement` VALUES ('21', '公告18', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告18');
INSERT INTO `announcement` VALUES ('22', '公告19', '2018-12-22 23:11:04', '狮子吃咸鱼', '公告19');

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
  KEY `FKa8m1smlfsc8kkjn2t6wpdmysk` (`user_id`),
  KEY `IDX79pykoe4ppbui0q0jpmr1iid5` (`state`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('47', '2018-12-21 09:00:00', '2018-12-20 17:22:00', '2018-12-21', '-1', '2018-12-21 10:00:00', '60', '1', '2');
INSERT INTO `appointment` VALUES ('48', '2018-12-21 10:00:00', '2018-12-20 17:25:00', '2018-12-21', '-1', '2018-12-21 11:00:00', '60', '1', '1');
INSERT INTO `appointment` VALUES ('49', '2018-12-24 08:30:00', '2018-12-20 19:54:00', '2018-12-24', '2', '2018-12-24 09:00:00', '30', '1', '1');
INSERT INTO `appointment` VALUES ('50', '2018-12-24 09:00:00', '2018-12-23 02:41:00', '2018-12-24', '-1', '2018-12-24 10:00:00', '60', '1', '1');
INSERT INTO `appointment` VALUES ('51', '2018-12-24 09:00:00', '2018-12-23 02:48:00', '2018-12-24', '-1', '2018-12-24 10:00:00', '60', '1', '1');
INSERT INTO `appointment` VALUES ('52', '2018-12-24 09:00:00', '2018-12-23 13:25:00', '2018-12-24', '2', '2018-12-24 09:30:00', '30', '1', '5');
INSERT INTO `appointment` VALUES ('53', '2018-12-24 09:30:00', '2018-12-23 14:03:00', '2018-12-24', '2', '2018-12-24 10:30:00', '60', '2', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `laboratory_id` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK60cytjkc8syd35oandgi38hrp` (`laboratory_id`),
  KEY `FKlxlm2octv83r6g7kkfxc9iwbi` (`user`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('15', '评论1', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('16', '评论2', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('17', '评论3', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('18', '评论4', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('19', '评论5', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('20', '评论6', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('21', '评论7', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('22', '评论8', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('23', '评论9', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('24', '评论10', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('25', '评论11', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('26', '评论12', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('27', '评论13', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('28', '评论14', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('29', '评论15', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('30', '评论16', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('31', '评论17', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('32', '评论18', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('33', '评论19', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('34', '评论20', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('35', '评论21', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('36', '评论22', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('37', '评论23', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('38', '评论24', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('39', '😂', '2018-12-22 23:32:30', '1', '1');
INSERT INTO `comment` VALUES ('92', '器材过于陈旧，建议换新', '2018-12-23 03:10:00', '2', '2');
INSERT INTO `comment` VALUES ('93', '望早日对学生开放', '2018-12-23 03:17:00', '2', '1');
INSERT INTO `comment` VALUES ('94', 'hi', '2018-12-23 13:33:00', '1', '1');
INSERT INTO `comment` VALUES ('95', '希望有一天你能明白对齐的重要性', '2018-12-23 13:33:00', '2', '6');
INSERT INTO `comment` VALUES ('96', '还行吧，很整齐了', '2018-12-23 13:34:00', '2', '1');
INSERT INTO `comment` VALUES ('97', '真的吗？', '2018-12-23 13:58:00', '2', '6');
INSERT INTO `comment` VALUES ('98', '哈哈我明白了', '2018-12-23 17:48:00', '1', '1');
INSERT INTO `comment` VALUES ('99', '嘻嘻', '2018-12-23 17:48:00', '2', '1');

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
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtq8rf9iclpnmp5ya54u2jpvk9` (`laboratory_type_id`),
  KEY `FKsddwgmnjkebj4s0j0jcqoviq2` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', '2018-12-18 16:49:32', '5', '', '物理一号楼', '2018-12-18 16:48:23', '5', '20', '1', '3', '1', '力学实验', '西区八十八栋');
INSERT INTO `laboratory` VALUES ('2', '2018-12-18 16:49:40', '8', '', '化学一号', '2018-12-18 16:49:49', '8', '64', '2', '3', '2', '温度实验', '西区九十九栋');

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
-- Table structure for laboratory_type_laboratory_list
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_type_laboratory_list`;
CREATE TABLE `laboratory_type_laboratory_list` (
  `laboratory_type_id` int(11) NOT NULL,
  `laboratory_list_id` int(11) NOT NULL,
  UNIQUE KEY `UK_p1tl8acp6djqk48pl7usrf65s` (`laboratory_list_id`),
  KEY `FKpyuc6ay3aw0v6ukl4ei2nwiqp` (`laboratory_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory_type_laboratory_list
-- ----------------------------

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
INSERT INTO `student` VALUES ('220', '钢琴', '音乐', '4');
INSERT INTO `student` VALUES ('208', '计科143', '电信学院', '5');
INSERT INTO `student` VALUES ('218', '计科143', '计算机', '6');

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
  `gender` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '狮子吃咸鱼', 'cz', '18807772222', 'cz', '1');
INSERT INTO `user` VALUES ('2', '1', '杨老师', 'q', '13197670831', 'q', '2');
INSERT INTO `user` VALUES ('3', '1', 'admin', 'admin', '18807772672', 'admin', '3');
INSERT INTO `user` VALUES ('4', '1', '周杰伦', 'zjl', '123456789991', 'zjl', '1');
INSERT INTO `user` VALUES ('5', '1', 'Cos', '123456', '18807772646', '123', '1');
INSERT INTO `user` VALUES ('6', '1', '黄世鹏', 'huang', '18878616954', 'fcpglss', '1');

-- ----------------------------
-- Table structure for user_comment_list
-- ----------------------------
DROP TABLE IF EXISTS `user_comment_list`;
CREATE TABLE `user_comment_list` (
  `user_id` int(11) NOT NULL,
  `comment_list_id` int(11) NOT NULL,
  UNIQUE KEY `UK_dhc0x6ua9l4ci8h775hrhy2fg` (`comment_list_id`),
  KEY `FKlvon4q0hemo8ouluqcedbci3l` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user_comment_list
-- ----------------------------
