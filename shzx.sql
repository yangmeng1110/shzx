/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.27-community-nt : Database - feeling
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`feeling` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `feeling`;

/*Table structure for table `func_group` */

DROP TABLE IF EXISTS `func_group`;

CREATE TABLE `func_group` (
  `id` varchar(64) NOT NULL,
  `groupname` varchar(128) default NULL,
  `groupurl` varchar(256) default NULL,
  `groupsort` varchar(12) default NULL,
  `funcid` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `func_group` */

insert  into `func_group`(`id`,`groupname`,`groupurl`,`groupsort`,`funcid`) values ('100','用户管理','user/toQueryUserInfoList','1001','f002'),('200','访问日志',NULL,'1002','f001');

/*Table structure for table `func_item` */

DROP TABLE IF EXISTS `func_item`;

CREATE TABLE `func_item` (
  `id` varchar(64) NOT NULL,
  `funcname` varchar(128) default NULL,
  `funcsort` varchar(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `func_item` */

insert  into `func_item`(`id`,`funcname`,`funcsort`) values ('f001','系统管理','1000'),('f002','权限管理','2000');

/*Table structure for table `role_func` */

DROP TABLE IF EXISTS `role_func`;

CREATE TABLE `role_func` (
  `id` varchar(64) NOT NULL,
  `roleId` varchar(64) default NULL,
  `groupid` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_func` */

insert  into `role_func`(`id`,`roleId`,`groupid`) values ('1wq000wkcnncndmd','ri001','100'),('sicjoicnidj1q903','ri001','200');

/*Table structure for table `role_info` */

DROP TABLE IF EXISTS `role_info`;

CREATE TABLE `role_info` (
  `id` varchar(64) NOT NULL,
  `roleName` varchar(128) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_info` */

insert  into `role_info`(`id`,`roleName`) values ('ri001','超级管理员'),('ri002','操作员');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` varchar(64) character set utf8 NOT NULL,
  `username` varchar(64) character set utf8 NOT NULL default '',
  `password` varchar(120) character set utf8 NOT NULL,
  `telephone` varchar(36) character set utf8 default NULL,
  `realname` varchar(12) character set utf8 NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`username`,`password`,`telephone`,`realname`) values ('395fd6ca-510f-1034-bfa5-0f76265c59ab','paul','e10adc3949ba59abbe56e057f20f883e','18655733333','保罗'),('a7c8dcf5-5070-1034-b8f0-f2012fe5f004','james','e10adc3949ba59abbe56e057f20f883e','18655896052','詹姆斯'),('b4e94357-5071-1034-b8f0-f2012fe5f004','yaoming','e10adc3949ba59abbe56e057f20f883e','18655896052','姚明'),('b6945b6b-4e06-1034-8e60-39314adf80e2','username133','21232f297a57a5a743894a0e4a801fc3','135728233','??33'),('b6a29609-4e06-1034-8e60-39314adf80e2','username134','21232f297a57a5a743894a0e4a801fc3','135728234','??34'),('b6b53523-4e06-1034-8e60-39314adf80e2','username136','21232f297a57a5a743894a0e4a801fc3','135728236','??36'),('b6bea673-4e06-1034-8e60-39314adf80e2','username137','21232f297a57a5a743894a0e4a801fc3','135728237','??37'),('b6d34630-4e06-1034-8e60-39314adf80e2','username139','21232f297a57a5a743894a0e4a801fc3','135728239','??39'),('b732ce54-4e06-1034-8e60-39314adf80e2','username150','21232f297a57a5a743894a0e4a801fc3','135728250','??50'),('b73f27e9-4e06-1034-8e60-39314adf80e2','username151','21232f297a57a5a743894a0e4a801fc3','135728251','??51'),('b746d148-4e06-1034-8e60-39314adf80e2','username152','21232f297a57a5a743894a0e4a801fc3','135728252','??52'),('b7506dde-4e06-1034-8e60-39314adf80e2','username153','21232f297a57a5a743894a0e4a801fc3','135728253','??53'),('b7599331-4e06-1034-8e60-39314adf80e2','username154','21232f297a57a5a743894a0e4a801fc3','135728254','??54'),('b763301c-4e06-1034-8e60-39314adf80e2','username155','21232f297a57a5a743894a0e4a801fc3','135728255','??55'),('b76c5d0e-4e06-1034-8e60-39314adf80e2','username156','21232f297a57a5a743894a0e4a801fc3','135728256','??56'),('b7727b24-4e06-1034-8e60-39314adf80e2','username157','21232f297a57a5a743894a0e4a801fc3','135728257','??57'),('b77d4c39-4e06-1034-8e60-39314adf80e2','username158','21232f297a57a5a743894a0e4a801fc3','135728258','??58'),('b78370c0-4e06-1034-8e60-39314adf80e2','username159','21232f297a57a5a743894a0e4a801fc3','135728259','??59'),('b78db76c-4e06-1034-8e60-39314adf80e2','username160','21232f297a57a5a743894a0e4a801fc3','135728260','??60'),('b79403c7-4e06-1034-8e60-39314adf80e2','username161','21232f297a57a5a743894a0e4a801fc3','135728261','??61'),('b7ae62c7-4e06-1034-8e60-39314adf80e2','username162','21232f297a57a5a743894a0e4a801fc3','135728262','??62'),('b7b48174-4e06-1034-8e60-39314adf80e2','username163','21232f297a57a5a743894a0e4a801fc3','135728263','??63'),('b7bf538d-4e06-1034-8e60-39314adf80e2','username164','21232f297a57a5a743894a0e4a801fc3','135728264','??64'),('b7c58805-4e06-1034-8e60-39314adf80e2','username165','21232f297a57a5a743894a0e4a801fc3','135728265','??65'),('b7d03e19-4e06-1034-8e60-39314adf80e2','username166','21232f297a57a5a743894a0e4a801fc3','135728266','??66'),('b7d61a15-4e06-1034-8e60-39314adf80e2','username167','21232f297a57a5a743894a0e4a801fc3','135728267','??67'),('b7e460ae-4e06-1034-8e60-39314adf80e2','username168','21232f297a57a5a743894a0e4a801fc3','135728268','??68'),('b7ea86e1-4e06-1034-8e60-39314adf80e2','username169','21232f297a57a5a743894a0e4a801fc3','135728269','??69'),('b7f58337-4e06-1034-8e60-39314adf80e2','username170','21232f297a57a5a743894a0e4a801fc3','135728270','??70'),('b7fbaa98-4e06-1034-8e60-39314adf80e2','username171','21232f297a57a5a743894a0e4a801fc3','135728271','??71'),('b8066f6a-4e06-1034-8e60-39314adf80e2','username172','21232f297a57a5a743894a0e4a801fc3','135728272','??72'),('b80cb470-4e06-1034-8e60-39314adf80e2','username173','21232f297a57a5a743894a0e4a801fc3','135728273','??73'),('b81c6e5b-4e06-1034-8e60-39314adf80e2','username174','21232f297a57a5a743894a0e4a801fc3','135728274','??74'),('b8228f5e-4e06-1034-8e60-39314adf80e2','username175','21232f297a57a5a743894a0e4a801fc3','135728275','??75'),('b82d03ef-4e06-1034-8e60-39314adf80e2','username176','21232f297a57a5a743894a0e4a801fc3','135728276','??76'),('b83331c0-4e06-1034-8e60-39314adf80e2','username177','21232f297a57a5a743894a0e4a801fc3','135728277','??77'),('b84a940d-4e06-1034-8e60-39314adf80e2','username178','21232f297a57a5a743894a0e4a801fc3','135728278','??78'),('b85ac89b-4e06-1034-8e60-39314adf80e2','username179','21232f297a57a5a743894a0e4a801fc3','135728279','??79'),('b86a3580-4e06-1034-8e60-39314adf80e2','username180','21232f297a57a5a743894a0e4a801fc3','135728280','??80'),('b8776185-4e06-1034-8e60-39314adf80e2','username181','21232f297a57a5a743894a0e4a801fc3','135728281','??81'),('b8847c47-4e06-1034-8e60-39314adf80e2','username182','21232f297a57a5a743894a0e4a801fc3','135728282','??82'),('b88c00dc-4e06-1034-8e60-39314adf80e2','username183','21232f297a57a5a743894a0e4a801fc3','135728283','??83'),('b895ac05-4e06-1034-8e60-39314adf80e2','username184','21232f297a57a5a743894a0e4a801fc3','135728284','??84'),('b8a5014f-4e06-1034-8e60-39314adf80e2','username185','21232f297a57a5a743894a0e4a801fc3','135728285','??85'),('b8af9e6a-4e06-1034-8e60-39314adf80e2','username186','21232f297a57a5a743894a0e4a801fc3','135728286','??86'),('b8b92ffd-4e06-1034-8e60-39314adf80e2','username187','21232f297a57a5a743894a0e4a801fc3','135728287','??87'),('b8c0e411-4e06-1034-8e60-39314adf80e2','username188','21232f297a57a5a743894a0e4a801fc3','135728288','??88'),('b8cb8b6e-4e06-1034-8e60-39314adf80e2','username189','21232f297a57a5a743894a0e4a801fc3','135728289','??89'),('b8d2c7d2-4e06-1034-8e60-39314adf80e2','username190','21232f297a57a5a743894a0e4a801fc3','135728290','??90'),('b8dc7094-4e06-1034-8e60-39314adf80e2','username191','21232f297a57a5a743894a0e4a801fc3','135728291','??91'),('b8e9202b-4e06-1034-8e60-39314adf80e2','username192','21232f297a57a5a743894a0e4a801fc3','135728292','??92'),('b8f2b792-4e06-1034-8e60-39314adf80e2','username193','21232f297a57a5a743894a0e4a801fc3','135728293','??93'),('b8fa3b6b-4e06-1034-8e60-39314adf80e2','username194','21232f297a57a5a743894a0e4a801fc3','135728294','??94'),('b9032edd-4e06-1034-8e60-39314adf80e2','username195','21232f297a57a5a743894a0e4a801fc3','135728295','??95'),('b90ad3df-4e06-1034-8e60-39314adf80e2','username196','21232f297a57a5a743894a0e4a801fc3','135728296','??96'),('b9143d7f-4e06-1034-8e60-39314adf80e2','username197','21232f297a57a5a743894a0e4a801fc3','135728297','??97'),('b91f37e5-4e06-1034-8e60-39314adf80e2','username198','21232f297a57a5a743894a0e4a801fc3','135728298','??98'),('b928c2de-4e06-1034-8e60-39314adf80e2','username199','21232f297a57a5a743894a0e4a801fc3','135728299','??99'),('b939de8a-4e06-1034-8e60-39314adf80e2','admin','21232f297a57a5a743894a0e4a801fc3','18655896052','超级管理员');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `Id` varchar(64) NOT NULL default '',
  `roleId` varchar(128) default NULL,
  `userId` varchar(64) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`Id`,`roleId`,`userId`) values ('ur001','ri001','b939de8a-4e06-1034-8e60-39314adf80e2');

/* Trigger structure for table `user_info` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `ei_triggger` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `ei_triggger` BEFORE INSERT ON `user_info` FOR EACH ROW set NEW.ID = uuid() */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
