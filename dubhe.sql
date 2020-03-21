-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: Dubhe
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `build_time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_message`
--

DROP TABLE IF EXISTS `blog_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `blog_id` int(11) DEFAULT NULL COMMENT '博客id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `msg_type` int(11) DEFAULT NULL COMMENT '消息类型',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `build_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_message`
--

LOCK TABLES `blog_message` WRITE;
/*!40000 ALTER TABLE `blog_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `friend_id` int(11) DEFAULT NULL COMMENT '好友id',
  `build_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立时间',
  `type_id` int(11) DEFAULT NULL COMMENT '好友分组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` VALUES (1,1,2,'2017-01-16 13:13:47',1),(2,1,3,'2017-01-16 13:14:01',1),(3,1,4,'2017-01-16 13:14:10',1),(4,1,5,'2017-01-16 13:14:17',1),(5,1,6,'2017-01-16 13:14:23',1),(6,1,7,'2017-01-16 13:14:35',1),(7,2,1,'2017-01-16 13:15:37',2),(8,2,3,'2017-01-16 13:15:51',2),(9,2,4,'2017-01-16 13:16:15',2),(10,2,5,'2017-01-16 13:16:25',2),(11,3,1,'2017-01-16 13:16:35',3),(12,3,2,'2017-01-16 13:16:40',3),(13,3,4,'2017-01-16 13:16:46',3),(14,3,5,'2017-01-16 13:16:53',3),(15,4,1,'2017-01-16 13:17:02',4),(16,4,2,'2017-01-16 13:17:06',4),(17,4,3,'2017-01-16 13:17:17',4),(18,4,5,'2017-01-16 13:17:23',4),(19,5,1,'2017-01-16 13:17:28',5),(20,5,2,'2017-01-16 13:17:34',5),(21,5,3,'2017-01-16 13:17:41',5),(22,5,4,'2017-01-16 13:17:59',5),(23,1,2,'2020-02-21 09:27:01',3),(24,7,1,'2020-03-15 07:51:26',1);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_message`
--

DROP TABLE IF EXISTS `friend_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend_message` (
  `id` int(11) NOT NULL,
  `from_user_id` int(11) DEFAULT NULL COMMENT '发消息的人的id',
  `to_user_id` int(11) DEFAULT NULL COMMENT '收消息的人的id',
  `content` varchar(0) DEFAULT NULL COMMENT '消息内容',
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  `is_read` int(11) DEFAULT NULL COMMENT '是否已读，1是0否',
  `is_del` int(11) DEFAULT NULL COMMENT '是否删除，1是0否',
  `is_back` int(11) DEFAULT NULL COMMENT '是否撤回，1是0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_message`
--

LOCK TABLES `friend_message` WRITE;
/*!40000 ALTER TABLE `friend_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_type`
--

DROP TABLE IF EXISTS `friend_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键\r\n            ',
  `type_name` varchar(255) DEFAULT NULL COMMENT '分组名',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `build_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_default` int(11) DEFAULT '0' COMMENT '是否为默认分组：1为默认，0为不是默认分组',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='好友分组';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_type`
--

LOCK TABLES `friend_type` WRITE;
/*!40000 ALTER TABLE `friend_type` DISABLE KEYS */;
INSERT INTO `friend_type` VALUES (1,'好友',1,'2017-01-16 13:11:45',1),(2,'好友',2,'2017-01-16 13:12:12',1),(3,'好友',3,'2017-01-16 13:12:25',1),(4,'好友',4,'2017-01-16 13:12:35',1),(5,'好友',5,'2017-01-16 13:12:37',1),(6,'好友',6,'2017-01-16 13:13:19',1),(7,'好友',7,'2017-01-16 13:13:35',1),(8,'特别好友',1,'2020-02-23 12:47:12',0);
/*!40000 ALTER TABLE `friend_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rootname` int(11) NOT NULL,
  `f_rootname` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_message`
--

DROP TABLE IF EXISTS `group_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_message` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `group_id` int(11) DEFAULT NULL COMMENT '群id',
  `content` varchar(0) DEFAULT NULL COMMENT '群消息内容',
  `is_del` int(11) DEFAULT NULL COMMENT '是否删除，1是 0否',
  `is_read` int(11) DEFAULT NULL COMMENT '是否已读，1是，0否。',
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_back` int(11) DEFAULT NULL COMMENT '是否撤回，1是 0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_message`
--

LOCK TABLES `group_message` WRITE;
/*!40000 ALTER TABLE `group_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_user`
--

DROP TABLE IF EXISTS `group_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `group_id` int(11) DEFAULT NULL COMMENT '群id\r\n            ',
  `join_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入群时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='群成员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_user`
--

LOCK TABLES `group_user` WRITE;
/*!40000 ALTER TABLE `group_user` DISABLE KEYS */;
INSERT INTO `group_user` VALUES (1,1,1,'2017-01-17 13:46:31'),(2,2,1,'2017-01-17 13:47:15'),(3,3,1,'2017-01-17 13:47:28'),(4,4,1,'2017-01-17 13:47:37'),(5,5,1,'2017-01-17 13:47:46'),(6,6,1,'2017-01-17 13:47:51'),(7,7,1,'2017-01-17 13:47:56');
/*!40000 ALTER TABLE `group_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rootname` int(11) NOT NULL,
  `f_rootname` int(11) NOT NULL,
  `record` text,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog`
--

DROP TABLE IF EXISTS `t_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `header` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(4096) DEFAULT NULL COMMENT '内容',
  `image` varchar(2048) DEFAULT NULL,
  `build_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户博客表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog`
--

LOCK TABLES `t_blog` WRITE;
/*!40000 ALTER TABLE `t_blog` DISABLE KEYS */;
INSERT INTO `t_blog` VALUES (1,1,'生命练习生第一万八千次练习','步乱世之劫，横扫武道顶峰；辟黑夜之光，一问天下英雄。','2020-03-15/278595/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/418598/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/536598/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/690597/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/795626/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/859598/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg','2020-03-09 04:12:19'),(2,1,'生命之枪','征尘幂，孤锋披，今古几人堪敌兮？仰空长啸万里，再战天下境逆。','2020-03-15/278595/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/418598/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/536598/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/690597/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/795626/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/859598/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg','2020-03-12 01:41:22'),(3,1,'雪儿','众里寻她千百度，蓦然回首，那人却在灯火阑珊处！','2020-03-15/278595/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/418598/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/536598/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/690597/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/795626/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/859598/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg','2020-03-12 01:45:07'),(4,1,'武道顶峰','半壁翻云刃，满江酩酊红。千古光阴一霎时，且醉浪涛中。','2020-03-15/278595/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/418598/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/536598/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/690597/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/795626/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/859598/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg','2020-03-12 01:45:07'),(5,3,'笑尽英雄','世事如棋，乾坤莫测，笑尽英雄啊！',NULL,'2020-03-13 03:11:17'),(6,3,'笑尽英雄','世事如棋，乾坤莫测，笑尽英雄啊！',NULL,'2020-03-13 20:36:56'),(7,1,'朋友，想这样抢镜头，没有稳赢的。','生命练习生，第十九万九千次练习，谢天地赐我逆境。','2020-03-15/278595/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/418598/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/536598/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/690597/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/795626/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/859598/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg','2020-03-14 21:17:11'),(8,1,'抱歉，鄙人专注搞破坏二十年！','抱歉，鄙人专注搞破坏二十年！','2020-03-15/285517/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/420516/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg','2020-03-14 21:21:03'),(9,1,'打空拳费力，说空话劳神，看贴不转，废人。','打空拳费力，说空话劳神，看贴不转，废人。','2020-03-15/278595/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/418598/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/536598/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/690597/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/795626/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/859598/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg','2020-03-14 21:23:30'),(10,1,'没到北风北，你没有稳赢啊！','没到北风北，你没有稳赢啊！','2020-03-15/496661/remember_me__by_guweiz_dadr2pn-fullview.jpg:2020-03-15/506662/sand_by_guweiz_d9v76x8-fullview.jpg','2020-03-14 21:27:29'),(11,1,'男人重气魄，兄弟重眉角，相杀免废话。','男人重气魄，兄弟重眉角，相杀免废话。','2020-03-15/419547/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg','2020-03-14 21:29:21'),(12,1,'打空拳费力，说空话劳神，看贴不转，废人。','打空拳费力，说空话劳神，看贴不转，废人。','2020-03-15/995096/daa3fwv-3f20e852-bd4c-4c0c-9cde-f08c143d6ef9.jpg','2020-03-14 21:32:35'),(13,1,'没到北风北，你没有稳赢啊！','没到北风北，你没有稳赢啊！','2020-03-15/387996/wake_3_by_wlop_d8g3hn7-fullview.jpg','2020-03-14 21:33:42'),(14,1,'枪啊枪，不珍惜生命是现在的潮流吗？','枪啊枪，不珍惜生命是现在的潮流吗？','2020-03-15/178395/dac2724-3f7750dc-f4ce-45f1-bb08-5f8b60e9f382.jpg','2020-03-14 21:34:31'),(15,1,'衣带渐宽终不悔，为伊消得人憔悴。','衣带渐宽终不悔，为伊消得人憔悴。','2020-03-15/662684/remember_me__by_guweiz_dadr2pn-fullview.jpg','2020-03-14 21:35:42'),(16,1,'今古几人堪敌兮？','征尘幂，孤锋披，今古几人堪敌兮？仰长空，啸万里，再战天下境逆。','2020-03-15/357012/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg','2020-03-14 21:36:20'),(17,1,'以神遇而不以目视，官知止而神欲行。','以神遇而不以目视，官知止而神欲行。','2020-03-15/397470/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg:2020-03-15/530469/d8f3a5d-d9c2bb2c-c4e0-41c7-a099-953f087575e1.jpg:2020-03-15/633475/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg:2020-03-15/764473/d9m2fac-692fc337-c708-4a3b-9744-e80d0bc2f1a5.jpg:2020-03-15/872468/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg:2020-03-15/949502/d9zlsvq-667f66e7-a013-44fc-a788-7bc381c14c91.jpg:2020-03-15/75467/daa3fwv-3f20e852-bd4c-4c0c-9cde-f08c143d6ef9.jpg','2020-03-14 21:44:14'),(18,1,'今生缘尽再相约来世','今生缘尽再相约来世','2020-03-15/101324/d9jrqmp-e10ed25c-f0b6-464a-9589-eb6d3982b2e6.jpg','2020-03-14 21:51:02');
/*!40000 ALTER TABLE `t_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_group`
--

DROP TABLE IF EXISTS `t_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_group` (
  `id` int(11) NOT NULL COMMENT '自增主键\r\n            ',
  `group_num` varchar(255) DEFAULT NULL COMMENT '群号',
  `group_name` varchar(255) DEFAULT NULL COMMENT '群名称',
  `avatar` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `build_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(0) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_group`
--

LOCK TABLES `t_group` WRITE;
/*!40000 ALTER TABLE `t_group` DISABLE KEYS */;
INSERT INTO `t_group` VALUES (1,'1','oldriver技术交流','images/boy-01.png',1,'2017-01-16 14:00:07',NULL,NULL);
/*!40000 ALTER TABLE `t_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(255) DEFAULT NULL COMMENT '帐号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `gender` int(11) DEFAULT '0' COMMENT '性别：0为男，1为女',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `role_code` int(11) DEFAULT '1' COMMENT '角色code：1为用户，2为管理员',
  `version` varchar(0) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'生命练习生','123','神魔不许',NULL,'2020-03-15/515874/d9ml5ia-993fe641-09c6-463b-adf5-9d2ed2679261.jpg','沧海笑','炼洗之命',2,NULL,'生命是无数次的裂岸骇浪，只为练习出一次完美的惊涛，生命练习生，第九万七千次练习，谢天地赠我逆境。'),(2,'天迹','123','神毓逍遥',0,'images/boy-01.png','云海仙门','神谕',1,NULL,'玉墨舒心春酝瓢，行也逍遥，坐也逍遥'),(3,'梵天','123','梵天',0,'images/boy-02.png','云渡山','神凰剑灵',1,NULL,'世事如棋，乾坤莫测，笑尽英雄啊！'),(4,'君奉天','123','御命丹心',0,'images/boy-03.png','云海仙门','正法',1,NULL,'儒法、无情，法儒、无私。'),(5,'乱世狂刀','123','刀刀',0,'images/girl-01.png','北武林','狮头宝刀',1,NULL,'一箫一剑平生意，负尽狂名十五年'),(6,'魔君','123','预言魔子',0,'images/girl-02.png','原始幽界','生命之源',1,NULL,'天屈膝，地伏首，人间沦亡，不过只手。神无救，圣唯杀，魔翼之前，终究虚话。'),(7,'巧天工','123','雨霖铃',1,'images/girl-03.png','铸水听风楼','虎尾春冰',1,NULL,'涉江采芙蓉，兰泽多芳草，采之欲遗谁，所思在远道'),(8,'红尘雪','123','天子枪·玉玺重明',1,NULL,'倚晴江山楼','帝诏',NULL,NULL,'雪练倾河，十里龙涛，独濯沧浪行云啸；风光傲，问人间何似，天子逍遥。'),(9,'缺舟','123','缺舟一帆渡',0,NULL,'佛国','文殊剑',NULL,NULL,'千年共修，缺舟一帆。无边沉沦，法海渡航。'),(11,'风之痕','123','魔流剑',0,NULL,'孤独峰','绝代之狂',NULL,NULL,'昂首千丘远，啸傲风间；堪寻敌手共论剑，高处不胜寒'),(16,'忆无心','123','石头仔',1,NULL,'黑水城','泪石',NULL,NULL,'我知道，我会。'),(17,'黑白郎君','123','斯文客',0,NULL,'中原武林','幽灵马车',NULL,NULL,'哈哈哈哈，别人的失败就是我的快乐啦！'),(18,'藏镜人','123','罗碧',0,'','苗疆','藏身宝镜',NULL,NULL,'不应该啊——'),(19,'温皇','123','秋水浮萍任飘渺',0,NULL,'还珠楼','无双剑',NULL,NULL,'风满楼，卷黄沙，舞剑春秋，名震天下。雨飘渺，倦红尘，还君明珠，秋水浮萍。'),(20,'赤羽','123','あかばね しんのすけ',0,NULL,'西剑流','凤凰刃',NULL,NULL,'一只躲藏在薄薄纸灯笼之内的蝴蝶，就像一张薄薄的假脸皮，伪装自已的人，都让我发怒。'),(21,'竞日孤鸣','123','小王',0,NULL,'北竞王府','狼王爪',1,NULL,'北龙腾空破苍穹，天下归心山河动。'),(22,'默苍离','123','策天凤',0,NULL,'墨家','墨狂',NULL,NULL,'别再思考了，我快要无法呼吸了。'),(23,'雁王','123','上官鸿信',0,NULL,'羽国','断云石',NULL,NULL,'我喜欢失败的第一步，因为失败，总是成功的垫脚石。'),(24,'元邪皇','123','烛九阴',NULL,'2020-03-15/582162/d7wd0qx-476c59c1-5735-44c0-a319-4246fd426e09.jpg','魔世','幽灵魔刀',NULL,NULL,'人世，吾再度降临了');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-15 16:24:42
