/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mmm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-31 21:28:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `db_category`
-- ----------------------------
DROP TABLE IF EXISTS `db_category`;
CREATE TABLE `db_category` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cname` text,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_category
-- ----------------------------
INSERT INTO `db_category` VALUES ('1', 'c1');
INSERT INTO `db_category` VALUES ('2', 'c2');
INSERT INTO `db_category` VALUES ('21', '啥地方');
INSERT INTO `db_category` VALUES ('26', '撒旦');
INSERT INTO `db_category` VALUES ('23', '阿道夫');
INSERT INTO `db_category` VALUES ('24', '阿达');
