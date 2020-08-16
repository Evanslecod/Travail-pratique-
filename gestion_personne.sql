-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 06, 2020 at 10:32 AM
-- Server version: 8.0.21-0ubuntu0.20.04.3
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_personne`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_personne` (IN `id_` INT, IN `nom_` VARCHAR(255), IN `postnom_` VARCHAR(255), IN `prenom_` VARCHAR(255), IN `sexe_` VARCHAR(255))  BEGIN
DECLARE code_ INT;
DECLARE numero_ INT;
IF NOT EXISTS(SELECT id FROM personne WHERE nom=nom_ AND postnom=postnom_ AND prenom=prenom_)THEN
		INSERT INTO `personne`(`id`, `nom`, `postnom`, `prenom`, `sexe`)
    	VALUES (id_,nom_,postnom_,prenom_,sexe_);
    ELSE
   	 	UPDATE personne SET nom=nom_, postnom=postnom_, prenom=prenom_, sexe=sexe_ WHERE id=id_;
END IF;    
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_telephone` (IN `nom_` VARCHAR(255), IN `postnom_` VARCHAR(255), IN `prenom_` VARCHAR(255), IN `numero_` VARCHAR(13), IN `initial` VARCHAR(4))  BEGIN
DECLARE person INT;
SET person=(SELECT id FROM personne WHERE nom=nom_ AND postnom=postnom_ AND prenom=prenom_);
IF NOT EXISTS(SELECT numero FROM telephone WHERE numero=numero_)THEN
    INSERT INTO `telephone`(`id_proprietaire`, `initial`, `numero`)
    VALUES (person,initial_,numero_);
END IF;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `adresse`
--

CREATE TABLE `adresse` (
  `id` int NOT NULL,
  `quartier` varchar(50) DEFAULT NULL,
  `commune` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `pays` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `domicile`
--

CREATE TABLE `domicile` (
  `id` int NOT NULL,
  `id_personne` int NOT NULL,
  `id_adresse` int NOT NULL,
  `avenue` varchar(50) DEFAULT NULL,
  `numero_avenue` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

CREATE TABLE `personne` (
  `id` int NOT NULL,
  `nom` varchar(50) NOT NULL,
  `postnom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `sexe` varchar(1) NOT NULL DEFAULT 'M'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `postnom`, `prenom`, `sexe`) VALUES
(1, 'Akili', 'Ciz', 'Akim', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `telephone`
--

CREATE TABLE `telephone` (
  `id` int NOT NULL,
  `id_proprietaire` int NOT NULL,
  `initial` varchar(4) NOT NULL,
  `numero` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `domicile`
--
ALTER TABLE `domicile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_personne_domicile` (`id_personne`),
  ADD KEY `fk_addresse_domicile` (`id_adresse`);

--
-- Indexes for table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uk_personne` (`nom`,`postnom`,`prenom`);

--
-- Indexes for table `telephone`
--
ALTER TABLE `telephone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_personne_telephone` (`id_proprietaire`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `telephone`
--
ALTER TABLE `telephone`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `domicile`
--
ALTER TABLE `domicile`
  ADD CONSTRAINT `fk_addresse_domicile` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `fk_personne_domicile` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Constraints for table `telephone`
--
ALTER TABLE `telephone`
  ADD CONSTRAINT `fk_personne_telephone` FOREIGN KEY (`id_proprietaire`) REFERENCES `personne` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
