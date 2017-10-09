/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.17 : Database - strutshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`strutshop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `strutshop`;

/*Table structure for table `t_address` */

DROP TABLE IF EXISTS `t_address`;

CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addressName` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `post` varchar(50) DEFAULT NULL,
  `customeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_address` */

insert  into `t_address`(`id`,`addressName`,`phone`,`post`,`customeId`) values (1,'陕西西安','0295325','725000',1),(2,'四川成都','0658452','756000',1),(3,'湖北武汉','0462557','736520',1),(4,'陕西西安','0295325','725000',2);

/*Table structure for table `t_category` */

DROP TABLE IF EXISTS `t_category`;

CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `group` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_category` */

insert  into `t_category`(`id`,`name`,`group`) values (1,'水果','A'),(2,'食品','B'),(3,'蔬菜','C');

/*Table structure for table `t_custome` */

DROP TABLE IF EXISTS `t_custome`;

CREATE TABLE `t_custome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `addressId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_custome` */

insert  into `t_custome`(`id`,`name`,`password`,`addressId`) values (1,'小明','xiaoming',1),(2,'小美','xiaomei',4);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(50) DEFAULT NULL,
  `totalPrice` double(10,2) DEFAULT NULL,
  `customeId` int(11) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  `orderDate` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`orderNumber`,`totalPrice`,`customeId`,`addressId`,`orderDate`,`status`) values (1,'3a2823f3-2234-4940-8371-cfa62ae10265',149.50,1,1,'2017-06-13 23:53:37',2),(2,'8a258c45-2e80-4d0d-9a8d-3c6a6a8f711b',238.50,1,1,'2017-06-13 23:54:33',2),(3,'688e7f1d-0efe-4100-82ee-1f81683c8101',173.40,1,1,'2017-06-13 23:55:00',2),(4,'a0612c26-3b78-4af3-a965-df95cf1633a6',161.10,1,1,'2017-06-13 23:55:10',2),(5,'2259ffe5-b4f2-483b-81e9-54f2fe3f2a7d',135.30,1,1,'2017-06-13 23:55:16',2);

/*Table structure for table `t_shopitem` */

DROP TABLE IF EXISTS `t_shopitem`;

CREATE TABLE `t_shopitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shoppingId` int(11) DEFAULT NULL,
  `shoppingName` varchar(50) DEFAULT NULL,
  `shopNumber` int(11) DEFAULT NULL,
  `discountPrice` double(10,2) DEFAULT NULL,
  `customeId` int(11) DEFAULT NULL,
  `inshopCar` int(11) DEFAULT NULL COMMENT '0:不在购物车，1:在购物车',
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_shopitem` */

insert  into `t_shopitem`(`id`,`shoppingId`,`shoppingName`,`shopNumber`,`discountPrice`,`customeId`,`inshopCar`,`orderId`) values (2,3,'奇异果',6,36.80,1,0,2),(3,5,' 苹果 ',1,24.90,1,0,2),(4,4,'夏橙',1,36.80,1,0,2),(5,8,'木瓜',1,26.50,1,0,2),(6,6,'海南芒果',1,39.90,1,0,2),(7,9,'甜瓜',3,23.90,1,0,3),(8,7,'大樱桃',3,33.90,1,0,3),(9,1,'椰青',1,29.90,1,0,4),(10,8,'木瓜',1,26.50,1,0,4),(11,6,'海南芒果',1,39.90,1,0,4),(12,2,'红心火龙果',1,30.90,1,0,4),(13,7,'大樱桃',1,33.90,1,0,4),(14,5,' 苹果 ',1,24.90,1,1,5),(15,3,'奇异果',3,36.80,1,1,5);

/*Table structure for table `t_shopping` */

DROP TABLE IF EXISTS `t_shopping`;

CREATE TABLE `t_shopping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `createDate` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `categoryName` varchar(50) DEFAULT NULL,
  `imgsFileName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_shopping` */

insert  into `t_shopping`(`id`,`name`,`price`,`brand`,`createDate`,`description`,`categoryName`,`imgsFileName`) values (16,'小米手机',222.00,'小米','2016-06-12 12:12:12','这是一台小米手机','手机','002.jpg');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`name`,`password`,`role`) values (1,'admin','admin','最厉害'),(2,'武松','zyz','一般般'),(4,'关羽','159','挺厉害'),(5,'秦琼','159','挺厉害'),(6,'袁崇焕','wer','很厉害'),(7,'袁崇焕','369','很厉害'),(8,'秦琼','abc','一般般'),(9,'吕布','wer','很厉害'),(14,'吕布','159','挺厉害'),(15,'袁崇焕','abc','很厉害'),(16,'岳飞','wer','一般般'),(18,'袁崇焕','369','一般般'),(19,'吕布','zyz','挺厉害'),(21,'岳飞','369','很厉害'),(22,'武松','abc','挺厉害'),(25,'武松','zyz','很厉害'),(28,'秦琼','369','很厉害'),(29,'秦琼','zyz','挺厉害'),(30,'秦琼','zyz','一般般'),(31,'武松','wer','挺厉害'),(32,'秦琼','369','很厉害'),(34,'袁崇焕','159','一般般'),(35,'关羽','wer','一般般'),(36,'岳飞','wer','一般般'),(37,'吕布','159','一般般'),(39,'关羽','369','挺厉害'),(41,'秦琼','abc','很厉害'),(42,'岳飞','abc','一般般'),(43,'吕布','zyz','挺厉害'),(44,'秦琼','abc','很厉害'),(45,'关羽','zyz','很厉害'),(46,'吕布','wer','挺厉害'),(47,'岳飞','159','一般般'),(48,'袁崇焕','159','挺厉害'),(49,'关羽','zyz','很厉害'),(50,'岳飞','159','一般般'),(51,'袁崇焕','abc','一般般'),(54,'吕布','wer','一般般'),(56,'吕布','369','挺厉害'),(57,'武松','zyz','挺厉害'),(58,'关羽','369','很厉害'),(59,'岳飞','369','很厉害'),(61,'关羽','zyz','一般般'),(62,'吕布','abc','很厉害'),(63,'秦琼','wer','很厉害'),(64,'关羽','abc','很厉害'),(65,'袁崇焕','369','一般般'),(66,'吕布','wer','挺厉害'),(67,'武松菲菲','wer','一般般'),(68,'武松','zyz','很厉害'),(71,'岳飞','wer','一般般'),(72,'秦琼','zyz','很厉害'),(74,'岳飞','159','一般般'),(75,'秦琼','zyz','一般般'),(76,'岳飞','zyz','很厉害'),(77,'关羽','wer','很厉害'),(78,'秦琼','zyz','一般般'),(79,'袁崇焕','zyz','很厉害'),(80,'吕布','159','一般般'),(81,'袁崇焕','zyz','一般般'),(82,'关羽','abc','很厉害'),(83,'关羽','159','很厉害'),(85,'袁崇焕','abc','一般般'),(86,'秦琼','369','很厉害'),(87,'吕布','zyz','挺厉害'),(89,'袁崇焕','zyz','挺厉害'),(90,'武松','zyz','挺厉害'),(92,'袁崇焕','369','一般般'),(93,'关羽','zyz','一般般'),(94,'关羽','369','一般般'),(96,'吕布','369','很厉害'),(97,'吕布','abc','很厉害'),(98,'吕布','zyz','挺厉害'),(116,'',NULL,NULL),(117,'风微风','飞','王夫人');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
