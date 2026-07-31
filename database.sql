-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinefruitstore
-- ------------------------------------------------------
-- Server version	8.0.32

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

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `total` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9emlp6m95v5er2bcqkjsw48he` (`user_id`),
  CONSTRAINT `FKg5uhi8vpsuy0lgloxk2h4w5o6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (0,1,2),(0,3,1),(0,4,3);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_item` (
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `cart_id` bigint DEFAULT NULL,
  `fruit_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id`),
  KEY `FKsnohjdm0lcxnbcxsucr76ah68` (`fruit_id`),
  CONSTRAINT `FK1uobyhgl1wvgt1jpccia8xxs3` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FKsnohjdm0lcxnbcxsucr76ah68` FOREIGN KEY (`fruit_id`) REFERENCES `fruit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (58,1,1,121,29),(120,1,3,6,32),(150,1,4,8,34);
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fruit`
--

DROP TABLE IF EXISTS `fruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fruit` (
  `available` bit(1) NOT NULL,
  `min_quantity` double NOT NULL,
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `shop_id` bigint DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkbv40hpaabd0a140qh5msc8kc` (`shop_id`),
  CONSTRAINT `FKkbv40hpaabd0a140qh5msc8kc` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fruit`
--

LOCK TABLES `fruit` WRITE;
/*!40000 ALTER TABLE `fruit` DISABLE KEYS */;
INSERT INTO `fruit` VALUES (_binary '',1,120,50,6,5,'Fresh red apples','Banana.png','Banana','kg'),(_binary '',1,50,100,7,5,'Fresh yellow bananas','Banana.png','Banana','kg'),(_binary '',1,150,30,8,5,'Juicy mangoes','Mango.png','Mango','kg'),(_binary '',1,80,40,9,5,'Sweet oranges','Orange.png','Orange','kg'),(_binary '',1,90,60,10,5,'Fresh grapes','Grapve.JPEG','Grapes','kg'),(_binary '',1,200,20,11,5,'Fresh pineapples','Pineapple.png','Pinapple','kg'),(_binary '',1,100,10,12,5,'Ripe papayas','Papaya.png','Papaya','kg'),(_binary '',1,300,15,13,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,14,5,'Sweet watermelons','Watermelon.png','Watermelon','kg'),(_binary '',1,70,30,15,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,16,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,17,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,18,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,19,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,20,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,21,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,22,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,23,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,24,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,25,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,26,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,27,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,28,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,29,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,30,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,31,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,32,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,33,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,34,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,35,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,36,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,37,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,38,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,39,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,40,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,41,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,42,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,43,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,44,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,45,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,46,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,47,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,48,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,49,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,50,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,51,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,52,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,53,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,54,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,55,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,56,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,57,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,58,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,59,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,60,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,61,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,62,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,63,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,64,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,65,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,66,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,67,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,68,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,69,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,70,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,71,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,72,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,73,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,74,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,75,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,76,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,77,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,78,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,79,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,80,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,81,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,82,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,83,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,84,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,85,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,86,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,87,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,88,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,89,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,90,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,91,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,92,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,93,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,94,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,95,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,96,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,97,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,98,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,99,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,100,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,101,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,102,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,103,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,104,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,105,5,'Fresh guavas','Guava.png','Guava','kg'),(_binary '',1,250,10,106,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,107,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,108,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,109,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,110,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',1,200,20,111,5,'Fresh pineapples','Pinaple.png','Pineapple','kg'),(_binary '',1,100,10,112,5,'Ripe papayas','Papai.JPEG','Papaya','kg'),(_binary '',1,300,15,113,5,'Fresh strawberries','Strawberry.png','Strawberry','kg'),(_binary '',1,40,35,114,5,'Sweet watermelons','Watermelon.JPEG','Watermelon','kg'),(_binary '',1,70,30,115,5,'Fresh guavas','Guva.png','Guava','kg'),(_binary '',1,250,10,116,5,'Fresh kiwis','Kiwi.png','Kiwi','kg'),(_binary '',1,120,20,117,5,'Juicy pomegranates','Pomegranate.png','Pomegranate','kg'),(_binary '',1,110,25,118,5,'Fresh pears','Pear.png','Pear','kg'),(_binary '',1,400,8,119,5,'Fresh cherries','Cherry.png','Cherry','kg'),(_binary '',1,180,15,120,5,'Sweet litchis','Litchi.png','Litchi','kg'),(_binary '',0,58,10,121,7,'Fresh Dadim','Dadim.JPEG','Dadim','kg'),(_binary '',1,200,50,122,5,'Premium quality sweet mangoes','mango.jpg','Alphonso Mango','kg'),(_binary '',1,180,40,123,5,'Fresh and crunchy green apples','green-apple.jpg','Green Apple','kg'),(_binary '',1,50,100,124,6,'Ripe yellow bananas','banana.jpg','Banana','dozen'),(_binary '',1,80,60,125,6,'Juicy Nagpur oranges','Orange.jpg','Orange','kg'),(_binary '',1,250,30,126,7,'Fresh organic strawberries','strawberry.jpg','Strawberry','box'),(_binary '',1,400,20,127,7,'Imported fresh blueberries','blueberry.jpg','Blueberry','box'),(_binary '',1,90,25,128,8,'Sweet tropical pineapple','pineapple.jpg','Pineapple','piece'),(_binary '',1,160,45,129,8,'Fresh red pomegranate (Dadim)','pomegranate.jpg','Pomegranate','kg'),(_binary '',1,150,55,130,9,'Kashmiri red apples','red-apple.jpg','Red Apple','kg'),(_binary '',1,120,35,131,9,'Sweet and soft pears','pear.jpg','Pear','kg'),(_binary '',1,30,20,160,10,'Big and juicy summer watermelons','watermelon.jpg','Watermelon','kg'),(_binary '',1,180,40,161,11,'Sweet and aromatic Kesar mangoes','kesar-mango.jpg','Kesar Mango','kg'),(_binary '',1,350,10,162,12,'Fresh red raspberries','raspberry.jpg','Raspberry','box');
/*!40000 ALTER TABLE `fruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order-item`
--

DROP TABLE IF EXISTS `order-item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order-item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `fruit_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo8ayf9jijw7gbwakj2g35vhto` (`fruit_id`),
  KEY `FK5vx6tvbwh08s4psa31frxwuk4` (`order_id`),
  CONSTRAINT `FK5vx6tvbwh08s4psa31frxwuk4` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKo8ayf9jijw7gbwakj2g35vhto` FOREIGN KEY (`fruit_id`) REFERENCES `fruit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order-item`
--

LOCK TABLES `order-item` WRITE;
/*!40000 ALTER TABLE `order-item` DISABLE KEYS */;
INSERT INTO `order-item` VALUES (1,300,6,6,3),(2,300,1,7,3),(3,270,3,8,3),(4,240,2,9,3),(5,360,3,10,3),(6,0,1,11,3),(7,40,1,12,3),(8,70,1,13,3),(9,300,6,6,4),(10,300,1,7,4),(11,270,3,8,4),(12,240,2,9,4),(13,360,3,10,4),(14,0,1,11,4),(15,40,1,12,4),(16,70,1,13,4),(17,40,1,14,5),(18,0,1,15,5),(19,120,1,16,6),(20,50,1,17,6),(21,120,1,18,7),(22,120,1,19,8),(23,120,1,20,9),(24,90,1,21,10),(25,120,1,22,11),(26,120,1,22,12),(27,120,1,24,13),(28,120,1,24,14),(29,120,1,24,15),(30,360,3,26,16),(31,180,2,27,16),(32,120,1,28,17),(33,50,1,30,18),(34,90,1,31,18),(35,50,1,33,19);
/*!40000 ALTER TABLE `order-item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order-items`
--

DROP TABLE IF EXISTS `order-items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order-items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `fruit_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhdedbaqvhon1entokl7lmid27` (`fruit_id`),
  KEY `FKjsunpnrxfman4lcs9h3j1vduq` (`order_id`),
  CONSTRAINT `FKhdedbaqvhon1entokl7lmid27` FOREIGN KEY (`fruit_id`) REFERENCES `fruit` (`id`),
  CONSTRAINT `FKjsunpnrxfman4lcs9h3j1vduq` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order-items`
--

LOCK TABLES `order-items` WRITE;
/*!40000 ALTER TABLE `order-items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order-items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `fruit_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8mat9tjqiwtfaxxk35j9tsqaw` (`fruit_id`),
  KEY `FKt4dc2r9nbvbujrljv3e23iibt` (`order_id`),
  CONSTRAINT `FK8mat9tjqiwtfaxxk35j9tsqaw` FOREIGN KEY (`fruit_id`) REFERENCES `fruit` (`id`),
  CONSTRAINT `FKt4dc2r9nbvbujrljv3e23iibt` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (300,6,6,1,1),(300,1,7,2,1),(270,3,8,3,1),(240,2,9,4,1),(360,3,10,5,1),(0,1,11,6,1),(40,1,12,7,1),(70,1,13,8,1),(300,6,6,9,2),(300,1,7,10,2),(270,3,8,11,2),(240,2,9,12,2),(360,3,10,13,2),(0,1,11,14,2),(40,1,12,15,2),(70,1,13,16,2);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `total_amount` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_date` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4600,1,'2026-01-21 16:00:50.666600',2,'PLACED'),(4600,2,'2026-01-21 16:11:41.999052',2,'PLACED'),(4600,3,'2026-01-21 16:23:28.068691',2,'PLACED'),(4600,4,'2026-01-21 16:58:03.799875',2,'PLACED'),(60,5,'2026-01-21 19:36:57.900080',2,'PLACED'),(190,6,'2026-01-21 19:42:55.291031',2,'PLACED'),(140,7,'2026-01-21 19:49:03.407651',2,'PLACED'),(140,8,'2026-01-21 20:00:15.859498',2,'PLACED'),(140,9,'2026-01-21 20:05:50.137271',2,'PLACED'),(110,10,'2026-01-21 20:08:11.943221',2,'PLACED'),(140,11,'2026-01-21 20:15:00.480761',2,'PLACED'),(140,12,'2026-01-21 20:21:21.119953',2,'PLACED'),(140,13,'2026-01-21 22:27:01.789878',2,'PLACED'),(140,14,'2026-01-21 22:39:02.825724',2,'PLACED'),(140,15,'2026-01-21 22:42:37.110222',2,'PLACED'),(1460,16,'2026-01-21 23:13:29.205263',2,'PLACED'),(140,17,'2026-01-22 09:24:05.817138',2,'PLACED'),(160,18,'2026-01-22 14:05:09.174072',3,'PLACED'),(70,19,'2026-01-22 20:32:30.659032',3,'PLACED');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops` (
  `admin_id` bigint NOT NULL,
  `shop_id` bigint NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `FKcr3mjv9a9j22tdw4tc4pdib9u` (`admin_id`),
  CONSTRAINT `FKcr3mjv9a9j22tdw4tc4pdib9u` FOREIGN KEY (`admin_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (1,5,'My Fruit Shop','ACTIVE'),(1,6,'Fresh Garden Fruits','ACTIVE'),(1,7,'Organic Berry Hub','ACTIVE'),(1,8,'Royal Fruit Palace','ACTIVE'),(1,9,'Golden Apple Store','ACTIVE'),(1,10,'Mumbai Fresh Fruits','ACTIVE'),(1,11,'Organic Mango Hub','ACTIVE'),(1,12,'Healthy Berry Mart','ACTIVE');
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Pune, Maharashtra','admin@gmail.com','Admin User','admin123','ADMIN'),(2,'Pune','rohit031@gmail.com',' rohit chaudhari','123456789','CUSTOMER'),(3,'hudco coloni , dondaicha','sonalichaudhari031@gmail.com','sonali chaudhari','12345678','CUSTOMER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-22 23:14:13
