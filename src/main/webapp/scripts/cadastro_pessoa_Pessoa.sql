
DROP TABLE IF EXISTS `Pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `dataNascimento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

LOCK TABLES `Pessoa` WRITE;
/*!40000 ALTER TABLE `Pessoa` DISABLE KEYS */;
INSERT INTO `Pessoa` VALUES (1,'Teste','2012-06-18 10:34:09'),(2,'Danilo Atualizado','1987-08-15 08:25:48'),(4,'Danilo Atualizado4444444','1987-08-15 08:25:48'),(5,'Danilo Atualizado','1987-08-15 08:25:48'),(6,'Danilo Atualizado','1987-08-15 08:25:48');

UNLOCK TABLES;

