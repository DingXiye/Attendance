/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : attendancedb

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2018-04-24 15:41:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_name` varchar(255) NOT NULL DEFAULT '',
  `admin_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for `tb_class`
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `classid` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES ('1', '14软卓');
INSERT INTO `tb_class` VALUES ('2', '14软一');
INSERT INTO `tb_class` VALUES ('3', '14计卓');
INSERT INTO `tb_class` VALUES ('4', '15软卓');

-- ----------------------------
-- Table structure for `tb_course`
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('1', 'java');
INSERT INTO `tb_course` VALUES ('2', 'C语言');
INSERT INTO `tb_course` VALUES ('3', '数据结构');
INSERT INTO `tb_course` VALUES ('4', '体育');
INSERT INTO `tb_course` VALUES ('5', '操作系统');

-- ----------------------------
-- Table structure for `tb_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_grade`;
CREATE TABLE `tb_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(255) DEFAULT NULL,
  `stu_classname` varchar(255) DEFAULT NULL,
  `stu_grade` varchar(255) DEFAULT NULL,
  `stu_coursename` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_grade
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_student`
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `stu_id` varchar(255) NOT NULL DEFAULT '',
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_password` varchar(255) DEFAULT NULL,
  `stu_registerdate` varchar(255) DEFAULT NULL,
  `stu_classname` varchar(255) DEFAULT NULL,
  `stu_fingerprint` blob,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('s1001', 's1001', 's1001', '2017-10-10', '14计卓', null);
INSERT INTO `tb_student` VALUES ('s1002', 's2', 'p1235', '2017-10-11', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1003', 's3', 'p1236', '2017-10-12', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1004', 'a4', 'p1237', '2017-10-13', '14软一', null);
INSERT INTO `tb_student` VALUES ('s1005', 'a5', 'p1238', '2017-10-14', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1006', 'a6', 'p1239', '2017-10-15', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1007', 'a7', 'p1240', '2017-10-16', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1010', 'a10', 'p1243', '2017-10-19', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1011', 'a11', 'p1244', '2017-10-20', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1012', 'a12', 'p1245', '2017-10-21', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1013', 'a13', 'p1246', '2017-10-22', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1014', 'a14', 'p1247', '2017-10-23', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1015', 'a15', 'p1248', '2017-10-24', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1016', 'a16', 'p1249', '2017-10-25', '15软卓', null);
INSERT INTO `tb_student` VALUES ('s1017', 'dy', 'p1017', '2017-10-11', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1031', 'daop', 's1031', '2018-04-24', '14软卓', null);
INSERT INTO `tb_student` VALUES ('s1040', 'xiye', 's1040', '2018-04-24', '14软卓', null);

-- ----------------------------
-- Table structure for `tb_studentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_studentinfo`;
CREATE TABLE `tb_studentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuinfo_id` varchar(255) DEFAULT NULL,
  `stu_week` int(11) DEFAULT NULL,
  `stu_weekday` varchar(255) DEFAULT NULL,
  `stu_attendance` varchar(255) DEFAULT NULL,
  `stu_remark` varchar(255) DEFAULT NULL,
  `stu_coursename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_studentinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tec_id` varchar(255) DEFAULT NULL,
  `tec_name` varchar(255) DEFAULT NULL,
  `tec_password` varchar(255) DEFAULT NULL,
  `coursename` varchar(255) DEFAULT NULL,
  `classname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '1001', '小鱼', '1234', '体育', '14软卓');
INSERT INTO `tb_teacher` VALUES ('2', '1002', 't2', '1234', '数据结构', '14软一');
