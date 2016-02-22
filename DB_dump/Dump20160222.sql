-- MySQL dump 10.13  Distrib 5.6.26, for Win64 (x86_64)
--
-- Host: localhost    Database: kupybaton
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Bread'),(2,'Fruits'),(3,'Vegetables'),(4,'Drinks'),(5,'Alcohol'),(6,'Meat'),(7,'milk_products'),(8,'Sweets'),(9,'Sweets');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list`
--

DROP TABLE IF EXISTS `list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `date_cr` date DEFAULT NULL,
  `date_del` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list`
--

LOCK TABLES `list` WRITE;
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
INSERT INTO `list` VALUES (3,'NewWork','2016-01-19',NULL),(4,' + listname + ','2016-01-19',NULL),(5,' + listname + ','2016-01-19',NULL),(6,'work','2016-01-19',NULL),(7,'work1','2016-01-19',NULL),(8,'work1','2016-01-19',NULL),(9,'work','2016-01-19',NULL),(10,'work','2016-01-19',NULL),(11,'work','2016-01-19',NULL),(12,'work','2016-01-19',NULL),(13,'work','2016-01-19',NULL),(14,'home','2016-01-19',NULL),(15,'','2016-01-19',NULL),(16,'','2016-01-19',NULL),(17,'','2016-01-19',NULL),(18,'work','2016-01-19',NULL),(19,'','2016-01-20',NULL),(20,'','2016-01-20',NULL),(21,'','2016-01-20',NULL),(22,'','2016-01-20',NULL),(23,'work','2016-01-20',NULL),(24,'work','2016-01-20',NULL),(25,'work','2016-01-20',NULL),(26,'work','2016-01-20',NULL),(27,'work','2016-01-20',NULL),(28,'work','2016-01-20',NULL),(29,'work','2016-01-20',NULL),(30,'work','2016-01-20',NULL),(31,'work','2016-01-20',NULL),(32,'work','2016-01-20',NULL),(33,'work','2016-01-20',NULL),(34,'work','2016-01-20',NULL),(35,'work','2016-01-20',NULL),(36,'work','2016-01-20',NULL),(37,'work','2016-01-20',NULL),(38,'work','2016-01-20',NULL),(39,'work','2016-01-20',NULL),(40,'work','2016-01-21',NULL),(41,'work','2016-01-21',NULL),(42,'work','2016-01-21',NULL),(43,'home','2016-01-21',NULL),(44,'work','2016-01-21',NULL),(45,'work','2016-01-21',NULL),(46,'work','2016-01-21',NULL),(47,'work','2016-01-21',NULL),(48,'work','2016-01-21',NULL),(49,'work','2016-01-21',NULL),(50,'work','2016-01-21',NULL),(51,'work','2016-01-21',NULL),(52,'work','2016-01-21',NULL),(53,'work','2016-01-21',NULL),(54,'work','2016-01-21',NULL),(55,'work','2016-01-21',NULL),(56,'work','2016-01-21',NULL),(57,'work','2016-01-21',NULL),(58,'work','2016-01-21',NULL),(59,'work','2016-01-21',NULL),(60,'work','2016-01-21',NULL),(61,'work','2016-01-21',NULL),(62,'work','2016-01-21',NULL),(63,'work','2016-01-21',NULL),(64,'work','2016-01-21',NULL),(65,'work','2016-01-21',NULL),(66,'work','2016-01-21',NULL),(67,'work','2016-01-21',NULL),(68,'work','2016-01-22',NULL),(69,'work','2016-01-22',NULL),(70,'work','2016-01-22',NULL),(71,'work','2016-01-22',NULL),(72,'work','2016-01-22',NULL),(73,'work','2016-01-22',NULL),(74,'work','2016-01-22',NULL),(75,'work','2016-01-22',NULL),(76,'work','2016-01-22',NULL),(77,'work','2016-01-22',NULL),(78,'work','2016-01-22',NULL),(79,'work','2016-01-22',NULL),(80,'work','2016-01-22',NULL),(81,'work','2016-01-22',NULL),(82,'work','2016-01-22',NULL),(83,'work','2016-01-22',NULL),(84,'work','2016-01-22',NULL),(85,'work','2016-01-22',NULL),(86,'work','2016-01-22',NULL),(87,'work','2016-01-23',NULL),(88,'work','2016-01-23',NULL),(89,'work','2016-01-23',NULL),(90,'work','2016-01-23',NULL),(91,'work','2016-01-23',NULL),(92,'work','2016-01-23',NULL),(93,'work','2016-01-23',NULL),(94,'work','2016-01-23',NULL),(95,'work','2016-01-23',NULL),(96,'work','2016-01-23',NULL),(97,'work','2016-01-23',NULL),(98,'some','2016-01-23',NULL),(99,'some','2016-01-23',NULL),(100,'entry','2016-01-23',NULL),(101,'work','2016-01-23',NULL),(102,'work','2016-01-23',NULL),(103,'work','2016-01-23',NULL),(104,'work','2016-01-23',NULL),(105,'work','2016-01-23',NULL),(106,'work','2016-01-23',NULL),(107,'work','2016-01-23',NULL),(108,'work','2016-01-23',NULL),(109,'work','2016-01-23',NULL),(110,'work','2016-01-23',NULL),(111,'work','2016-01-23',NULL),(112,'work','2016-01-23',NULL),(113,'work','2016-01-24',NULL),(114,'work','2016-01-24',NULL),(115,'work','2016-01-24',NULL),(116,'work','2016-01-24',NULL),(117,'work','2016-01-24',NULL),(118,'work','2016-01-24',NULL),(119,'work','2016-01-24',NULL),(120,'work','2016-01-24',NULL),(121,'work','2016-01-24',NULL),(122,'work','2016-01-24',NULL),(123,'work','2016-01-24',NULL),(124,'home','2016-01-24',NULL),(125,'home','2016-01-24',NULL),(126,'home','2016-01-24',NULL),(127,'home','2016-01-24',NULL),(128,'home','2016-01-24',NULL),(129,'home','2016-01-24',NULL),(130,'home','2016-01-24',NULL),(131,'home','2016-01-24',NULL),(132,'home','2016-01-24',NULL),(133,'home1','2016-01-24',NULL),(134,'work','2016-01-24',NULL),(135,'work','2016-01-24',NULL),(136,'home','2016-01-24',NULL),(137,'home','2016-01-24',NULL),(138,'work','2016-01-24',NULL),(139,'work','2016-01-24',NULL),(141,'home','2016-01-24',NULL),(142,'someList','2016-01-24',NULL),(143,'v','2016-01-25',NULL),(144,'work','2016-01-25',NULL),(145,'work','2016-01-25',NULL),(146,'work','2016-01-25',NULL),(147,'work','2016-01-25',NULL),(148,'work','2016-01-25',NULL),(149,'work','2016-01-25',NULL),(150,'work','2016-01-25',NULL),(151,'work','2016-01-25',NULL),(152,'work','2016-01-25',NULL),(153,'work','2016-01-25',NULL),(154,'work','2016-01-25',NULL),(155,'work','2016-01-25',NULL),(156,'work','2016-01-25',NULL),(158,'work','2016-01-25',NULL),(159,'work','2016-01-25',NULL),(160,'work','2016-01-25',NULL),(161,'work','2016-01-25',NULL),(162,'work','2016-01-25',NULL),(163,'work','2016-01-25',NULL),(164,'work','2016-01-25',NULL),(165,'work','2016-01-25',NULL),(166,'work','2016-01-25',NULL),(167,'work','2016-01-25',NULL),(168,'work','2016-01-25',NULL),(169,'work','2016-01-25',NULL),(170,'work','2016-01-25',NULL),(171,'work','2016-01-25',NULL),(172,'work','2016-01-25',NULL),(173,'work','2016-01-25',NULL),(174,'work','2016-01-25',NULL),(175,'work','2016-01-26',NULL),(176,'work','2016-01-26',NULL),(177,'work','2016-01-26',NULL),(178,'work','2016-01-26',NULL),(179,'work','2016-01-26',NULL),(180,'work','2016-01-26',NULL),(181,'work','2016-01-26',NULL),(182,'work','2016-01-26',NULL),(183,'work','2016-01-26',NULL),(184,'work','2016-01-26',NULL),(185,'work','2016-01-26',NULL),(186,'work','2016-01-26',NULL),(187,'work','2016-01-27',NULL),(188,'work','2016-01-27',NULL),(189,'work','2016-01-27',NULL),(190,'work','2016-01-27',NULL),(191,'work','2016-01-27',NULL),(192,'work','2016-01-27',NULL),(193,'work','2016-01-27',NULL),(194,'work','2016-01-27',NULL),(195,'work','2016-01-27',NULL),(196,'work','2016-01-27',NULL),(197,'work','2016-01-27',NULL),(198,'work','2016-01-27',NULL),(199,'work','2016-01-27',NULL),(200,'work','2016-01-27',NULL),(201,'work','2016-01-27',NULL),(202,'work','2016-01-27',NULL),(203,'work','2016-01-27',NULL),(204,'work','2016-01-28',NULL),(205,'work','2016-01-28',NULL),(206,'work','2016-01-28',NULL),(207,'work','2016-01-28',NULL),(208,'work','2016-01-28',NULL),(209,'work','2016-01-28',NULL),(210,'work','2016-01-28',NULL),(211,'work','2016-01-28',NULL),(212,'work','2016-01-28',NULL),(213,'work','2016-01-28',NULL),(214,'work','2016-01-28',NULL),(215,'work','2016-01-28',NULL),(216,'work','2016-01-28',NULL),(217,'work','2016-01-28',NULL),(218,'work','2016-01-28',NULL),(219,'work','2016-01-28',NULL),(220,'work','2016-01-28',NULL),(221,'work','2016-01-28',NULL),(222,'work','2016-01-28',NULL),(223,'work','2016-01-28',NULL),(224,'new','2016-01-28',NULL),(225,'work','2016-01-28',NULL),(226,'work','2016-02-03',NULL),(227,'work','2016-02-07',NULL),(228,'new list','2016-02-07',NULL),(229,'NewList','2016-02-07',NULL),(230,'NewOne','2016-02-07',NULL);
/*!40000 ALTER TABLE `list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'black_bread',1,1),(2,'apple',2,1),(3,'carrot',3,1),(4,'pita',1,1),(5,'beer',5,1),(6,'Pork',6,1),(7,'white_bread',1,1),(8,'grey_bread',1,1),(9,'french_bread',1,1),(10,'banana',2,1),(11,'Vodka',5,2),(12,'Revo',4,2),(13,'baton',1,1),(14,'Coca-Cola',4,2),(15,'Pepsi',4,2),(16,'Cogniac',5,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `list_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` decimal(10,1) NOT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id_idx2` (`product_id`),
  KEY `list_id_idx` (`list_id`),
  CONSTRAINT `fk_list_id` FOREIGN KEY (`list_id`) REFERENCES `list` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (8,141,5,2.0,1),(9,142,1,3.0,1),(10,142,2,3.0,1),(11,142,5,10.0,1),(12,142,6,2.0,1),(13,142,3,3.5,1),(14,142,1,2.0,1),(20,158,1,2.0,1),(21,160,1,7.0,1),(22,160,1,8.0,1),(23,160,1,8.0,1),(24,160,2,2.0,1),(25,160,2,2.0,1),(26,160,2,2.0,1),(27,162,1,2.0,1),(28,163,1,3.0,1),(29,163,9,4.0,1),(30,163,5,5.0,1),(31,163,5,5.0,1),(32,163,5,5.0,1),(33,163,5,5.0,1),(34,163,5,5.0,1),(35,163,5,5.0,1),(36,163,1,5.0,1),(37,163,1,5.0,1),(38,163,1,5.0,1),(39,163,1,5.0,1),(40,163,1,5.0,1),(41,163,1,5.0,1),(42,163,1,5.0,1),(43,163,1,5.0,1),(44,163,1,5.0,1),(45,163,1,5.0,1),(46,163,1,5.0,1),(47,163,1,5.0,1),(48,168,1,2.0,1),(49,171,1,2.0,1),(50,171,1,2.0,1),(51,171,1,2.0,1),(52,171,1,2.0,1),(53,173,1,2.0,1),(54,173,1,3.0,1),(55,176,1,2.0,1),(56,178,1,2.0,1),(57,179,1,2.0,1),(58,180,7,5.0,1),(59,180,1,2.0,1),(60,180,1,0.0,1),(61,180,1,9.0,1),(62,183,1,2.0,1),(63,185,1,2.0,1),(64,185,1,2.0,1),(65,186,1,2.0,1),(66,186,5,4.0,1),(67,186,1,5.0,1),(68,187,1,2.0,1),(69,187,7,3.0,1),(70,188,1,2.0,1),(71,189,1,3.0,1),(72,189,8,5.0,1),(73,191,1,2.0,1),(74,192,1,2.0,1),(75,192,1,3.0,1),(76,193,1,3.0,1),(77,194,1,2.0,1),(78,195,1,2.0,1),(79,196,1,1.0,1),(80,197,1,1.0,1),(81,197,1,2.0,1),(82,197,1,2.0,1),(83,198,1,2.0,1),(84,199,1,2.0,1),(85,199,1,3.0,1),(86,200,1,2.0,1),(87,200,1,3.0,1),(88,200,1,4.0,1),(89,201,1,2.0,1),(90,201,1,3.0,1),(91,201,1,4.0,1),(92,201,2,5.0,1),(93,202,1,2.0,1),(94,202,1,3.0,1),(95,202,1,3.0,1),(96,202,1,3.0,1),(97,202,1,3.0,1),(98,202,1,3.0,1),(99,202,1,3.0,1),(100,202,1,3.0,1),(101,202,1,3.0,1),(102,203,1,2.0,1),(103,203,1,2.0,1),(104,203,1,2.0,1),(105,203,1,2.0,1),(106,203,1,2.0,1),(107,203,1,2.0,1),(108,203,1,2.0,1),(109,204,7,2.0,1),(110,204,1,3.0,1),(111,204,2,5.0,1),(112,205,7,3.0,1),(113,205,1,2.0,1),(114,206,1,2.0,1),(115,206,2,3.0,1),(116,206,3,3.0,1),(117,206,9,5.0,1),(118,207,8,3.0,1),(119,207,1,3.0,1),(120,208,1,3.0,1),(121,208,2,2.0,1),(122,208,3,4.0,1),(123,208,7,3.0,1),(124,209,7,3.0,1),(125,209,1,2.0,1),(126,209,2,3.0,1),(127,210,1,2.0,1),(128,210,2,5.0,1),(129,210,9,3.0,1),(130,210,5,10.0,1),(131,211,7,3.0,1),(132,211,2,5.0,1),(133,211,11,10.0,1),(134,212,1,2.0,1),(135,212,8,3.0,1),(136,213,1,3.0,1),(137,213,9,3.0,1),(138,214,1,3.0,1),(139,214,2,3.0,1),(140,215,1,2.0,1),(141,215,7,3.0,1),(142,215,1,2.0,1),(143,215,3,4.0,1),(144,215,2,5.0,1),(145,215,5,4.0,1),(146,216,1,3.0,1),(147,216,7,4.0,1),(148,216,10,4.0,1),(149,216,9,4.0,1),(150,216,11,5.0,1),(151,217,1,3.0,1),(152,217,4,4.0,1),(153,217,7,4.0,1),(154,217,2,5.0,1),(155,218,1,3.0,1),(156,218,2,4.0,1),(157,219,1,3.0,1),(158,219,8,4.0,1),(159,219,2,5.0,1),(160,220,1,2.0,1),(161,220,2,3.0,1),(162,220,10,4.0,1),(163,221,1,3.0,1),(164,221,2,4.0,1),(165,221,3,3.0,1),(166,222,1,2.0,1),(167,222,2,3.0,1),(168,222,3,4.0,1),(169,223,1,2.0,1),(170,223,2,3.0,1),(171,223,3,4.0,1),(172,224,1,2.0,1),(173,224,10,3.0,1),(174,224,2,5.0,1),(175,224,4,2.0,1),(176,224,4,2.0,1),(177,224,4,2.0,1),(178,224,4,2.0,1),(179,224,11,2.0,0),(180,224,11,3.0,0),(181,224,5,5.0,0),(182,224,3,3.0,0),(183,224,10,2.0,0),(184,224,11,5.0,0),(185,224,9,1.0,0),(186,224,9,1.0,0),(187,224,11,11.0,0),(193,13,1,3.0,0),(199,25,10,2.0,0),(200,52,7,3.0,0),(203,223,6,3.0,0),(204,3,6,3.0,0),(205,3,11,5.0,0),(206,3,12,6.0,0),(207,3,3,5.0,0),(208,3,13,6.0,0);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'kg'),(2,'pc'),(3,'L');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-22 14:22:04
