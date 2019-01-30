/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : laboratory

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-01-30 15:02:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `date` date DEFAULT NULL,
  `push_date` datetime DEFAULT NULL,
  `push_man` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
  `end_date` datetime DEFAULT NULL,
  `minute` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `laboratory_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXr218bwndc7nbylup3ytpntf0l` (`date`),
  KEY `IDX79pykoe4ppbui0q0jpmr1iid5` (`state`),
  KEY `IDXo8xu7qfjleec8gra9x52fcf4j` (`appointment_date`),
  KEY `FKiscjaljj5jmbn14pafyd31ofr` (`laboratory_id`),
  KEY `FKa8m1smlfsc8kkjn2t6wpdmysk` (`user_id`),
  CONSTRAINT `FKa8m1smlfsc8kkjn2t6wpdmysk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKiscjaljj5jmbn14pafyd31ofr` FOREIGN KEY (`laboratory_id`) REFERENCES `laboratory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('1', '2019-01-23 16:00:00', '2019-01-30 13:55:36', '2019-01-23', '2019-01-23 16:30:00', '30', '3', '4', '3');
INSERT INTO `appointment` VALUES ('2', '2019-01-24 09:30:00', '2019-01-30 13:55:39', '2019-01-24', '2019-01-24 10:30:00', '60', '3', '3', '2');
INSERT INTO `appointment` VALUES ('3', '2019-01-23 16:00:00', '2019-01-30 13:55:42', '2019-01-23', '2019-01-23 17:00:00', '60', '3', '2', '1');
INSERT INTO `appointment` VALUES ('4', '2019-01-24 08:00:00', '2019-01-30 13:55:54', '2019-01-24', '2019-01-24 09:00:00', '60', '3', '2', '2');
INSERT INTO `appointment` VALUES ('5', '2019-01-24 08:30:00', '2019-01-30 13:56:05', '2019-01-24', '2019-01-24 10:00:00', '90', '3', '4', '1');
INSERT INTO `appointment` VALUES ('6', '2019-01-25 09:00:00', '2019-01-30 13:56:08', '2019-01-25', '2019-01-25 11:00:00', '120', '3', '1', '1');
INSERT INTO `appointment` VALUES ('7', '2019-02-01 08:00:00', '2019-01-30 13:57:12', '2019-02-01', '2019-02-01 09:00:00', '60', '1', '4', '1');

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
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK60cytjkc8syd35oandgi38hrp` (`laboratory_id`),
  KEY `FKlxlm2octv83r6g7kkfxc9iwbi` (`user`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK60cytjkc8syd35oandgi38hrp` FOREIGN KEY (`laboratory_id`) REFERENCES `laboratory` (`id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKlxlm2octv83r6g7kkfxc9iwbi` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', 'adadada', '2019-01-29 10:24:50', '1', null, '2');
INSERT INTO `comment` VALUES ('3', 'adasdad', '2019-01-29 10:25:03', '1', null, '1');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `available_type` int(11) NOT NULL,
  `close_date` datetime DEFAULT NULL,
  `col` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_date` datetime DEFAULT NULL,
  `row` int(11) NOT NULL,
  `seat_count` int(11) NOT NULL,
  `laboratory_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtq8rf9iclpnmp5ya54u2jpvk9` (`laboratory_type_id`),
  KEY `FKsddwgmnjkebj4s0j0jcqoviq2` (`user_id`),
  CONSTRAINT `FKsddwgmnjkebj4s0j0jcqoviq2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKtq8rf9iclpnmp5ya54u2jpvk9` FOREIGN KEY (`laboratory_type_id`) REFERENCES `laboratory_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', '东区', '1', null, '0', '力学', '', '力学实验室一号', '2019-01-23 15:41:18', '0', '22', '1', '2');
INSERT INTO `laboratory` VALUES ('2', '西区', '1', null, '0', 'PH', '', '酸碱实验室', '2019-01-23 15:41:50', '0', '29', '2', '2');
INSERT INTO `laboratory` VALUES ('3', '东区', '1', null, '0', '不可描述', '', '细胞实验室', '2019-01-23 15:42:18', '0', '28', '3', '2');
INSERT INTO `laboratory` VALUES ('4', '海洋楼', '1', null, '0', 'asdasdad', '', '水质实验室', '2019-01-30 14:00:22', '0', '29', '4', '2');

-- ----------------------------
-- Table structure for laboratory_type
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_type`;
CREATE TABLE `laboratory_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of laboratory_type
-- ----------------------------
INSERT INTO `laboratory_type` VALUES ('1', '物理');
INSERT INTO `laboratory_type` VALUES ('2', '化学');
INSERT INTO `laboratory_type` VALUES ('3', '生物');
INSERT INTO `laboratory_type` VALUES ('4', '海洋');
INSERT INTO `laboratory_type` VALUES ('5', '数学');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `class_grade` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, null, '1', '狮子', '123', '18807772672', null, 'cz', '1');
INSERT INTO `user` VALUES ('2', null, null, null, '0', '王八蛋', '123', '1111', null, 'wbd', '2');
INSERT INTO `user` VALUES ('3', null, null, null, '1', 'mayday', '7788', '13197670831', null, 'mayday', '1');
INSERT INTO `user` VALUES ('4', null, null, null, '1', '管理员', 'admin', '13122208991', null, 'admin', '3');
INSERT INTO `user` VALUES ('5', null, null, '经管', '0', '杨老师', '111111', '18797538082', '讲师', 'yang', '2');

-- ----------------------------
-- Table structure for user_comment_list
-- ----------------------------
DROP TABLE IF EXISTS `user_comment_list`;
CREATE TABLE `user_comment_list` (
  `user_id` int(11) NOT NULL,
  `comment_list_id` int(11) NOT NULL,
  UNIQUE KEY `UK_dhc0x6ua9l4ci8h775hrhy2fg` (`comment_list_id`),
  KEY `FKlvon4q0hemo8ouluqcedbci3l` (`user_id`),
  CONSTRAINT `FKa4yfb1tuv3i38ihs5sqew09nu` FOREIGN KEY (`comment_list_id`) REFERENCES `comment` (`id`),
  CONSTRAINT `FKlvon4q0hemo8ouluqcedbci3l` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user_comment_list
-- ----------------------------

-- ----------------------------
-- View structure for appointment_info_view
-- ----------------------------
DROP VIEW IF EXISTS `appointment_info_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `appointment_info_view` AS (select `ap`.`id` AS `id`,`ap`.`appointment_date` AS `appointment_date`,`ap`.`end_date` AS `end_date`,`ap`.`date` AS `date`,`ap`.`state` AS `state`,`ap`.`minute` AS `minute`,`lb`.`name` AS `name`,`lb`.`seat_count` AS `seat_count`,`lb`.`id` AS `laboratoryId`,`lb`.`available_type` AS `available_type`,`type`.`name` AS `laboratoryType`,`type`.`id` AS `laboratoryTypeId` from ((`appointment` `ap` left join `laboratory` `lb` on((`ap`.`laboratory_id` = `lb`.`id`))) left join `laboratory_type` `type` on((`lb`.`laboratory_type_id` = `type`.`id`)))) ;
