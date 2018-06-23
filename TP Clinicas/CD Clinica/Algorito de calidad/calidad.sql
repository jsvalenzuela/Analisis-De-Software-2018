-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: calidad
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `aspecto`
--

DROP TABLE IF EXISTS `aspecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aspecto` (
  `id_aspecto` int(11) NOT NULL AUTO_INCREMENT,
  `id_caracteristica` int(10) unsigned DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_aspecto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aspecto`
--

LOCK TABLES `aspecto` WRITE;
/*!40000 ALTER TABLE `aspecto` DISABLE KEYS */;
INSERT INTO `aspecto` (`id_aspecto`, `id_caracteristica`, `nombre`) VALUES (1,1,'Seguridad de Acceso'),(3,2,'Tolerancia a fallos'),(4,2,'Capacidad de recuperacion de errores'),(5,3,'Capacidad del codigo de ser analizado'),(6,3,'Capacidad del codigo de ser cambiado'),(7,3,'Estabilidad'),(8,4,'Capacidad de ser entendido'),(9,4,'Capacidad de ser operado'),(10,4,'Capacidad de ser atractivo para el usuario'),(11,5,'Utilizacion de recursos'),(12,5,'Comportamiento frente al tiempo'),(13,6,'Adaptabilidad'),(14,6,'Instalabilidad'),(15,1,'Exactitud de los resultados');
/*!40000 ALTER TABLE `aspecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristica`
--

DROP TABLE IF EXISTS `caracteristica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristica` (
  `id_caracteristica` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `ponderacion` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_caracteristica`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristica`
--

LOCK TABLES `caracteristica` WRITE;
/*!40000 ALTER TABLE `caracteristica` DISABLE KEYS */;
INSERT INTO `caracteristica` (`id_caracteristica`, `nombre`, `ponderacion`) VALUES (1,'Funcionalidad',10),(2,'Fiabilidad',10),(3,'Mantenibilidad',10),(4,'Usabilidad',10),(5,'Eficiencia',10),(6,'Portabilidad',1);
/*!40000 ALTER TABLE `caracteristica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valor`
--

DROP TABLE IF EXISTS `valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valor` (
  `id_valor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `nulo` tinyint(1) DEFAULT NULL,
  `id_aspecto` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_valor`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valor`
--

LOCK TABLES `valor` WRITE;
/*!40000 ALTER TABLE `valor` DISABLE KEYS */;
INSERT INTO `valor` (`id_valor`, `nombre`, `nulo`, `id_aspecto`) VALUES (1,'Los datos de acceso estan encriptados?',NULL,1),(2,'Contempla inicio de sesion de usuarios',NULL,1),(3,'Cuando sucede un error se protegen los datos procesados',NULL,3),(4,'Se realiza un log con la actividad del sistema',NULL,3),(5,'Se muestran en pantallas mensajes de error',NULL,3),(6,'El sistema reanuda las activiades si se produce una falla critica',NULL,4),(7,'El sistema reanuda sus actividades y vuelve al estado en que estaba',NULL,4),(8,'El codigo se encuentra comentado en al menos un 10%',NULL,5),(9,'El codigo se encuentra organizado en modulos',NULL,5),(10,'El codigo tiene una complejidad ciclomatica menor a 12?',NULL,6),(11,'El codigo usa patrones de disenio',NULL,6),(12,'El codigo fue desarrollado con algun framework o standar de desarrollo?',NULL,6),(13,'Pasa un caso de prueba con un lote de datos para representar un Escaleno valido',NULL,7),(14,'Pasa un caso de prueba con un lote de datos para representar un Isosceles valido',NULL,7),(15,'Pasa un caso de prueba con un lote de datos para representar un Equilatero valido',NULL,7),(16,'Pasa un caso de prueba con algun lado igual a 0',NULL,7),(17,'Pasa una prueba que incluya un valor negativo',NULL,7),(18,'Pasa una prueba en la cual se usaron tres numeros positivos tales que la suma de dos de ellos sea igual al tercero ',NULL,7),(19,'Pasa una prueba en la cual algun lado no sea un numero entero',NULL,7),(20,'Los resultados tiene un error inferior a 10^-3',NULL,15),(21,'Los resultados tiene un error inferior a 10^-6',NULL,15),(22,'Los resultados tiene un error inferiro a 10^-7',NULL,15),(23,'Posee ayuda contextual sobre menus y botones de accion.',NULL,8),(24,'Manual de usuario incorporado al sistema como un menu dedicado.',NULL,8),(25,'Es operable sin necesidad de asistencia adicional',NULL,9),(26,'tiene una interfaz grafica facil de comprender',NULL,10),(27,'La organizacion de los modulos permite acceder a la funcionalidad deseada en pocos pasos?',NULL,10),(28,'Utiliza el procesador en un 40 o mas?',NULL,11),(29,'Utiliza el procesador en un 70% o mas?',NULL,11),(30,'utiliza el procesador por encima de 80%',NULL,11),(31,'Brinda respuestas en un tiempo inferior a 10 segundos',NULL,12),(32,'Brinda respuestas en un tiempo inferior a 5 segundos',NULL,12),(33,'Brinda respuestas en un tiempo inferior a los 3 segundos',NULL,12),(34,'Es compatible con windows',NULL,13),(35,'Es compatible con Linux',NULL,13),(36,'Es compatible con MacOS',NULL,13),(40,'Se instala en menos de 15 pasos',NULL,14),(41,'Se instala en menos de 10 pasos',NULL,14),(42,'Se instala en menos de 7 pasos',NULL,14);
/*!40000 ALTER TABLE `valor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-12 15:43:22
