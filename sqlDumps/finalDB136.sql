CREATE DATABASE  IF NOT EXISTS `interrestmap` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `interrestmap`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: interrestmap
-- ------------------------------------------------------
-- Server version	5.6.11-log

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
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `PlaceID` int(11) unsigned NOT NULL,
  `PhotoID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `FilePath` varchar(255) NOT NULL,
  PRIMARY KEY (`PhotoID`),
  KEY `PlaceID` (`PlaceID`),
  CONSTRAINT `photo_ibfk_1` FOREIGN KEY (`PlaceID`) REFERENCES `place` (`PlaceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `place` (
  `PlaceID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `PlaceName` varchar(30) NOT NULL,
  `Rating` int(1) NOT NULL,
  `CoordinateX` varchar(20) NOT NULL,
  `CoordinateY` varchar(20) NOT NULL,
  `Description` varchar(3000) DEFAULT NULL,
  `PlaceType` varchar(10) NOT NULL,
  PRIMARY KEY (`PlaceID`),
  UNIQUE KEY `Name_UNIQUE` (`PlaceName`),
  KEY `UserId` (`UserID`),
  CONSTRAINT `place_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,1,'Pizza!',3,'37.626469','127.07958','Samostatnej byl třídenní výlet do Busanu ještě s Jeremym a Annie. Po příjezdu, kdy bylo první den 17 stupňů, zamračeno a foukalo, jsme konstatovali, že Busan teda neni úplně to plážový party město co jsme si představovali. Další den kdy bylo 27, slunečno a já s Peetem jsme se pěkně připekli na pláží, jsme názor rychle poopravili. Vedle koupání v moři a krásnýho východu slunce na pláži, ze kterýho máme moc pěkný fotky (jen si nějak nejsme jistý kdo a jak je fotil), byla nejlepší poslední noc v Irskym baru, spontánní hromadnej tanec na YMCA a druhej den následná rekonvalescence v Busanejskejch luxusních lázních! Tím jsme náš výlet na jih ukončili a ten noční návrat do Soulu taky nebyl tak strašněj. Bohužel jsme se nestihli podívat do žádnýho národního parku, jak jsme plánovali. Ale výlet na Bukhansan a do Everlandu to snad vynahradil!','RESTAURANT'),(2,1,'Gangnam baby',2,'37.60444','126.965446','Další den kdy bylo 27, slunečno a já s Peetem jsme se pěkně připekli na pláží, jsme názor rychle poopravili. Vedle koupání v moři a krásnýho východu slunce na pláži, ze kterýho máme moc pěkný fotky (jen si nějak nejsme jistý kdo a jak je fotil), byla nejlepší poslední noc v Irskym baru, spontánní hromadnej tanec na YMCA a druhej den následná rekonvalescence v Busanejskejch luxusních lázních! Tím jsme náš výlet na jih ukončili a ten noční návrat do Soulu taky nebyl tak strašněj. Bohužel jsme se nestihli podívat do žádnýho národního parku, jak jsme plánovali. Ale výlet na Bukhansan a do Everlandu to snad vynahradil!','CLUB'),(3,2,'No idea',5,'37.318844','126.777306','Kluci odjížděli před čtyřma dnama a já jsem si říkal, že si konečně dám trochu odpočinek. A stalo se co??? Stal se školní studentskej festival na campsu :D Podél hlavní aleje na kampusu se objevili stánky, kde naše všemožný kluby a školní katedry prezentovaly sebe, svoje výtvory, nebo organizovali soutěže. Přivezli nám dokonce i obrovskou nafukovací skluzavku kombinovanou se skákacím hradem (kam jsem se nestih dostat!). Vrcholem bylo zastavění našeho školního hřistě cca dvaceti obříma stanama a jednim velkym pódiem. Po šestý večer se tu začalo prodávat jídlo a pití, každej stan v duchu svý katedry a na podiu začaly křepčit a tancovat školní kluby a další pozvaní hosté. Čtvrtečním vrcholem večera bylo vystoupení Orange Caramel, což je typický k-pop dívčí trio. V pátek to byli naopak Dynamic duo, což jsou dva rappeři. Poprvé jsem na vlastní oči viděl jak korejci začnou šílet když vidí naživo ty svoje idoly. Holky ječej ve čtvrtejch oktávách a kluci si lezou na ramena aby si natočili co nejlepší video na svoje smartfouny. A pak tu bylo spoustu potkávání kamarádů, tancování a Soju :) Naše kampusová banda (Miika, Rachel, Kay, Gizem a JÁ) si tohle užila naprosto do vrchovatě!','OUTDOOR'),(4,2,'Tree',3,'37.498287','126.971626','Podél hlavní aleje na kampusu se objevili stánky, kde naše všemožný kluby a školní katedry prezentovaly sebe, svoje výtvory, nebo organizovali soutěže. Přivezli nám dokonce i obrovskou nafukovací skluzavku kombinovanou se skákacím hradem (kam jsem se nestih dostat!). Vrcholem bylo zastavění našeho školního hřistě cca dvaceti obříma stanama a jednim velkym pódiem. Po šestý večer se tu začalo prodávat jídlo a pití, každej stan v duchu svý katedry a na podiu začaly křepčit a tancovat školní kluby a další pozvaní hosté. Čtvrtečním vrcholem večera bylo vystoupení Orange Caramel, což je typický k-pop dívčí trio. V pátek to byli naopak Dynamic duo, což jsou dva rappeři. Poprvé jsem na vlastní oči viděl jak korejci začnou šílet když vidí naživo ty svoje idoly. Holky ječej ve čtvrtejch oktávách a kluci si lezou na ramena aby si natočili co nejlepší video na svoje smartfouny. A pak tu bylo spoustu potkávání kamarádů, tancování a Soju :) Naše kampusová banda (Miika, Rachel, Kay, Gizem a JÁ) si tohle užila naprosto do vrchovatě!','OUTDOOR'),(5,1,'Noodles',3,'37.60444','126.965446','A to byl na nějakou dobu asi poslední takovej větší mejdan. Do konce semestru zbývají 4 tejdny a začínají se pěkně štosovat všechny ty projekty a testy. Dneska ještě vyrážíme na jednu sightseeing tour po Soulu, abysme si doplnili turistický resty a od pondělka pěkně hurá do toho. Ale musim říct, že si to tu užívám pořád víc a víc, takže se na ten poslední kus semestru přece jen těšim. Jen ty 4 tejdny asi utečou už ošklivě rychle a já budu muset balit… No co se dá dělat, už se dá jen si ten zbytek pořádně užít! ;)','RESTAURANT'),(6,2,'Ellui',4,'37.510339','127.032132','옥타곤은 강남 뉴힐탑호텔에 위치한 대한민국 최대규모의 클럽으로 대한민국 최초로 서라운드 사운드 시스템인 펑션원 댄스스텍 버젼 넘버포를 장착한 최고시설을 갖추고 있다. ','CLUB'),(7,2,'Naruto',4,'37.628899','127.076622','Weeeeell not bad place ... Gizem likes it, so why the hell not :)','PUB'),(9,2,'National Park',1,'37.658819','126.981926','Awful place! Stay away, really!','PARK'),(10,1,'Monkey Beach',3,'37.507002','127.007332','Not bad, bit cheaper for Gangnam, WAY too crowded. Overall worth to stop for a while. Oh yea and its free!!! ;)','CLUB'),(11,1,'Fottbal filed',2,'37.641762','127.049146','AWESOMEEEEEEE! great, cool, thrilling, I just love it!','OUTDOOR'),(12,2,'Dongtanbanseong',5,'37.199706','127.070389','Evidently this is some street. For some people ot might be just some street... but for me. For me its nothing else aswell :) I have never been there so well like WTF I care???','OTHER');
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Name_UNIQUE` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'petr'),(2,'sungbo');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-13 13:06:19
