-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: poo-pizzeria
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Dumping data for table `DetallePedido`
--

LOCK TABLES `DetallePedido` WRITE;
/*!40000 ALTER TABLE `DetallePedido` DISABLE KEYS */;
INSERT INTO `DetallePedido` VALUES (1,2,125,1,1,1,1237),(2,1,80,3,1,1,1237),(3,1,125,1,2,1,1238);
/*!40000 ALTER TABLE `DetallePedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `EstadoFactura`
--

LOCK TABLES `EstadoFactura` WRITE;
/*!40000 ALTER TABLE `EstadoFactura` DISABLE KEYS */;
INSERT INTO `EstadoFactura` VALUES (1,'Generada');
/*!40000 ALTER TABLE `EstadoFactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `EstadoPedido`
--

LOCK TABLES `EstadoPedido` WRITE;
/*!40000 ALTER TABLE `EstadoPedido` DISABLE KEYS */;
INSERT INTO `EstadoPedido` VALUES (1,'Pendiente de Facturación'),(2,'Facturado');
/*!40000 ALTER TABLE `EstadoPedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
INSERT INTO `Factura` VALUES (1237,'2017-05-11 18:09:22',1),(1238,'2017-08-11 10:25:33',1);
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Pedido`
--

LOCK TABLES `Pedido` WRITE;
/*!40000 ALTER TABLE `Pedido` DISABLE KEYS */;
INSERT INTO `Pedido` VALUES (1,'2017-04-11 21:30:00','2017-04-11 21:37:00','Joaquín',1237,2),(2,'2017-04-12 12:00:00','2017-04-12 12:30:00','Mariano',1238,2);
/*!40000 ALTER TABLE `Pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Pizza`
--

LOCK TABLES `Pizza` WRITE;
/*!40000 ALTER TABLE `Pizza` DISABLE KEYS */;
INSERT INTO `Pizza` VALUES (1,'Napolitana Normal',125,2,1,2),(2,'Especial grande',150,3,2,1),(3,'Mozzarella chica',80,1,3,2);
/*!40000 ALTER TABLE `Pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `TamanioPizza`
--

LOCK TABLES `TamanioPizza` WRITE;
/*!40000 ALTER TABLE `TamanioPizza` DISABLE KEYS */;
INSERT INTO `TamanioPizza` VALUES (1,'Pequeña',4),(2,'Normal',8),(3,'Grande',12);
/*!40000 ALTER TABLE `TamanioPizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `TipoPizza`
--

LOCK TABLES `TipoPizza` WRITE;
/*!40000 ALTER TABLE `TipoPizza` DISABLE KEYS */;
INSERT INTO `TipoPizza` VALUES (1,'Horno','Pizza cocinada en horno industrial.'),(2,'Parrilla','Pizza cocinada en parrilla.');
/*!40000 ALTER TABLE `TipoPizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `VariedadPizza`
--

LOCK TABLES `VariedadPizza` WRITE;
/*!40000 ALTER TABLE `VariedadPizza` DISABLE KEYS */;
INSERT INTO `VariedadPizza` VALUES (1,'Napolitana','muzarella, salsa, tomates, aceitunas, oregano, ajo'),(2,'Especial','mozzarella, salsa, jamón cocido, morrón, aceitunas, oregano'),(3,'Mozzarella','mozzarella, salsa, aceitunas, oregano');
/*!40000 ALTER TABLE `VariedadPizza` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-21 10:36:39
