/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mmm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-31 12:42:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `db_article`
-- ----------------------------
DROP TABLE IF EXISTS `db_article`;
CREATE TABLE `db_article` (
  `aid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(155) NOT NULL DEFAULT '',
  `time` int(10) unsigned NOT NULL DEFAULT '0',
  `content` text,
  `cid` int(10) unsigned NOT NULL DEFAULT '0',
  `id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_article
-- ----------------------------
INSERT INTO `db_article` VALUES ('1', 'title1', '2015', 'content1', '1', '1');
INSERT INTO `db_article` VALUES ('2', 'title2', '2016', 'content2', '1', '1');
