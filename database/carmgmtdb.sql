-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: carmgmtdb
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(20) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL,
  `cost` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (9,'Maruti 800','2001',0,'1 Lakh'),(10,'glanza','2023',0,'8 Lakh'),(12,'Ford Model N','1904',0,'50K'),(13,'Alto','2005',0,'5 Lakhs'),(14,'Nano','2014',1,'2 Lakhs'),(15,'Nano','2015',0,'2.5 Lakhs'),(16,'PAGANI','2020',1,'45CR'),(23,'ELUX 64 C','2024',1,'99CR');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'testuser','1234','test','user','testuser@gmail.com','0123456789','test address'),(2,'johndoe','1234','John','Doe','johndoe@gmail.com','0999888111','John Residency'),(3,'foobar','abcd','foo','bar','foobar@gmail.com','1111111111','foo street'),(4,'TOM','t','TOMMY','SHELBY','thoma@gmail.com','13990646','THOMMAN VEEDU');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `amount` varchar(20) DEFAULT NULL,
  `payment_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (3,10,2,'8 Lakh','2023-12-07,21:57:33'),(4,12,1,'50K','2023-12-07,21:58:11'),(5,13,1,'5 Lakhs','2023-12-07,22:08:10'),(6,15,3,'2.5 Lakhs','2023-12-07,22:11:34'),(7,9,4,'1 Lakh','2023-12-08,14:23:26');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'teststaff','abcd','billy','bob','0987654321','testbilly@gmail.com'),(2,'admin','abcd','johny','sons','9991112223','johnysons@gmail.com');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-10 15:00:20
