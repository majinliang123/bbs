/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mmm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-31 21:28:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `db_discuss`
-- ----------------------------
DROP TABLE IF EXISTS `db_discuss`;
CREATE TABLE `db_discuss` (
  `did` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(155) NOT NULL DEFAULT '',
  `time` varchar(155) NOT NULL DEFAULT '',
  `aid` int(10) unsigned NOT NULL DEFAULT '0',
  `id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_discuss
-- ----------------------------
INSERT INTO `db_discuss` VALUES ('10', '请问', '2015-12-31 12:30:28', '1', '0');
INSERT INTO `db_discuss` VALUES ('11', '爱的', '2015-12-31 12:31:36', '2', '0');
INSERT INTO `db_discuss` VALUES ('12', '位', '2015-12-31 12:35:10', '1', '0');
INSERT INTO `db_discuss` VALUES ('13', '为切尔', '2015-12-31 12:35:57', '1', '1');
INSERT INTO `db_discuss` VALUES ('14', '位', '2015-12-31 12:36:24', '2', '9');
INSERT INTO `db_discuss` VALUES ('15', '曲儿', '2015-12-31 12:36:35', '2', '9');
INSERT INTO `db_discuss` VALUES ('16', '按时', '2015-12-31 12:39:24', '2', '9');
INSERT INTO `db_discuss` VALUES ('17', '为切尔', '2015-12-31 12:39:35', '1', '9');
INSERT INTO `db_discuss` VALUES ('18', '阿道夫', '2015-12-31 12:41:21', '1', '1');
INSERT INTO `db_discuss` VALUES ('19', '日日日', '2015-12-31 12:41:28', '1', '1');
INSERT INTO `db_discuss` VALUES ('20', '我喜欢一个', '2015-12-31 13:54:14', '1', '1');
INSERT INTO `db_discuss` VALUES ('21', '阿道夫', '2015-12-31 14:42:20', '4', '9');
