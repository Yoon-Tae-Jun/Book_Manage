-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: librarydb.csajpcjqomkl.ap-northeast-2.rds.amazonaws.com    Database: librarySystem
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `bookID` int NOT NULL AUTO_INCREMENT,
  `BookName` char(30) NOT NULL,
  `BookAuthor` char(30) NOT NULL,
  `BookGenre` int NOT NULL,
  `isLoan` tinyint(1) NOT NULL DEFAULT '1',
  `isReserve` tinyint(1) NOT NULL DEFAULT '1',
  `borrowedUser` int DEFAULT NULL,
  `reservedUser` int DEFAULT NULL,
  `loanDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `cntExtension` int DEFAULT '3',
  `PublicationYear` char(5) NOT NULL DEFAULT '2022',
  `ImageURL` varchar(2083) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'불편한 편의점','김호연',813,1,1,NULL,NULL,NULL,NULL,3,'2022','http://image.yes24.com/goods/99308021/XL'),(2,'강아지똥','권정생',813,1,0,NULL,1,NULL,NULL,3,'2022','http://image.yes24.com/goods/15320/XL'),(3,'미래가 온다 매직 사이언스','김성화, 권수진',508,0,1,1,NULL,'2022-06-18','2022-06-25',3,'2022','http://image.yes24.com/goods/105655963/XL'),(4,'달러구트 꿈 백화점','이미예',813,1,1,NULL,NULL,NULL,NULL,3,'2022','http://image.yes24.com/goods/91065309/XL'),(5,'백광','렌조 미키히코',813,1,1,NULL,NULL,NULL,NULL,3,'2022','http://image.yes24.com/goods/107072836/XL');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 18:43:55
