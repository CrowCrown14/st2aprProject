-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : dim. 12 mars 2023 à 22:39
-- Version du serveur : 8.0.32
-- Version de PHP : 8.0.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `st2aprProject`
--

-- --------------------------------------------------------

--
-- Structure de la table `Intern`
--

CREATE TABLE `Intern` (
  `internId` int NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `groupe` varchar(10) NOT NULL,
  `cdc` tinyint(1) NOT NULL,
  `ficheVisite` tinyint(1) NOT NULL,
  `ficheEvalEntreprise` tinyint(1) NOT NULL DEFAULT '0',
  `sondageWeb` tinyint(1) NOT NULL,
  `rapportRendu` tinyint(1) NOT NULL,
  `soutenance` tinyint(1) NOT NULL,
  `planifier` tinyint(1) NOT NULL,
  `faite` tinyint(1) NOT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `entreprise` varchar(50) DEFAULT NULL,
  `mdS` varchar(50) DEFAULT NULL,
  `adresse` text,
  `noteTechnique` int DEFAULT NULL,
  `noteCommunication` int DEFAULT NULL,
  `descriptionMission` text,
  `commentaire` text,
  `tutorUsername` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Intern`
--

INSERT INTO `Intern` (`internId`, `nom`, `prenom`, `groupe`, `cdc`, `ficheVisite`, `ficheEvalEntreprise`, `sondageWeb`, `rapportRendu`, `soutenance`, `planifier`, `faite`, `debut`, `fin`, `entreprise`, `mdS`, `adresse`, `noteTechnique`, `noteCommunication`, `descriptionMission`, `commentaire`, `tutorUsername`) VALUES
(1, 'Alex', 'Xu', 'M2', 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test'),
(2, 'Alex', 'Picard', 'M2', 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test'),
(3, 'Koel', 'Theo', 'M2', 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test'),
(4, 'Yoann', 'Losco', 'M2', 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test'),
(5, 'Maxime', 'Fotso', 'M2', 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test');

-- --------------------------------------------------------

--
-- Structure de la table `Tutor`
--

CREATE TABLE `Tutor` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tutorLastName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tutorFirstName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Tutor`
--

INSERT INTO `Tutor` (`username`, `password`, `tutorLastName`, `tutorFirstName`) VALUES
('admin', 'admin', 'admin', 'admin'),
('test', 'test', 'Picard', 'Alex');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Intern`
--
ALTER TABLE `Intern`
  ADD PRIMARY KEY (`internId`),
  ADD KEY `Intern_ibfk_1` (`tutorUsername`);

--
-- Index pour la table `Tutor`
--
ALTER TABLE `Tutor`
  ADD PRIMARY KEY (`username`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Intern`
--
ALTER TABLE `Intern`
  ADD CONSTRAINT `Intern_ibfk_1` FOREIGN KEY (`tutorUsername`) REFERENCES `Tutor` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
