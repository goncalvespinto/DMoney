-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Lun 01 Mars 2021 à 13:10
-- Version du serveur: 5.1.49
-- Version de PHP: 5.3.3-7+squeeze14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `camilleExp2`
--

-- --------------------------------------------------------

--
-- Structure de la table `DATA`
--

CREATE TABLE IF NOT EXISTS `DATA` (
  `SESSION` int(10) DEFAULT NULL,
  `IDGROUP` int(10) DEFAULT NULL,
  `IDPARTICIPANT` int(10) DEFAULT NULL,
  `Periode` int(10) DEFAULT NULL,
  `Beta` float DEFAULT NULL,
  `Alpha` float DEFAULT NULL,
  `Input` int(10) DEFAULT NULL,
  `Money` int(10) DEFAULT NULL,
  `Credit` int(10) DEFAULT NULL,
  `DECISION1` float DEFAULT NULL,
  `DECISION2` float DEFAULT NULL,
  `DECISION3` float DEFAULT NULL,
  `Proportionconsommationbien2` float DEFAULT NULL,
  `Prixinput` float DEFAULT NULL,
  `Interestrate` float DEFAULT NULL,
  `fi` float DEFAULT NULL,
  `gi1` float DEFAULT NULL,
  `gi2` float DEFAULT NULL,
  `Prixbien1` float DEFAULT NULL,
  `Prixbien2` float DEFAULT NULL,
  `Produitmarginalbien1` float DEFAULT NULL,
  `Produitmarginalbien2` float DEFAULT NULL,
  `Money1` float DEFAULT NULL,
  `Money2` float DEFAULT NULL,
  `Gain1` float DEFAULT NULL,
  `Gain2` float DEFAULT NULL,
  `ci1` float DEFAULT NULL,
  `ci2` float DEFAULT NULL,
  `Prixrelatif` float DEFAULT NULL,
  `Gainmarginalrelatifconsommation` float DEFAULT NULL,
  `Gain3` float DEFAULT NULL,
  `Gainperiode` float DEFAULT NULL,
  `Gaincumulé` float DEFAULT NULL,
  `GAIN1ETGAIN2` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `DATA`
--

-- --------------------------------------------------------

--
-- Structure de la table `PARTICIPANT`
--

CREATE TABLE IF NOT EXISTS `PARTICIPANT` (
  `COMPUTER` varchar(15) DEFAULT NULL,
  `START` varchar(20) DEFAULT NULL,
  `END` varchar(20) DEFAULT NULL,
  `SESSION` int(3) DEFAULT NULL,
  `TEST` int(1) DEFAULT NULL,
  `GAINFINAL` float DEFAULT NULL,
  `IDPARTICIPANT` int(10) NOT NULL AUTO_INCREMENT,
  `IDGROUP` int(10) DEFAULT NULL,
  PRIMARY KEY (`IDPARTICIPANT`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=106 ;

--
-- Contenu de la table `PARTICIPANT`
--


-- --------------------------------------------------------

--
-- Structure de la table `QUESTIONNAIRE`
--

CREATE TABLE IF NOT EXISTS `QUESTIONNAIRE` (
  `IDPARTICIPANT` int(10) NOT NULL,
  `Quest1` int(10) DEFAULT NULL,
  `Quest2` int(10) DEFAULT NULL,
  `Quest3` int(10) DEFAULT NULL,
  `Quest4` int(10) DEFAULT NULL,
  `Quest5` int(10) DEFAULT NULL,
  `Quest6` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `QUESTIONNAIRE`
--
