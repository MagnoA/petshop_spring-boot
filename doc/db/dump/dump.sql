-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: petshop
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `tb_client`
--

DROP TABLE IF EXISTS `tb_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q5ytvlvjsf67yw11ydrh4xwrj` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_client`
--

LOCK TABLES `tb_client` WRITE;
/*!40000 ALTER TABLE `tb_client` DISABLE KEYS */;
INSERT INTO `tb_client` VALUES (1,'rua 1','155.038.607-72','ricardo','4899999999'),(2,'rua 3','215.377.474-87','maria','4899999999'),(3,'rua 4','268.411.449-88','carlos','4899999999'),(4,'rua 6','318.638.462-12','maicon','4899999999'),(5,'rua 10','535.753.854-91','jorge','4899999999');
/*!40000 ALTER TABLE `tb_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee`
--

DROP TABLE IF EXISTS `tb_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_em9lvg7whqbrro5fbav5bt0gy` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee`
--

LOCK TABLES `tb_employee` WRITE;
/*!40000 ALTER TABLE `tb_employee` DISABLE KEYS */;
INSERT INTO `tb_employee` VALUES (1,'joao@vet.com','joao','$2a$10$CYiO/MRFN8lffRKnurAqFO1ybp4.uXymNnaEGWdGR8wOGzoXKFf3G','REOLE_VET'),(2,'maria@vet.com','maria','$2a$10$URkHWM2AAE2edwxyJA9sKOih9buIoLXXLIzLcFqmqPgkThTMtv.LG','REOLE_VET'),(3,'sandra@vet.com','sandra','$2a$10$rkN2gzyVCAHpiWu2uDHvYubw67kgA9/6e0VyF572q21Fkg5rBjSjq','REOLE_VET'),(4,'felipe@vet.com','felipe','$2a$10$4Aj79/uoTc1yxXiEMba0V.DXiLGPOdpXIM/bqfQdfcjcqt.efCSGO','REOLE_VET'),(5,'carina@vet.com','carina','$2a$10$P.fOJo97p1Q2UQkcA0H6p.RXa3ijA8F3EUgpJdD6XenG8qILFAhKO','REOLE_VET'),(6,'paulo@vet.com','paulo','$2a$10$UJ57yA36fdfe2TYbaIHEAO469FM0LQb8B.hYgd2ukIb/Bzi/o74nG','REOLE_VET'),(7,'daiane@vet.com','daiane','$2a$10$dbEcWoiZetwni1OWcyexMue2GvX3kthh5RKJPQr1TBa3LFNHA2AN6','REOLE_VET'),(8,'lucas@vet.com','lucas','$2a$10$XP0Zwune3sSUqrLPqSOdk.VCUflAogwxuZkW2308gehx3xbb.2/Mu','REOLE_VET');
/*!40000 ALTER TABLE `tb_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pet`
--

DROP TABLE IF EXISTS `tb_pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `breed` varchar(255) NOT NULL,
  `kind` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `id_client` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_numbg71xkwaae5tp9cspq3exm` (`id_client`),
  CONSTRAINT `FK_numbg71xkwaae5tp9cspq3exm` FOREIGN KEY (`id_client`) REFERENCES `tb_client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pet`
--

LOCK TABLES `tb_pet` WRITE;
/*!40000 ALTER TABLE `tb_pet` DISABLE KEYS */;
INSERT INTO `tb_pet` VALUES (1,'chihuahua','cachorro','lala',1),(2,'poodle','cachorro','lele',1),(3,'savannah','gato','lili',2),(4,'vira-lata','gato','lolo',2),(5,'vira-lata','gato','teco',3),(6,'vira-lata','cachorro','boris',3),(7,'moleiro','papagaio','bilu',4),(8,'lutina','calopsita','ka',4),(9,'pitbull','cachorro','zeus',5),(10,'vira-lata','cahorro','maloca',5);
/*!40000 ALTER TABLE `tb_pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_schedule`
--

DROP TABLE IF EXISTS `tb_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_schedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `id_employee` bigint(20) NOT NULL,
  `id_pet` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9fcoamcit3711ym8d3rvjgyeg` (`id_employee`),
  KEY `FK_60b0wsteytvtfiatjcxwk8x1c` (`id_pet`),
  CONSTRAINT `FK_60b0wsteytvtfiatjcxwk8x1c` FOREIGN KEY (`id_pet`) REFERENCES `tb_pet` (`id`),
  CONSTRAINT `FK_9fcoamcit3711ym8d3rvjgyeg` FOREIGN KEY (`id_employee`) REFERENCES `tb_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_schedule`
--

LOCK TABLES `tb_schedule` WRITE;
/*!40000 ALTER TABLE `tb_schedule` DISABLE KEYS */;
INSERT INTO `tb_schedule` VALUES (1,'2020-10-29','13:30:00',2,9),(2,'2020-10-28','15:30:00',2,5),(3,'2020-10-19','13:30:00',7,1),(4,'2020-10-28','15:30:00',7,2),(5,'2020-10-19','16:30:00',1,3),(6,'2020-10-19','15:30:00',1,4),(7,'2020-10-20','16:30:00',6,5),(8,'2020-10-20','15:30:00',6,6),(9,'2020-10-22','13:30:00',3,7),(10,'2020-10-22','15:30:00',3,8),(11,'2020-10-23','13:30:00',5,9),(12,'2020-10-23','15:30:00',5,10);
/*!40000 ALTER TABLE `tb_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-06 20:17:43
