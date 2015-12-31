/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mmm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-31 21:28:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `db_article`
-- ----------------------------
DROP TABLE IF EXISTS `db_article`;
CREATE TABLE `db_article` (
  `aid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(155) NOT NULL DEFAULT '',
  `time` varchar(155) NOT NULL DEFAULT '',
  `content` text,
  `cid` int(10) unsigned NOT NULL DEFAULT '0',
  `id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_article
-- ----------------------------
INSERT INTO `db_article` VALUES ('7', 'adf ', '2015-12-31 14:53:49', '<p>adf a a&nbsp;</p>', '0', '1');
INSERT INTO `db_article` VALUES ('11', '为切尔', '2015-12-31 15:00:55', '<p>日日日日日</p>', '2', '1');
