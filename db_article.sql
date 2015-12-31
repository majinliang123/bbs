/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mmm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-31 15:05:33
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
INSERT INTO `db_article` VALUES ('4', '啊', '2015-12-31 14:38:43', '<p>士大夫</p>', '2', '1');
INSERT INTO `db_article` VALUES ('5', '撒旦', '2015-12-31 14:42:04', '<p>阿道夫爱的</p>', '1', '9');
INSERT INTO `db_article` VALUES ('6', '士大夫', '2015-12-31 14:43:20', '<p>日日日</p>', '1', '1');
INSERT INTO `db_article` VALUES ('7', 'adf ', '2015-12-31 14:53:49', '<p>adf a a&nbsp;</p>', '0', '1');
INSERT INTO `db_article` VALUES ('8', '', '2015-12-31 14:54:33', '', '0', '1');
INSERT INTO `db_article` VALUES ('9', '', '2015-12-31 14:56:31', '', '0', '1');
INSERT INTO `db_article` VALUES ('10', '大师傅', '2015-12-31 14:58:58', '<p>大师傅</p>', '0', '1');
INSERT INTO `db_article` VALUES ('11', '为切尔', '2015-12-31 15:00:55', '<p>日日日日日</p>', '2', '1');
