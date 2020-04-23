-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: friendsbets
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `UserFbs`
--

DROP TABLE IF EXISTS `UserFbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserFbs` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `password` binary(60) NOT NULL,
  `picturePath` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `tokenLastUsed` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hsmx9v717s0w7579dvui1hlf8` (`email`),
  UNIQUE KEY `UK_ses9577l90cyk96rdynv38cku` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserFbs`
--

--LOCK TABLES `UserFbs` WRITE;
/*!40000 ALTER TABLE `UserFbs` DISABLE KEYS */;
INSERT INTO `UserFbs` (id, email, nickname, password, picturePath, token, tokenLastUsed) VALUES 
(1,'Email1','User1', X'01FF' , NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:45.376067')
,(2,'Email2','User2', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:45.750676')
,(3,'Email3','User3', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:45.977417')
,(4,'Email4','User4', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:46.164746')
,(5,'Email5','User5', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:46.361013')
,(6,'Email6','User6', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:46.552286')
,(7,'Email7','User7', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:46.744169')
,(8,'Email8','User8', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:46.936324')
,(9,'Email9','User9', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:47.135876')
,(10,'Email10','User10', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:47.329047')
,(11,'Email11','User11', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:47.592056')
,(12,'Email12','User12', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:47.790120')
,(13,'Email13','User13', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:48.002962')
,(14,'Email14','User14', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:09:48.207520')
,(15,'a','a', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:10:02.971489')
,(16,'b','b', X'01FF',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.e30.vCFTMlx_7jwWROgmjAoVF_i7Aze6-omuCIfuHqfeDrvA0uE1-AcWZVg1dm8K7O7aEjG69KdfVjurrAZQOIF46Q','2020-04-10 11:43:48.388905')
,(1001,'Email1001','User1001', X'01FF',NULL,'a','2020-04-10 11:09:45.376067');
/*!40000 ALTER TABLE `UserFbs` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `UserFbs_friends`
--

DROP TABLE IF EXISTS `UserFbs_friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserFbs_friends` (
  `User_id` bigint(20) NOT NULL,
  `friends_id` bigint(20) NOT NULL,
  PRIMARY KEY (`User_id`,`friends_id`),
  --KEY `FK28yct10x9rv0qng1jamn4kiel` (`friends_id`),
  CONSTRAINT `FK28yct10x9rv0qng1jamn4kiel` FOREIGN KEY (`friends_id`) REFERENCES `UserFbs` (`id`),
  CONSTRAINT `FK4leq3qt0amirjkk6s95c1xdgb` FOREIGN KEY (`User_id`) REFERENCES `UserFbs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserFbs_friends`
--

--LOCK TABLES `UserFbs_friends` WRITE;
/*!40000 ALTER TABLE `UserFbs_friends` DISABLE KEYS */;
INSERT INTO `UserFbs_friends` VALUES (15,1),(16,1),(15,2),(16,2),(15,3),(15,4),(15,5),(15,6),(15,7),(15,8),(15,9),(15,10),(16,13),(16,14),(16,15);
/*!40000 ALTER TABLE `UserFbs_friends` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `GroupFbs`
--

DROP TABLE IF EXISTS `GroupFbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroupFbs` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picturePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GroupFbs`
--

--LOCK TABLES `GroupFbs` WRITE;
/*!40000 ALTER TABLE `GroupFbs` DISABLE KEYS */;
INSERT INTO `GroupFbs` VALUES (17,'b Group',NULL),(22,'a Group',NULL);
/*!40000 ALTER TABLE `GroupFbs` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `GroupFbs_userList`
--

DROP TABLE IF EXISTS `GroupFbs_userList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroupFbs_userList` (
  `grpList_id` bigint(20) NOT NULL,
  `userList_id` bigint(20) NOT NULL,
  PRIMARY KEY (`grpList_id`,`userList_id`),
  --KEY `FKri6gbehr00xnvu5p4957aotrp` (`userList_id`),
  CONSTRAINT `FKhfmx2a91qj92mxme4ro2yvod7` FOREIGN KEY (`grpList_id`) REFERENCES `GroupFbs` (`id`),
  CONSTRAINT `FKri6gbehr00xnvu5p4957aotrp` FOREIGN KEY (`userList_id`) REFERENCES `UserFbs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GroupFbs_userList`
--

--LOCK TABLES `GroupFbs_userList` WRITE;
/*!40000 ALTER TABLE `GroupFbs_userList` DISABLE KEYS */;
INSERT INTO `GroupFbs_userList` VALUES (17,1),(22,1),(17,2),(22,2),(22,3),(22,15),(17,16);
/*!40000 ALTER TABLE `GroupFbs_userList` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `BetFbs`
--

DROP TABLE IF EXISTS `BetFbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BetFbs` (
  `id` bigint(20) NOT NULL,
  `betType` varchar(255) NOT NULL,
  `gain` varchar(255) DEFAULT NULL,
  `betInitialUser_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  `match_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  --KEY `FK8at5pl5tlc1y1as095mbnjveb` (`betInitialUser_id`),
  --KEY `FKjp914asqb1feiory4a2ytplq` (`group_id`),
  --KEY `FKglrrfebr9wvl1okojxu7beao8` (`match_id`),
  CONSTRAINT `FK8at5pl5tlc1y1as095mbnjveb` FOREIGN KEY (`betInitialUser_id`) REFERENCES `UserFbs` (`id`),
  CONSTRAINT `FKglrrfebr9wvl1okojxu7beao8` FOREIGN KEY (`match_id`) REFERENCES `MatchFbs` (`id`),
  CONSTRAINT `FKjp914asqb1feiory4a2ytplq` FOREIGN KEY (`group_id`) REFERENCES `GroupFbs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BetFbs`
--

--LOCK TABLES `BetFbs` WRITE;
/*!40000 ALTER TABLE `BetFbs` DISABLE KEYS */;
/*!40000 ALTER TABLE `BetFbs` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `BetFbs_followers`
--

DROP TABLE IF EXISTS `BetFbs_followers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BetFbs_followers` (
  `betsFollowed_id` bigint(20) NOT NULL,
  `followers_id` bigint(20) NOT NULL,
  PRIMARY KEY (`betsFollowed_id`,`followers_id`),
  --KEY `FKlqp6cwodb49q8mii936crv37y` (`followers_id`),
  CONSTRAINT `FKf15s9qq07g69n2sexlk096agb` FOREIGN KEY (`betsFollowed_id`) REFERENCES `BetFbs` (`id`),
  CONSTRAINT `FKlqp6cwodb49q8mii936crv37y` FOREIGN KEY (`followers_id`) REFERENCES `UserFbs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BetFbs_followers`
--

--LOCK TABLES `BetFbs_followers` WRITE;
/*!40000 ALTER TABLE `BetFbs_followers` DISABLE KEYS */;
/*!40000 ALTER TABLE `BetFbs_followers` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `MatchFbs`
--

DROP TABLE IF EXISTS `MatchFbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MatchFbs` (
  `id` bigint(20) NOT NULL,
  `matchStartDate` varchar(255) DEFAULT NULL,
  `result` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MatchFbs`
--

--LOCK TABLES `MatchFbs` WRITE;
/*!40000 ALTER TABLE `MatchFbs` DISABLE KEYS */;
/*!40000 ALTER TABLE `MatchFbs` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `MessageFbs`
--

DROP TABLE IF EXISTS `MessageFbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MessageFbs` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `author_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  --KEY `FKsyats399tcicnifv0w3w5j4fd` (`author_id`),
  --KEY `FK50rki6b4ise9prk4csoeuqyyt` (`group_id`),
  CONSTRAINT `FK50rki6b4ise9prk4csoeuqyyt` FOREIGN KEY (`group_id`) REFERENCES `GroupFbs` (`id`),
  CONSTRAINT `FKsyats399tcicnifv0w3w5j4fd` FOREIGN KEY (`author_id`) REFERENCES `UserFbs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MessageFbs`
--

--LOCK TABLES `MessageFbs` WRITE;
/*!40000 ALTER TABLE `MessageFbs` DISABLE KEYS */;
INSERT INTO `MessageFbs` VALUES (18,'sdfqs','2020-04-10 12:16:30.883000',16,17),(19,'sdfs','2020-04-10 12:16:37.060000',16,17),(20,'f','2020-04-10 12:16:38.981000',16,17),(21,'f','2020-04-10 12:16:40.423000',16,17),(23,'dfgdsfg','2020-04-21 11:57:41.536000',15,22);
/*!40000 ALTER TABLE `MessageFbs` ENABLE KEYS */;
--UNLOCK TABLES;

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

--
-- Dumping data for table `hibernate_sequence`
--

--LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (24),(24),(24),(24),(24);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
--UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-22 12:44:09
