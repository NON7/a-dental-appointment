/*
Navicat MySQL Data Transfer

Source Server         : doctor
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : doctor

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-03-18 20:52:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrative
-- ----------------------------
DROP TABLE IF EXISTS `administrative`;
CREATE TABLE `administrative` (
  `administrative_id` varchar(30) NOT NULL,
  `administrative_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`administrative_id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- ----------------------------
-- Records of administrative
-- ----------------------------

-- ----------------------------
-- Table structure for booking
-- ----------------------------
DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` varchar(50) NOT NULL,
  `doctor_id` varchar(10) DEFAULT NULL,
  `patient_Id_card` varchar(40) DEFAULT NULL,
  `booking_time` date DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FK_Reference_1` (`doctor_id`),
  KEY `FK_Reference_4` (`patient_Id_card`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`patient_Id_card`) REFERENCES `patient` (`patient_Id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- ----------------------------
-- Records of booking
-- ----------------------------

-- ----------------------------
-- Table structure for consuletinfo
-- ----------------------------
DROP TABLE IF EXISTS `consuletinfo`;
CREATE TABLE `consuletinfo` (
  `doctor_id` varchar(10) NOT NULL,
  `patient_Id_card` varchar(40) NOT NULL,
  `consuletInfo_time` date DEFAULT NULL,
  `consuletInfo_content` text,
  PRIMARY KEY (`patient_Id_card`),
  KEY `FK_Reference_5` (`doctor_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`patient_Id_card`) REFERENCES `patient` (`patient_Id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- ----------------------------
-- Records of consuletinfo
-- ----------------------------

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctor_id` varchar(10) NOT NULL,
  `administrative_id` varchar(30) DEFAULT NULL,
  `doctor_name` varchar(10) DEFAULT NULL,
  `doctor_type_id` varchar(10) DEFAULT NULL,
  `doctor_sex` char(2) DEFAULT NULL,
  `doctor_briefing` text,
  `doctor_pro` text,
  `doctor_resume` text,
  `doctor_age` int(11) DEFAULT NULL,
  `doctor_level` varchar(20) DEFAULT NULL,
  `doctor_headimage` char(10) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `FK_Reference_7` (`administrative_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`administrative_id`) REFERENCES `administrative` (`administrative_id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- ----------------------------
-- Records of doctor
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_title` varchar(60) DEFAULT NULL,
  `news_content` text,
  `news_pubdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patient_id` varchar(30) DEFAULT NULL,
  `patient_name` varchar(10) DEFAULT NULL,
  `patient_password` varchar(30) DEFAULT NULL,
  `patient_Id_card` varchar(40) NOT NULL,
  `patient_sex` varchar(2) DEFAULT NULL,
  `patient_age` int(11) DEFAULT NULL,
  `patient_headImage` char(10) DEFAULT NULL,
  PRIMARY KEY (`patient_Id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('555', null, '555', '', null, null, null);
INSERT INTO `patient` VALUES ('0', null, '0', '0', null, null, null);
INSERT INTO `patient` VALUES ('000', null, '000', '000', null, null, null);
INSERT INTO `patient` VALUES ('1', null, '1', '1', null, null, null);
INSERT INTO `patient` VALUES ('0', null, '23321', '111111111111', null, null, null);
INSERT INTO `patient` VALUES ('123', null, '123', '123', null, null, null);
INSERT INTO `patient` VALUES ('123', null, '123123', '123123123', null, null, null);
INSERT INTO `patient` VALUES (null, null, null, '1234213141232', null, null, null);
INSERT INTO `patient` VALUES ('1', null, '123qwe', '123qwe', null, null, null);
INSERT INTO `patient` VALUES ('13', null, '13', '13', null, null, null);
INSERT INTO `patient` VALUES ('14', null, '14', '14', null, null, null);
INSERT INTO `patient` VALUES ('1414', null, '1414', '1414', null, null, null);
INSERT INTO `patient` VALUES ('132', null, '132', '142', null, null, null);
INSERT INTO `patient` VALUES ('1515', null, '1515', '1515', null, null, null);
INSERT INTO `patient` VALUES ('22', null, '22', '22', null, null, null);
INSERT INTO `patient` VALUES ('3', null, '3', '3', null, null, null);
INSERT INTO `patient` VALUES ('12', null, '12', '31', null, null, null);
INSERT INTO `patient` VALUES ('aa', null, '123456', '321', null, null, null);
INSERT INTO `patient` VALUES ('555', null, '555', '555', null, null, null);
INSERT INTO `patient` VALUES ('cc', null, 'cc', 'cc', null, null, null);
INSERT INTO `patient` VALUES ('q', null, 'q', 'q', null, null, null);
INSERT INTO `patient` VALUES ('qq', null, 'qq', 'qq', null, null, null);
