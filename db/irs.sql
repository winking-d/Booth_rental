/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : irs

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-04-11 18:05:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `salt` varchar(5) DEFAULT '',
  `fullname` varchar(50) NOT NULL COMMENT '全名',
  `e_mail` varchar(100) DEFAULT NULL,
  `sex` varchar(1) NOT NULL COMMENT '性别：0女，1男,2保密',
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL COMMENT '地址',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_admin_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, 'arthur', 'duxiaod@qq.com', '1', '1994-11-08', '陕西省西安市雁塔区', '17693109997', '1');
INSERT INTO `tb_admin` VALUES ('18', 'test', 'e10adc3949ba59abbe56e057f20f883e', null, 'test', 'test@test.com', '1', '2018-02-25', '甘肃省兰州市榆中县和平镇', '17601038192', '61');

-- ----------------------------
-- Table structure for tb_carousel
-- ----------------------------
DROP TABLE IF EXISTS `tb_carousel`;
CREATE TABLE `tb_carousel` (
  `id` tinyint(8) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) NOT NULL,
  `imgLink` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `sorting` int(10) NOT NULL,
  `status` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_carousel
-- ----------------------------
INSERT INTO `tb_carousel` VALUES ('8', '01edd799479b404b91c39d24689a09981204.png', 'http://localhost:8080/irs/index.jsp', '百姓关心的环境问题 习近平给出最新答案', '200', '0', '2018-05-20 23:36:49', '2018-11-21 17:00:08');
INSERT INTO `tb_carousel` VALUES ('11', '870fb2e3549340419f9db685258f67394265.jpg', 'http://localhost:8080/irs_maven/index.jsp', 'test', '23', '1', '2018-08-21 17:08:49', '2018-09-19 16:53:16');
INSERT INTO `tb_carousel` VALUES ('12', '1c7a37a6e71a4a1d8f38537377ed7ff46987.jpg', 'http://localhost:8080/irs_maven/index.jsp', '2222', '34', '1', '2018-09-19 16:54:16', '2018-10-14 13:39:28');
INSERT INTO `tb_carousel` VALUES ('13', 'd21a9593a3434cd781d2cd13d09f52091808.png', 'http://localhost:8080/irs/index.jsp', '2323', '23', '1', '2018-12-11 20:15:06', null);
INSERT INTO `tb_carousel` VALUES ('14', '020b601fc41c4d8d9102b3e5e9e6bfda6285.png', 'http://123.com', '1233333', '32', '1', '2018-12-11 20:17:20', null);
INSERT INTO `tb_carousel` VALUES ('15', 'bfa6a44518b442e4907c2fd9d1a6b43c6704.jpg', 'http://localhost:8080/ssm/index.jsp', '123123', '2', '1', '2018-12-11 20:38:24', null);

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `operation` varchar(50) NOT NULL COMMENT '操作',
  `method` varchar(100) DEFAULT NULL COMMENT '执行方法',
  `params` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=786 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_log
-- ----------------------------
INSERT INTO `tb_log` VALUES ('701', 'admin', '更新轮播图状态', '/ssm/carousel/update/11/0', '11;0;', '0:0:0:0:0:0:0:1', '2018-09-19 16:53:04');
INSERT INTO `tb_log` VALUES ('702', 'admin', '更新轮播图状态', '/ssm/carousel/update/11/1', '11;1;', '0:0:0:0:0:0:0:1', '2018-09-19 16:53:07');
INSERT INTO `tb_log` VALUES ('703', 'admin', '更新轮播图状态', '/ssm/carousel/update/11/0', '11;0;', '0:0:0:0:0:0:0:1', '2018-09-19 16:53:11');
INSERT INTO `tb_log` VALUES ('704', 'admin', '更新轮播图状态', '/ssm/carousel/update/11/1', '11;1;', '0:0:0:0:0:0:0:1', '2018-09-19 16:53:16');
INSERT INTO `tb_log` VALUES ('705', 'admin', '删除指定的轮播图', '/ssm/carousel/delete', '10;', '0:0:0:0:0:0:0:1', '2018-09-19 16:53:47');
INSERT INTO `tb_log` VALUES ('706', 'admin', '添加轮播信息', '/ssm/carousel/save', 'com.irs.pojo.TbCarousel@7abd9b;', '0:0:0:0:0:0:0:1', '2018-09-19 16:54:16');
INSERT INTO `tb_log` VALUES ('707', '系统自动任务', '定时删除日志：329条', '', '', '', '2018-09-07 00:00:00');
INSERT INTO `tb_log` VALUES ('708', 'admin', '更新管理员信息', '/ssm/sys/updAdmin', '{\"id\":18,\"username\":\"test\",\"password\":null,\"salt\":null,\"fullname\":\"test\",\"eMail\":\"test@test.com\",\"sex\":\"1\",\"birthday\":\"2018-02-25\",\"address\":\"甘肃省兰州市榆中县和平镇\",\"phone\":\"17601038192\",\"roleId\":62,\"roleName\":null};', '0:0:0:0:0:0:0:1', '2018-10-07 19:55:39');
INSERT INTO `tb_log` VALUES ('709', 'admin', '添加用户', '/ssm/user/insUser', '{\"uid\":null,\"eMail\":\"duxiaod@qq.com\",\"nickname\":\"tttt\",\"password\":\"tttttt\",\"sex\":\"1\",\"birthday\":\"2018-10-04\",\"address\":\"t\",\"phone\":\"17111111111\",\"eCode\":null,\"status\":null,\"createTime\":null};', '0:0:0:0:0:0:0:1', '2018-10-09 11:31:16');
INSERT INTO `tb_log` VALUES ('710', 'admin', '更新轮播图', '/ssm/carousel/update', '{\"id\":12,\"imgurl\":\"1c7a37a6e71a4a1d8f38537377ed7ff46987.jpg\",\"imglink\":\"http://localhost:8080/irs_maven/index.jsp\",\"remark\":\"2222\",\"sorting\":34,\"status\":1,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-10-14 13:39:27');
INSERT INTO `tb_log` VALUES ('711', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,59\";', '0:0:0:0:0:0:0:1', '2018-10-16 11:21:42');
INSERT INTO `tb_log` VALUES ('712', 'admin', '更新轮播图状态', '/ssm/carousel/update/8/0', '8;0;', '0:0:0:0:0:0:0:1', '2018-10-16 11:35:17');
INSERT INTO `tb_log` VALUES ('713', 'admin', '更新轮播图', '/ssm/carousel/update', '{\"id\":8,\"imgurl\":\"01edd799479b404b91c39d24689a09981204.png\",\"imglink\":\"http://localhost:8080/irs/index.jsp\",\"remark\":\"百姓关心的环境问题 习近平给出最新答案\",\"sorting\":200,\"status\":0,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-10-16 11:35:35');
INSERT INTO `tb_log` VALUES ('714', 'admin', '根据ID删除用户', '/ssm/user/delUserByUid/31', '\"31\";', '0:0:0:0:0:0:0:1', '2018-10-16 11:37:22');
INSERT INTO `tb_log` VALUES ('715', 'admin', '添加用户', '/ssm/user/insUser', '{\"uid\":null,\"eMail\":\"593151321@qq.com\",\"nickname\":\"2323\",\"password\":\"6hcjQTquG5sE\",\"sex\":\"1\",\"birthday\":\"2018-10-16\",\"address\":\"23232222222\",\"phone\":\"11111111111\",\"eCode\":null,\"status\":null,\"createTime\":null};', '0:0:0:0:0:0:0:1', '2018-10-16 11:37:55');
INSERT INTO `tb_log` VALUES ('716', 'admin', '删除指定角色信息', '/ssm/sys/delRole/62', '62;', '0:0:0:0:0:0:0:1', '2018-10-16 11:43:32');
INSERT INTO `tb_log` VALUES ('717', 'admin', '删除指定角色信息', '/ssm/sys/delRole/63', '63;', '0:0:0:0:0:0:0:1', '2018-10-16 11:43:34');
INSERT INTO `tb_log` VALUES ('718', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";', '0:0:0:0:0:0:0:1', '2018-10-16 11:44:12');
INSERT INTO `tb_log` VALUES ('719', 'admin', '更新管理员信息', '/ssm/sys/updAdmin', '{\"id\":18,\"username\":\"test\",\"password\":null,\"salt\":null,\"fullname\":\"test\",\"eMail\":\"test@test.com\",\"sex\":\"1\",\"birthday\":\"2018-02-25\",\"address\":\"甘肃省兰州市榆中县和平镇\",\"phone\":\"17601038192\",\"roleId\":61,\"roleName\":null};', '0:0:0:0:0:0:0:1', '2018-10-16 11:44:22');
INSERT INTO `tb_log` VALUES ('720', 'admin', '更新管理员信息', '/ssm/sys/updAdmin', '{\"id\":1,\"username\":\"admin\",\"password\":null,\"salt\":null,\"fullname\":\"arthur\",\"eMail\":\"duxiaod@qq.com\",\"sex\":\"1\",\"birthday\":\"1994-11-08\",\"address\":\"陕西省西安市雁塔区\",\"phone\":\"17693109997\",\"roleId\":1,\"roleName\":null};', '0:0:0:0:0:0:0:1', '2018-10-16 11:44:30');
INSERT INTO `tb_log` VALUES ('721', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";', '0:0:0:0:0:0:0:1', '2018-10-16 11:47:37');
INSERT INTO `tb_log` VALUES ('722', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":61,\"roleName\":\"test1\",\"roleRemark\":\"test1\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";', '0:0:0:0:0:0:0:1', '2018-10-17 09:15:50');
INSERT INTO `tb_log` VALUES ('723', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":61,\"roleName\":\"你好\",\"roleRemark\":\"你好\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";', '0:0:0:0:0:0:0:1', '2018-10-17 09:29:00');
INSERT INTO `tb_log` VALUES ('724', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";', '0:0:0:0:0:0:0:1', '2018-10-17 09:29:22');
INSERT INTO `tb_log` VALUES ('725', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/57', '57;', '0:0:0:0:0:0:0:1', '2018-10-17 09:33:34');
INSERT INTO `tb_log` VALUES ('726', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/58', '58;', '0:0:0:0:0:0:0:1', '2018-10-17 09:33:42');
INSERT INTO `tb_log` VALUES ('727', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/59', '59;', '0:0:0:0:0:0:0:1', '2018-10-17 09:33:48');
INSERT INTO `tb_log` VALUES ('728', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/57', '57;', '0:0:0:0:0:0:0:1', '2018-10-17 09:33:52');
INSERT INTO `tb_log` VALUES ('729', 'admin', '更新轮播图状态', '/ssm/carousel/update/8/1', '8;1;', '0:0:0:0:0:0:0:1', '2018-10-17 09:37:07');
INSERT INTO `tb_log` VALUES ('730', 'admin', '更新轮播图状态', '/ssm/carousel/update/8/0', '8;0;', '0:0:0:0:0:0:0:1', '2018-10-17 09:37:09');
INSERT INTO `tb_log` VALUES ('731', 'admin', '更新轮播图', '/ssm/carousel/update', '{\"id\":8,\"imgurl\":\"01edd799479b404b91c39d24689a09981204.png\",\"imglink\":\"http://localhost:8080/irs/index.jsp\",\"remark\":\"百姓关心的环境问题 习近平给出最新答案\",\"sorting\":200,\"status\":0,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-10-17 09:37:16');
INSERT INTO `tb_log` VALUES ('732', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"232\",\"icon\":\"\",\"href\":\"\",\"perms\":\"2323\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:39:30');
INSERT INTO `tb_log` VALUES ('733', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-10-17 16:45:36');
INSERT INTO `tb_log` VALUES ('734', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理1\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:48:05');
INSERT INTO `tb_log` VALUES ('735', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理1\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:48:21');
INSERT INTO `tb_log` VALUES ('736', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:48:34');
INSERT INTO `tb_log` VALUES ('737', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":14,\"title\":\"test\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:48:54');
INSERT INTO `tb_log` VALUES ('738', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/61', '61;', '0:0:0:0:0:0:0:1', '2018-10-17 16:49:03');
INSERT INTO `tb_log` VALUES ('739', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理2\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:49:23');
INSERT INTO `tb_log` VALUES ('740', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":3,\"title\":\"角色管理1\",\"icon\":\"\",\"href\":\"sys/roleList\",\"perms\":\"\",\"spread\":null,\"parentId\":2,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:53:16');
INSERT INTO `tb_log` VALUES ('741', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":3,\"title\":\"角色管理1\",\"icon\":\"\",\"href\":\"sys/roleList\",\"perms\":\"\",\"spread\":null,\"parentId\":2,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:53:26');
INSERT INTO `tb_log` VALUES ('742', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":14,\"title\":\"test\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:53:40');
INSERT INTO `tb_log` VALUES ('743', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":14,\"title\":\"test\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:53:47');
INSERT INTO `tb_log` VALUES ('744', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"test\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:53:59');
INSERT INTO `tb_log` VALUES ('745', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 16:54:08');
INSERT INTO `tb_log` VALUES ('746', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理1\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 17:03:17');
INSERT INTO `tb_log` VALUES ('747', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"test\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 17:03:27');
INSERT INTO `tb_log` VALUES ('748', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":15,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-17 17:03:38');
INSERT INTO `tb_log` VALUES ('749', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":14,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-10-17 17:03:46');
INSERT INTO `tb_log` VALUES ('750', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":3,\"title\":\"角色管理\",\"icon\":\"\",\"href\":\"sys/roleList\",\"perms\":\"\",\"spread\":null,\"parentId\":2,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-10-18 11:50:54');
INSERT INTO `tb_log` VALUES ('751', 'admin', '批量删除用户', '/ssm/user/delUsers/32', '\"32\";', '0:0:0:0:0:0:0:1', '2018-10-18 11:52:34');
INSERT INTO `tb_log` VALUES ('752', 'admin', '添加用户', '/ssm/user/insUser', '{\"uid\":null,\"eMail\":\"593151321@qq.com\",\"nickname\":\"fsdf\",\"password\":\"fQAgwm3DEX2E\",\"sex\":\"1\",\"birthday\":\"2018-10-18\",\"address\":\"2331\",\"phone\":\"11111111111\",\"eCode\":null,\"status\":null,\"createTime\":null};', '0:0:0:0:0:0:0:1', '2018-10-18 11:52:52');
INSERT INTO `tb_log` VALUES ('753', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"123\",\"icon\":\"layui-icon-username\",\"href\":\"213\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":12,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:19:03');
INSERT INTO `tb_log` VALUES ('754', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"2323\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":23,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:22:04');
INSERT INTO `tb_log` VALUES ('755', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/63', '63;', '0:0:0:0:0:0:0:1', '2018-11-13 16:22:16');
INSERT INTO `tb_log` VALUES ('756', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/64', '64;', '0:0:0:0:0:0:0:1', '2018-11-13 16:22:34');
INSERT INTO `tb_log` VALUES ('757', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"23123\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":123,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:22:39');
INSERT INTO `tb_log` VALUES ('758', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":65,\"title\":\"23123\",\"icon\":\"\",\"href\":\"23\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":123,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:22:54');
INSERT INTO `tb_log` VALUES ('759', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":65,\"title\":\"123214\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:27:06');
INSERT INTO `tb_log` VALUES ('760', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/66', '66;', '0:0:0:0:0:0:0:1', '2018-11-13 16:27:17');
INSERT INTO `tb_log` VALUES ('761', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/65', '65;', '0:0:0:0:0:0:0:1', '2018-11-13 16:27:22');
INSERT INTO `tb_log` VALUES ('762', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"2313\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:27:33');
INSERT INTO `tb_log` VALUES ('763', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"2\",\"icon\":\"layui-icon-refresh-3\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:41:01');
INSERT INTO `tb_log` VALUES ('764', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/68', '68;', '0:0:0:0:0:0:0:1', '2018-11-13 16:44:09');
INSERT INTO `tb_log` VALUES ('765', 'admin', '删除菜单信息', '/ssm/sys/delMenuById/67', '67;', '0:0:0:0:0:0:0:1', '2018-11-13 16:44:13');
INSERT INTO `tb_log` VALUES ('766', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":0,\"title\":\"123\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:44:21');
INSERT INTO `tb_log` VALUES ('767', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,69\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:45:30');
INSERT INTO `tb_log` VALUES ('768', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":52,\"title\":\"轮播管理\",\"icon\":\"\",\"href\":\"carousel/carouselList\",\"perms\":\"\",\"spread\":null,\"parentId\":51,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-11-13 16:48:15');
INSERT INTO `tb_log` VALUES ('769', 'admin', '鏇存柊杞挱鍥剧姸鎬�', '/ssm/carousel/update/8/1', '8;1;', '0:0:0:0:0:0:0:1', '2018-11-21 17:00:06');
INSERT INTO `tb_log` VALUES ('770', 'admin', '鏇存柊杞挱鍥剧姸鎬�', '/ssm/carousel/update/8/0', '8;0;', '0:0:0:0:0:0:0:1', '2018-11-21 17:00:07');
INSERT INTO `tb_log` VALUES ('771', 'admin', '添加轮播信息', '/ssm/carousel/save', '{\"id\":null,\"imgurl\":\"d21a9593a3434cd781d2cd13d09f52091808.png\",\"imglink\":\"http://localhost:8080/irs/index.jsp\",\"remark\":\"2323\",\"sorting\":23,\"status\":1,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-12-11 20:15:06');
INSERT INTO `tb_log` VALUES ('772', 'admin', '添加轮播信息', '/ssm/carousel/save', '{\"id\":null,\"imgurl\":\"020b601fc41c4d8d9102b3e5e9e6bfda6285.png\",\"imglink\":\"http://123.com\",\"remark\":\"1233333\",\"sorting\":32,\"status\":1,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-12-11 20:17:19');
INSERT INTO `tb_log` VALUES ('773', 'admin', '添加轮播信息', '/ssm/carousel/save', '{\"id\":null,\"imgurl\":\"bfa6a44518b442e4907c2fd9d1a6b43c6704.jpg\",\"imglink\":\"http://localhost:8080/ssm/index.jsp\",\"remark\":\"123123\",\"sorting\":2,\"status\":1,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-12-11 20:38:23');
INSERT INTO `tb_log` VALUES ('774', 'admin', '添加轮播信息', '/ssm/carousel/save', '{\"id\":null,\"imgurl\":\"c6cff9ee8e144af3b423e33c78d8c0863365.png\",\"imglink\":\"http://localhost:8080/ssm/index.jsp\",\"remark\":\"12312\",\"sorting\":213,\"status\":1,\"createTime\":null,\"updateTime\":null};', '0:0:0:0:0:0:0:1', '2018-12-11 20:42:10');
INSERT INTO `tb_log` VALUES ('775', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":69,\"title\":\"多数据源\",\"icon\":\"\",\"href\":\"dynamic/db\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:45:51');
INSERT INTO `tb_log` VALUES ('776', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":69,\"title\":\"多数据源\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:46:20');
INSERT INTO `tb_log` VALUES ('777', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":69,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/db\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:46:40');
INSERT INTO `tb_log` VALUES ('778', 'admin', '更新角色信息', '/ssm/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,69,70\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:46:55');
INSERT INTO `tb_log` VALUES ('779', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":70,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/page/1\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:48:16');
INSERT INTO `tb_log` VALUES ('780', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":70,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/page\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:56:45');
INSERT INTO `tb_log` VALUES ('781', 'admin', '维护菜单信息', '/ssm/sys/menuForm', '{\"menuId\":70,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/page/1\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2018-12-12 12:59:54');
INSERT INTO `tb_log` VALUES ('782', 'admin', '鏇存柊绠＄悊鍛樹俊鎭�', '/ssm/sys/updAdmin', '{\"id\":1,\"username\":\"admin\",\"password\":null,\"salt\":null,\"fullname\":\"arthur\",\"eMail\":\"duxiaod@qq.com\",\"sex\":\"1\",\"birthday\":\"1994-11-08\",\"address\":\"陕西省西安市雁塔区\",\"phone\":\"17693109997\",\"roleId\":1,\"roleName\":null};', '0:0:0:0:0:0:0:1', '2018-12-29 16:50:16');
INSERT INTO `tb_log` VALUES ('783', 'admin', '更新管理员信息', '/irs-maven/sys/updAdmin', '{\"id\":18,\"username\":\"test\",\"password\":null,\"salt\":null,\"fullname\":\"test\",\"eMail\":\"test@test.com\",\"sex\":\"1\",\"birthday\":\"2018-02-25\",\"address\":\"甘肃省兰州市榆中县和平镇\",\"phone\":\"17601038192\",\"roleId\":61,\"roleName\":null};', '0:0:0:0:0:0:0:1', '2019-03-19 17:53:06');
INSERT INTO `tb_log` VALUES ('784', 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":0,\"title\":\"接口工具\",\"icon\":\"\",\"href\":\"swagger-ui.html\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":500,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-04-11 17:56:21');
INSERT INTO `tb_log` VALUES ('785', 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,69,70,71\";', '0:0:0:0:0:0:0:1', '2019-04-11 17:56:34');

-- ----------------------------
-- Table structure for tb_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_menus`;
CREATE TABLE `tb_menus` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '菜单名',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `href` varchar(100) DEFAULT NULL COMMENT '资源地址',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限',
  `spread` varchar(10) NOT NULL COMMENT 'true：展开，false：不展开',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  `sorting` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menus
-- ----------------------------
INSERT INTO `tb_menus` VALUES ('1', '后台首页', '', 'page/main.html', '', 'false', '0', '9999');
INSERT INTO `tb_menus` VALUES ('2', '管理员管理', '', '', '', 'false', '0', '999');
INSERT INTO `tb_menus` VALUES ('3', '角色管理', '', 'sys/roleList', '', 'false', '2', '99');
INSERT INTO `tb_menus` VALUES ('4', '管理员列表', '&#xe613;', 'sys/adminList', null, 'false', '2', '98');
INSERT INTO `tb_menus` VALUES ('9', '用户管理', '&#xe61d;', null, null, 'false', '0', '998');
INSERT INTO `tb_menus` VALUES ('10', '添加用户', '&#xe608;', 'user/addUser', null, 'false', '9', null);
INSERT INTO `tb_menus` VALUES ('11', '管理用户', '&#xe60e;', 'user/userList', null, 'false', '9', null);
INSERT INTO `tb_menus` VALUES ('14', '系统日志', '&#xe61d;', null, null, 'false', '0', '995');
INSERT INTO `tb_menus` VALUES ('15', '日志管理', '', 'log/logList', '', 'false', '14', null);
INSERT INTO `tb_menus` VALUES ('16', '查看', '', '', 'sys:role:list', 'false', '3', null);
INSERT INTO `tb_menus` VALUES ('17', '新增', null, null, 'sys:role:save', 'false', '3', null);
INSERT INTO `tb_menus` VALUES ('18', '修改', null, null, 'sys:role:update', 'false', '3', null);
INSERT INTO `tb_menus` VALUES ('19', '删除', null, null, 'sys:role:delete', 'false', '3', null);
INSERT INTO `tb_menus` VALUES ('20', '查看', null, null, 'sys:admin:list', 'false', '4', null);
INSERT INTO `tb_menus` VALUES ('21', '新增', null, null, 'sys:admin:save', 'false', '4', null);
INSERT INTO `tb_menus` VALUES ('22', '修改', null, null, 'sys:admin:update', 'false', '4', null);
INSERT INTO `tb_menus` VALUES ('23', '删除', null, null, 'sys:admin:delete', 'false', '4', null);
INSERT INTO `tb_menus` VALUES ('33', '新增', null, null, 'user:user:save', 'false', '10', null);
INSERT INTO `tb_menus` VALUES ('34', '查看', null, null, 'user:user:list', 'false', '11', null);
INSERT INTO `tb_menus` VALUES ('35', '新增', null, null, 'user:user:save', 'false', '11', null);
INSERT INTO `tb_menus` VALUES ('36', '修改', null, null, 'user:user:update', 'false', '11', null);
INSERT INTO `tb_menus` VALUES ('37', '删除', null, null, 'user:user:delete', 'false', '11', null);
INSERT INTO `tb_menus` VALUES ('42', '查看', '', '', 'log:log:list', 'false', '15', null);
INSERT INTO `tb_menus` VALUES ('43', 'SQL监控', '&#xe642;', null, null, 'false', '0', '996');
INSERT INTO `tb_menus` VALUES ('44', 'SQL监控', '&#xe642;', 'sys/druid', null, 'false', '43', null);
INSERT INTO `tb_menus` VALUES ('45', '查看', null, null, 'sys:druid:list', 'false', '44', null);
INSERT INTO `tb_menus` VALUES ('46', '菜单管理', '&#xe642;', 'sys/menuList', null, 'false', '2', '97');
INSERT INTO `tb_menus` VALUES ('47', '查看', null, null, 'sys:menu:list', 'false', '46', null);
INSERT INTO `tb_menus` VALUES ('48', '新增', null, null, 'sys:menu:save', 'false', '46', null);
INSERT INTO `tb_menus` VALUES ('49', '修改', null, null, 'sys:menu:update', 'false', '46', null);
INSERT INTO `tb_menus` VALUES ('50', '删除', null, null, 'sys:menu:delete', 'false', '46', null);
INSERT INTO `tb_menus` VALUES ('51', '轮播管理', '', '', '', 'false', '0', '997');
INSERT INTO `tb_menus` VALUES ('52', '轮播管理', '', 'carousel/carouselList', '', 'false', '51', null);
INSERT INTO `tb_menus` VALUES ('53', '查看', '', '', 'carousel:carousel:list', 'false', '52', null);
INSERT INTO `tb_menus` VALUES ('54', '删除', '', '', 'carousel:carousel:delete', 'false', '52', null);
INSERT INTO `tb_menus` VALUES ('55', '修改', '', '', 'carousel:carousel:update', 'false', '52', null);
INSERT INTO `tb_menus` VALUES ('56', '新增', '', '', 'carousel:carousel:save', 'false', '52', null);
INSERT INTO `tb_menus` VALUES ('62', 'test', '', '', '', 'false', '14', null);
INSERT INTO `tb_menus` VALUES ('69', '多数据源', '', '', '', 'false', '0', '1');
INSERT INTO `tb_menus` VALUES ('70', 'oracle库', '', 'dynamic/page/1', 'dynamic:dynamic:view', 'false', '69', null);
INSERT INTO `tb_menus` VALUES ('71', '接口工具', '', 'swagger-ui.html', '', 'false', '0', '0');

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES ('1', '超级管理员', '超级管理员');
INSERT INTO `tb_roles` VALUES ('61', 'test', 'test');

-- ----------------------------
-- Table structure for tb_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles_menus`;
CREATE TABLE `tb_roles_menus` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_roles_menus_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menus` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_roles_menus_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roles_menus
-- ----------------------------
INSERT INTO `tb_roles_menus` VALUES ('1', '1');
INSERT INTO `tb_roles_menus` VALUES ('2', '1');
INSERT INTO `tb_roles_menus` VALUES ('3', '1');
INSERT INTO `tb_roles_menus` VALUES ('4', '1');
INSERT INTO `tb_roles_menus` VALUES ('9', '1');
INSERT INTO `tb_roles_menus` VALUES ('10', '1');
INSERT INTO `tb_roles_menus` VALUES ('11', '1');
INSERT INTO `tb_roles_menus` VALUES ('14', '1');
INSERT INTO `tb_roles_menus` VALUES ('15', '1');
INSERT INTO `tb_roles_menus` VALUES ('16', '1');
INSERT INTO `tb_roles_menus` VALUES ('17', '1');
INSERT INTO `tb_roles_menus` VALUES ('18', '1');
INSERT INTO `tb_roles_menus` VALUES ('19', '1');
INSERT INTO `tb_roles_menus` VALUES ('20', '1');
INSERT INTO `tb_roles_menus` VALUES ('21', '1');
INSERT INTO `tb_roles_menus` VALUES ('22', '1');
INSERT INTO `tb_roles_menus` VALUES ('23', '1');
INSERT INTO `tb_roles_menus` VALUES ('33', '1');
INSERT INTO `tb_roles_menus` VALUES ('34', '1');
INSERT INTO `tb_roles_menus` VALUES ('35', '1');
INSERT INTO `tb_roles_menus` VALUES ('36', '1');
INSERT INTO `tb_roles_menus` VALUES ('37', '1');
INSERT INTO `tb_roles_menus` VALUES ('42', '1');
INSERT INTO `tb_roles_menus` VALUES ('43', '1');
INSERT INTO `tb_roles_menus` VALUES ('44', '1');
INSERT INTO `tb_roles_menus` VALUES ('45', '1');
INSERT INTO `tb_roles_menus` VALUES ('46', '1');
INSERT INTO `tb_roles_menus` VALUES ('47', '1');
INSERT INTO `tb_roles_menus` VALUES ('48', '1');
INSERT INTO `tb_roles_menus` VALUES ('49', '1');
INSERT INTO `tb_roles_menus` VALUES ('50', '1');
INSERT INTO `tb_roles_menus` VALUES ('51', '1');
INSERT INTO `tb_roles_menus` VALUES ('52', '1');
INSERT INTO `tb_roles_menus` VALUES ('53', '1');
INSERT INTO `tb_roles_menus` VALUES ('54', '1');
INSERT INTO `tb_roles_menus` VALUES ('55', '1');
INSERT INTO `tb_roles_menus` VALUES ('56', '1');
INSERT INTO `tb_roles_menus` VALUES ('69', '1');
INSERT INTO `tb_roles_menus` VALUES ('70', '1');
INSERT INTO `tb_roles_menus` VALUES ('71', '1');
INSERT INTO `tb_roles_menus` VALUES ('1', '61');
INSERT INTO `tb_roles_menus` VALUES ('2', '61');
INSERT INTO `tb_roles_menus` VALUES ('3', '61');
INSERT INTO `tb_roles_menus` VALUES ('4', '61');
INSERT INTO `tb_roles_menus` VALUES ('9', '61');
INSERT INTO `tb_roles_menus` VALUES ('11', '61');
INSERT INTO `tb_roles_menus` VALUES ('14', '61');
INSERT INTO `tb_roles_menus` VALUES ('15', '61');
INSERT INTO `tb_roles_menus` VALUES ('16', '61');
INSERT INTO `tb_roles_menus` VALUES ('20', '61');
INSERT INTO `tb_roles_menus` VALUES ('34', '61');
INSERT INTO `tb_roles_menus` VALUES ('42', '61');
INSERT INTO `tb_roles_menus` VALUES ('43', '61');
INSERT INTO `tb_roles_menus` VALUES ('44', '61');
INSERT INTO `tb_roles_menus` VALUES ('45', '61');
INSERT INTO `tb_roles_menus` VALUES ('46', '61');
INSERT INTO `tb_roles_menus` VALUES ('47', '61');
INSERT INTO `tb_roles_menus` VALUES ('51', '61');
INSERT INTO `tb_roles_menus` VALUES ('52', '61');
INSERT INTO `tb_roles_menus` VALUES ('53', '61');

-- ----------------------------
-- Table structure for tb_test
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_test
-- ----------------------------

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL COMMENT '昵称：唯一',
  `password` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL COMMENT '0:女，1:男，2：保密',
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `e_code` varchar(50) NOT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '0:未激活，1，正常，2，禁用',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('27', 'isduxd@qq.com', 'test', '96e79218965eb72c92a549dd5a330112', '0', '2018-03-25', '北京通州科创十四街区', '17693109923', 'b3f28566dac54f86bd4f4c2ce36e23d8019', '1', '2018-03-25 14:48:48');
INSERT INTO `tb_users` VALUES ('28', '123@qq.com', '2113', '96e79218965eb72c92a549dd5a330112', '1', '2018-07-26', '123123', '17693109997', 'c6411671821c43ca926c032e51ded16a897', '1', '2018-07-27 09:59:16');
INSERT INTO `tb_users` VALUES ('29', 'sdf@163.com', '123123', '96e79218965eb72c92a549dd5a330112', '2', '2018-07-27', '123123', '17111111111', '92197e8f8a5647ae8be96fe2db555575147', '1', '2018-07-27 14:23:55');
INSERT INTO `tb_users` VALUES ('30', 'test@126.com', 'dxd', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-07-31', '西安市高新区', null, 'f5140a3af98c4d7cba05436ac090ae80508', '1', '2018-10-06 13:29:47');
INSERT INTO `tb_users` VALUES ('33', '593151321@qq.com', 'fsdf', 'c2909c4ab63391a7aa438ef83c3d66a8', '1', '2018-10-18', '2331', '11111111111', 'b8c5626e77f04e5daac756aca08330d1750', '1', '2018-10-18 11:52:52');
INSERT INTO `tb_users` VALUES ('34', 'test@126.com', 'dxd', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-07-31', '西安市高新区', null, '1cb4c8f364204c1b8515f0c5555d1ba1615', '1', '2019-04-11 14:46:43');
