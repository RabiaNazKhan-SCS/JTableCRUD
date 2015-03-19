/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.25 : Database - experimentsdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`experimentsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `experimentsdb`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cust_id` int(10) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(25) DEFAULT NULL,
  `cust_email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`cust_id`,`cust_name`,`cust_email`) values (1,'Rabia','rabia.naz33@gmail.com'),(2,'Hira','abc@gmail.com'),(3,'shehza','abc@gmail.com'),(6,'aa','bbff'),(7,'abc','abc'),(8,'1234','1234'),(9,'rabia','rrrr'),(10,'fgf','fgfg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
