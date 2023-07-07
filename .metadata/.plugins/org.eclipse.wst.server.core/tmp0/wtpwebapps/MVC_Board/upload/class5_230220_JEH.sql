-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: class5_230220_JEH
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'John','Doe','010-1234-5678','john.doe@example.com'),(2,'Jane','Smith','010-2345-6789','jane.smith@example.com'),(3,'Mark','Johnson','010-3456-7890','mark.johnson@example.com'),(4,'Lucy','Brown','010-4567-8901','lucy.brown@example.com'),(5,'Tom','Lee','010-5678-9012','tom.lee@example.com'),(6,'Liam','Kim','010-6789-0123','liam.kim@example.com'),(7,'Ella','Choi','010-7890-1234','ella.choi@example.com'),(8,'Sophia','Park','010-8901-2345','sophia.park@example.com'),(9,'Mason','Lim','010-9012-3456','mason.lim@example.com'),(10,'Harper','Jeon','010-0123-4567','harper.jeon@example.com'),(11,'James','Kang','010-0234-5678','james.kang@example.com'),(12,'Olivia','Yoon','010-0345-6789','olivia.yoon@example.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `daily_sales`
--

DROP TABLE IF EXISTS `daily_sales`;
/*!50001 DROP VIEW IF EXISTS `daily_sales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `daily_sales` AS SELECT 
 1 AS `date`,
 1 AS `total_orders`,
 1 AS `total_sales`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `menu_item_sales`
--

DROP TABLE IF EXISTS `menu_item_sales`;
/*!50001 DROP VIEW IF EXISTS `menu_item_sales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `menu_item_sales` AS SELECT 
 1 AS `name`,
 1 AS `price`,
 1 AS `total_sold`,
 1 AS `total_sales`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `menu_items`
--

DROP TABLE IF EXISTS `menu_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_items` (
  `menu_item_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  `price` decimal(5,2) NOT NULL,
  `category` enum('Appetizer','Main Course','Dessert','Beverage') NOT NULL,
  PRIMARY KEY (`menu_item_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_items`
--

LOCK TABLES `menu_items` WRITE;
/*!40000 ALTER TABLE `menu_items` DISABLE KEYS */;
INSERT INTO `menu_items` VALUES (1,'Caesar Salad','Crisp romaine lettuce, croutons, Parmesan cheese, and Caesar dressing',7.99,'Appetizer'),(2,'Spaghetti Carbonara','Spaghetti with bacon, egg, and Parmesan cheese',12.99,'Main Course'),(3,'Margherita Pizza','Tomato, mozzarella, and basil',10.99,'Main Course'),(4,'Grilled Salmon','Grilled salmon served with mixed vegetables',16.99,'Main Course'),(5,'Cheesecake','Classic New York cheesecake with strawberry sauce',6.99,'Dessert'),(6,'Cappuccino','Espresso with steamed milk and foam',3.99,'Beverage'),(7,'Iced Tea','Refreshing iced tea with lemon',2.49,'Beverage');
/*!40000 ALTER TABLE `menu_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `menu_item_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `order_id` (`order_id`),
  KEY `menu_item_id` (`menu_item_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_items` (`menu_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,1,1,1),(2,1,2,1),(3,2,2,1),(4,2,6,1),(5,3,3,1),(6,4,4,1),(7,4,5,1),(8,5,1,1),(9,5,3,1),(10,5,4,1),(11,6,2,1),(12,6,7,1),(13,7,1,1),(14,7,3,1),(15,8,2,1),(16,8,5,1),(17,8,7,1),(18,9,6,1),(19,9,7,1),(20,10,3,1),(21,10,4,1),(22,11,5,1),(23,11,7,1),(24,12,2,1),(25,12,6,1),(26,13,1,1),(27,13,4,1),(28,14,1,1),(29,14,5,1),(30,15,2,1),(31,15,3,1),(32,15,6,1),(33,16,4,1),(34,16,7,1),(35,17,1,1),(36,17,3,1),(37,18,2,1),(38,18,5,1),(39,18,6,1),(40,19,4,1),(41,19,7,1),(42,20,1,1),(43,20,6,1);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `order_time` datetime NOT NULL,
  `total` decimal(7,2) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'2023-05-01 12:30:00',20.98),(2,2,'2023-05-01 17:15:00',23.48),(3,3,'2023-05-02 14:20:00',16.99),(4,4,'2023-05-03 19:10:00',24.98),(5,5,'2023-05-04 11:30:00',42.47),(6,6,'2023-05-05 13:45:00',26.97),(7,7,'2023-05-06 15:50:00',28.98),(8,8,'2023-05-07 16:15:00',33.48),(9,1,'2023-05-01 18:30:00',18.98),(10,2,'2023-05-02 13:15:00',21.48),(11,3,'2023-05-03 17:20:00',22.99),(12,4,'2023-05-04 12:10:00',19.98),(13,5,'2023-05-05 15:30:00',37.47),(14,6,'2023-05-06 14:45:00',21.97),(15,7,'2023-05-07 17:50:00',31.98),(16,8,'2023-05-01 11:15:00',16.48),(17,1,'2023-05-02 19:30:00',12.98),(18,2,'2023-05-03 16:15:00',29.48),(19,3,'2023-05-04 15:20:00',24.99),(20,4,'2023-05-05 18:10:00',16.98);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `reservation_time` datetime NOT NULL,
  `party_size` int NOT NULL,
  `table_id` int NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `customer_id` (`customer_id`),
  KEY `table_id` (`table_id`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`table_id`) REFERENCES `tables` (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,1,'2023-05-01 12:00:00',2,1),(2,2,'2023-05-01 17:00:00',4,2),(3,3,'2023-05-02 14:00:00',3,3),(4,4,'2023-05-03 19:00:00',2,4),(5,5,'2023-05-04 11:00:00',5,5),(6,6,'2023-05-05 13:00:00',2,1),(7,7,'2023-05-06 15:30:00',3,2),(8,8,'2023-05-07 16:00:00',4,3);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tables`
--

DROP TABLE IF EXISTS `tables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tables` (
  `table_id` int NOT NULL AUTO_INCREMENT,
  `table_number` int NOT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`table_id`),
  UNIQUE KEY `table_number` (`table_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tables`
--

LOCK TABLES `tables` WRITE;
/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
INSERT INTO `tables` VALUES (1,1,2),(2,2,4),(3,3,4),(4,4,2),(5,5,6);
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `daily_sales`
--

/*!50001 DROP VIEW IF EXISTS `daily_sales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `daily_sales` AS select date_format(`orders`.`order_time`,'%Y-%m-%d') AS `date`,count(0) AS `total_orders`,sum(`orders`.`total`) AS `total_sales` from `orders` group by `date` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `menu_item_sales`
--

/*!50001 DROP VIEW IF EXISTS `menu_item_sales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `menu_item_sales` AS select `mi`.`name` AS `name`,`mi`.`price` AS `price`,count(0) AS `total_sold`,sum(`mi`.`price`) AS `total_sales` from (`menu_items` `mi` join `order_items` `oi` on((`mi`.`menu_item_id` = `oi`.`menu_item_id`))) group by `oi`.`menu_item_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-11 11:17:11
