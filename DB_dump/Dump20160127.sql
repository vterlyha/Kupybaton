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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Bread'),(2,'Fruits'),(3,'Vegetables'),(4,'Drinks'),(5,'Alcohol'),(6,'Meat'),(7,'milk_products');
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
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list`
--

LOCK TABLES `list` WRITE;
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
INSERT INTO `list` VALUES (2,'home','2015-11-11',NULL),(3,' + listname + ','2016-01-19',NULL),(4,' + listname + ','2016-01-19',NULL),(5,' + listname + ','2016-01-19',NULL),(6,'work','2016-01-19',NULL),(7,'work1','2016-01-19',NULL),(8,'work1','2016-01-19',NULL),(9,'work','2016-01-19',NULL),(10,'work','2016-01-19',NULL),(11,'work','2016-01-19',NULL),(12,'work','2016-01-19',NULL),(13,'work','2016-01-19',NULL),(14,'home','2016-01-19',NULL),(15,'','2016-01-19',NULL),(16,'','2016-01-19',NULL),(17,'','2016-01-19',NULL),(18,'work','2016-01-19',NULL),(19,'','2016-01-20',NULL),(20,'','2016-01-20',NULL),(21,'','2016-01-20',NULL),(22,'','2016-01-20',NULL),(23,'work','2016-01-20',NULL),(24,'work','2016-01-20',NULL),(25,'work','2016-01-20',NULL),(26,'work','2016-01-20',NULL),(27,'work','2016-01-20',NULL),(28,'work','2016-01-20',NULL),(29,'work','2016-01-20',NULL),(30,'work','2016-01-20',NULL),(31,'work','2016-01-20',NULL),(32,'work','2016-01-20',NULL),(33,'work','2016-01-20',NULL),(34,'work','2016-01-20',NULL),(35,'work','2016-01-20',NULL),(36,'work','2016-01-20',NULL),(37,'work','2016-01-20',NULL),(38,'work','2016-01-20',NULL),(39,'work','2016-01-20',NULL),(40,'work','2016-01-21',NULL),(41,'work','2016-01-21',NULL),(42,'work','2016-01-21',NULL),(43,'home','2016-01-21',NULL),(44,'work','2016-01-21',NULL),(45,'work','2016-01-21',NULL),(46,'work','2016-01-21',NULL),(47,'work','2016-01-21',NULL),(48,'work','2016-01-21',NULL),(49,'work','2016-01-21',NULL),(50,'work','2016-01-21',NULL),(51,'work','2016-01-21',NULL),(52,'work','2016-01-21',NULL),(53,'work','2016-01-21',NULL),(54,'work','2016-01-21',NULL),(55,'work','2016-01-21',NULL),(56,'work','2016-01-21',NULL),(57,'work','2016-01-21',NULL),(58,'work','2016-01-21',NULL),(59,'work','2016-01-21',NULL),(60,'work','2016-01-21',NULL),(61,'work','2016-01-21',NULL),(62,'work','2016-01-21',NULL),(63,'work','2016-01-21',NULL),(64,'work','2016-01-21',NULL),(65,'work','2016-01-21',NULL),(66,'work','2016-01-21',NULL),(67,'work','2016-01-21',NULL),(68,'work','2016-01-22',NULL),(69,'work','2016-01-22',NULL),(70,'work','2016-01-22',NULL),(71,'work','2016-01-22',NULL),(72,'work','2016-01-22',NULL),(73,'work','2016-01-22',NULL),(74,'work','2016-01-22',NULL),(75,'work','2016-01-22',NULL),(76,'work','2016-01-22',NULL),(77,'work','2016-01-22',NULL),(78,'work','2016-01-22',NULL),(79,'work','2016-01-22',NULL),(80,'work','2016-01-22',NULL),(81,'work','2016-01-22',NULL),(82,'work','2016-01-22',NULL),(83,'work','2016-01-22',NULL),(84,'work','2016-01-22',NULL),(85,'work','2016-01-22',NULL),(86,'work','2016-01-22',NULL),(87,'work','2016-01-23',NULL),(88,'work','2016-01-23',NULL),(89,'work','2016-01-23',NULL),(90,'work','2016-01-23',NULL),(91,'work','2016-01-23',NULL),(92,'work','2016-01-23',NULL),(93,'work','2016-01-23',NULL),(94,'work','2016-01-23',NULL),(95,'work','2016-01-23',NULL),(96,'work','2016-01-23',NULL),(97,'work','2016-01-23',NULL),(98,'some','2016-01-23',NULL),(99,'some','2016-01-23',NULL),(100,'entry','2016-01-23',NULL),(101,'work','2016-01-23',NULL),(102,'work','2016-01-23',NULL),(103,'work','2016-01-23',NULL),(104,'work','2016-01-23',NULL),(105,'work','2016-01-23',NULL),(106,'work','2016-01-23',NULL),(107,'work','2016-01-23',NULL),(108,'work','2016-01-23',NULL),(109,'work','2016-01-23',NULL),(110,'work','2016-01-23',NULL),(111,'work','2016-01-23',NULL),(112,'work','2016-01-23',NULL),(113,'work','2016-01-24',NULL),(114,'work','2016-01-24',NULL),(115,'work','2016-01-24',NULL),(116,'work','2016-01-24',NULL),(117,'work','2016-01-24',NULL),(118,'work','2016-01-24',NULL),(119,'work','2016-01-24',NULL),(120,'work','2016-01-24',NULL),(121,'work','2016-01-24',NULL),(122,'work','2016-01-24',NULL),(123,'work','2016-01-24',NULL),(124,'home','2016-01-24',NULL),(125,'home','2016-01-24',NULL),(126,'home','2016-01-24',NULL),(127,'home','2016-01-24',NULL),(128,'home','2016-01-24',NULL),(129,'home','2016-01-24',NULL),(130,'home','2016-01-24',NULL),(131,'home','2016-01-24',NULL),(132,'home','2016-01-24',NULL),(133,'home1','2016-01-24',NULL),(134,'work','2016-01-24',NULL),(135,'work','2016-01-24',NULL),(136,'home','2016-01-24',NULL),(137,'home','2016-01-24',NULL),(138,'work','2016-01-24',NULL),(139,'work','2016-01-24',NULL),(140,'work','2016-01-24',NULL),(141,'home','2016-01-24',NULL),(142,'someList','2016-01-24',NULL),(143,'v','2016-01-25',NULL),(144,'work','2016-01-25',NULL),(145,'work','2016-01-25',NULL),(146,'work','2016-01-25',NULL),(147,'work','2016-01-25',NULL),(148,'work','2016-01-25',NULL),(149,'work','2016-01-25',NULL),(150,'work','2016-01-25',NULL),(151,'work','2016-01-25',NULL),(152,'work','2016-01-25',NULL),(153,'work','2016-01-25',NULL),(154,'work','2016-01-25',NULL),(155,'work','2016-01-25',NULL),(156,'work','2016-01-25',NULL),(157,'work','2016-01-25',NULL),(158,'work','2016-01-25',NULL),(159,'work','2016-01-25',NULL),(160,'work','2016-01-25',NULL),(161,'work','2016-01-25',NULL),(162,'work','2016-01-25',NULL),(163,'work','2016-01-25',NULL),(164,'work','2016-01-25',NULL),(165,'work','2016-01-25',NULL),(166,'work','2016-01-25',NULL),(167,'work','2016-01-25',NULL),(168,'work','2016-01-25',NULL),(169,'work','2016-01-25',NULL),(170,'work','2016-01-25',NULL),(171,'work','2016-01-25',NULL),(172,'work','2016-01-25',NULL),(173,'work','2016-01-25',NULL),(174,'work','2016-01-25',NULL),(175,'work','2016-01-26',NULL),(176,'work','2016-01-26',NULL),(177,'work','2016-01-26',NULL),(178,'work','2016-01-26',NULL),(179,'work','2016-01-26',NULL),(180,'work','2016-01-26',NULL),(181,'work','2016-01-26',NULL),(182,'work','2016-01-26',NULL),(183,'work','2016-01-26',NULL),(184,'work','2016-01-26',NULL),(185,'work','2016-01-26',NULL),(186,'work','2016-01-26',NULL),(187,'work','2016-01-27',NULL),(188,'work','2016-01-27',NULL),(189,'work','2016-01-27',NULL),(190,'work','2016-01-27',NULL),(191,'work','2016-01-27',NULL),(192,'work','2016-01-27',NULL),(193,'work','2016-01-27',NULL),(194,'work','2016-01-27',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'black_bread',1,1),(2,'apple',2,1),(3,'carrot',3,1),(4,'pita',1,1),(5,'beer',5,1),(6,'Pork',6,1),(7,'white_bread',1,1),(8,'grey_bread',1,1),(9,'french_bread',1,1),(10,'banana',2,1);
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
  CONSTRAINT `list_id` FOREIGN KEY (`list_id`) REFERENCES `list` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prod_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (7,140,1,2.0,1),(8,141,5,2.0,1),(9,142,1,3.0,1),(10,142,2,3.0,1),(11,142,5,10.0,1),(12,142,6,2.0,1),(13,142,3,3.5,1),(14,142,1,2.0,1),(15,157,1,2.0,1),(16,157,7,2.0,1),(17,157,8,3.0,1),(18,157,1,2.0,1),(19,157,1,2.0,1),(20,158,1,2.0,1),(21,160,1,7.0,1),(22,160,1,8.0,1),(23,160,1,8.0,1),(24,160,2,2.0,1),(25,160,2,2.0,1),(26,160,2,2.0,1),(27,162,1,2.0,1),(28,163,1,3.0,1),(29,163,9,4.0,1),(30,163,5,5.0,1),(31,163,5,5.0,1),(32,163,5,5.0,1),(33,163,5,5.0,1),(34,163,5,5.0,1),(35,163,5,5.0,1),(36,163,1,5.0,1),(37,163,1,5.0,1),(38,163,1,5.0,1),(39,163,1,5.0,1),(40,163,1,5.0,1),(41,163,1,5.0,1),(42,163,1,5.0,1),(43,163,1,5.0,1),(44,163,1,5.0,1),(45,163,1,5.0,1),(46,163,1,5.0,1),(47,163,1,5.0,1),(48,168,1,2.0,1),(49,171,1,2.0,1),(50,171,1,2.0,1),(51,171,1,2.0,1),(52,171,1,2.0,1),(53,173,1,2.0,1),(54,173,1,3.0,1),(55,176,1,2.0,1),(56,178,1,2.0,1),(57,179,1,2.0,1),(58,180,7,5.0,1),(59,180,1,2.0,1),(60,180,1,0.0,1),(61,180,1,9.0,1),(62,183,1,2.0,1),(63,185,1,2.0,1),(64,185,1,2.0,1),(65,186,1,2.0,1),(66,186,5,4.0,1),(67,186,1,5.0,1),(68,187,1,2.0,1),(69,187,7,3.0,1),(70,188,1,2.0,1),(71,189,1,3.0,1),(72,189,8,5.0,1),(73,191,1,2.0,1),(74,192,1,2.0,1),(75,192,1,3.0,1),(76,193,1,3.0,1),(77,194,1,2.0,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'kg'),(2,'pc');
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

-- Dump completed on 2016-01-27 21:35:06
