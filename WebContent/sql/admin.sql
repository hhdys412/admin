CREATE DATABASE  IF NOT EXISTS `testadmin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `testadmin`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: testadmin
-- ------------------------------------------------------
-- Server version	5.0.18-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  `name` varchar(45) default NULL,
  `department` int(11) default NULL,
  `sex` int(11) default NULL,
  `age` int(11) default NULL,
  `inuse` int(11) default NULL,
  `create_time` bigint(20) default NULL,
  `last_login_time` bigint(20) default NULL,
  `role` int(11) default NULL,
  `position` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `IDX_account_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'hhdys','123','坏坏的忧伤',5,0,22,0,1375686288184,0,1,2),(4,'ttt','666','zhang',22,0,4,0,1375690693302,0,2,2),(5,'admin','admin','admin',3,0,32,0,1375686615394,0,1,6),(7,'yy1','ttt','ttt',22,0,25,0,1375690740190,0,2,4),(8,'abc','sss','sss',19,0,33,0,1375686800883,0,1,3),(9,'eee','eee','eee',6,0,23,0,1375686839769,0,2,5),(11,'ggg','333','444',22,0,23,0,1375690594309,0,1,3),(14,'ggg1','111','111',6,0,23,0,1375690583055,0,2,2);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `parent_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'XXX公司',0),(2,'人事部',1),(3,'行政部',1),(4,'财务部',1),(5,'技术部',1),(6,'招聘组',2),(18,'测试',3),(19,'测试1',18),(20,'dsfdfs',5),(21,'4444',20),(22,'财务组',4);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_tree`
--

DROP TABLE IF EXISTS `menu_tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_tree` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `url` varchar(100) default NULL,
  `parent_id` int(11) default NULL,
  `is_show` int(11) default NULL,
  `new_windows` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_tree`
--

LOCK TABLES `menu_tree` WRITE;
/*!40000 ALTER TABLE `menu_tree` DISABLE KEYS */;
INSERT INTO `menu_tree` VALUES (1,'系统管理','',0,0,0),(2,'用户管理','base/accountList.jsp',1,0,0),(3,'部门管理','base/departmentList.jsp',1,0,0),(4,'角色管理','base/roleList.jsp',1,0,0),(5,'职位管理','base/positionList.jsp',1,0,0),(6,'功能树管理','base/menuList.jsp',1,0,0);
/*!40000 ALTER TABLE `menu_tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'总经理'),(2,'董事长'),(3,'主任'),(4,'科长'),(5,'职员'),(6,'经理');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'系统管理员'),(2,'普通用户'),(4,'销售人员'),(5,'技术人员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_account`
--

DROP TABLE IF EXISTS `v_account`;
/*!50001 DROP VIEW IF EXISTS `v_account`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_account` (
  `id` int(11),
  `username` varchar(45),
  `password` varchar(45),
  `name` varchar(45),
  `sex` int(11),
  `age` int(11),
  `inuse` int(11),
  `create_time` bigint(20),
  `last_login_time` bigint(20),
  `department` varchar(100),
  `department_id` int(11),
  `position` varchar(45),
  `role` varchar(45)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_account`
--

/*!50001 DROP TABLE IF EXISTS `v_account`*/;
/*!50001 DROP VIEW IF EXISTS `v_account`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_account` AS select `a`.`id` AS `id`,`a`.`username` AS `username`,`a`.`password` AS `password`,`a`.`name` AS `name`,`a`.`sex` AS `sex`,`a`.`age` AS `age`,`a`.`inuse` AS `inuse`,`a`.`create_time` AS `create_time`,`a`.`last_login_time` AS `last_login_time`,`b`.`name` AS `department`,`b`.`id` AS `department_id`,`c`.`name` AS `position`,`d`.`name` AS `role` from (((`account` `a` left join `department` `b` on((`a`.`department` = `b`.`id`))) left join `position` `c` on((`a`.`position` = `c`.`id`))) left join `role` `d` on((`a`.`role` = `d`.`id`))) */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-05 17:29:37

CREATE  TABLE IF NOT EXISTS `page_func` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `page_id` INT NULL ,
  `func` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `page_id` (`page_id` ASC) )
ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE  TABLE IF NOT EXISTS `depart_role_ass` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `department_id` INT NULL ,
  `role_id` INT NULL ,
  PRIMARY KEY (`id`) )
ENGINE=InnoDB DEFAULT CHARSET=utf8;
