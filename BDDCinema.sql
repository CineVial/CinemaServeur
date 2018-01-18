-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mer 30 Novembre 2011 à 19:32
-- Version du serveur: 5.5.8
-- Version de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: 'cinema'
--

-- --------------------------------------------------------

--
-- Structure de la table 'acteur'
--

CREATE TABLE IF NOT EXISTS acteur (
  no_act int(4) NOT NULL AUTO_INCREMENT,
  nom_act varchar(20) NOT NULL,
  pren_act varchar(20) DEFAULT NULL,
  date_naiss date DEFAULT NULL,
  date_deces date DEFAULT NULL,
  PRIMARY KEY (no_act)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table 'acteur'
--

INSERT INTO acteur (no_act, nom_act, pren_act, date_naiss, date_deces) VALUES
(1, 'Reno', 'Jean', '1948-07-30', NULL),
(5, 'Portman', 'Natalie', '1981-06-09', NULL),
(7, 'Dujardin', 'Jean', '1972-06-19', NULL),
(8, 'Bourvil', '', '1917-07-27', '1970-09-23'),
(12, 'De Funes', 'Louis', '1914-07-31', '1983-01-27'),
(13, 'Anglade', 'Jean-Hugues', '1955-07-29', NULL),
(15, 'Lambert', 'Christophe', '1957-03-29', NULL);

-- --------------------------------------------------------

--
-- Structure de la table 'categorie'
--

CREATE TABLE IF NOT EXISTS categorie (
  code_cat varchar(2) NOT NULL,
  libelle_cat varchar(20) NOT NULL,
  PRIMARY KEY (code_cat)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table 'categorie'
--

INSERT INTO categorie (code_cat, libelle_cat) VALUES
('AC', 'Action'),
('CO', 'Comédie'),
('PO', 'Policier'),
('WE', 'Western');

-- --------------------------------------------------------

--
-- Structure de la table 'film'
--

CREATE TABLE IF NOT EXISTS film (
  no_film int(4) NOT NULL AUTO_INCREMENT,
  titre varchar(30) NOT NULL,
  duree int(3) NOT NULL,
  date_sortie date NOT NULL,
  budget int(8) NOT NULL,
  montant_recette int(8) NOT NULL,
  no_rea int(2) NOT NULL,
  code_cat varchar(2) NOT NULL,
  PRIMARY KEY (no_film),
  KEY no_rea (no_rea),
  KEY code_cat (code_cat)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table 'film'
--

INSERT INTO film (no_film, titre, duree, date_sortie, budget, montant_recette, no_rea, code_cat) VALUES
(1, 'Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO'),
(2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO'),
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC'),
(4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO');

-- --------------------------------------------------------

--
-- Structure de la table 'personnage'
--

CREATE TABLE IF NOT EXISTS personnage (
  no_film int(4) NOT NULL,
  no_act int(4) NOT NULL,
  nom_pers varchar(30) NOT NULL,
  PRIMARY KEY (no_film,no_act),
  KEY no_film (no_film),
  KEY no_act (no_act)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table 'personnage'
--

INSERT INTO personnage (no_film, no_act, nom_pers) VALUES
(1, 1, 'Léon'),
(1, 5, 'Mathilda'),
(2, 1, 'Maxime Dubreuil'),
(2, 7, 'Cash'),
(3, 8, 'Augustin Bouvet'),
(3, 12, 'Stanislas Lefort'),
(4, 1, 'Le Batteur'),
(4, 13, 'Le Roller'),
(4, 15, 'Fred');

-- --------------------------------------------------------

--
-- Structure de la table 'realisateur'
--

CREATE TABLE IF NOT EXISTS realisateur (
  no_rea int(2) NOT NULL AUTO_INCREMENT,
  nom_rea varchar(20) NOT NULL,
  pren_rea varchar(20) NOT NULL,
  PRIMARY KEY (no_rea)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table 'realisateur'
--

INSERT INTO realisateur (no_rea, nom_rea, pren_rea) VALUES
(1, 'Oury', 'Gérard'),
(2, 'Chabrol', 'Claude'),
(3, 'Besson', 'Luc'),
(4, 'Besnard', 'Eric');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT film_ibfk_1 FOREIGN KEY (no_rea) REFERENCES realisateur (no_rea),
  ADD CONSTRAINT film_ibfk_2 FOREIGN KEY (code_cat) REFERENCES categorie (code_cat);

--
-- Contraintes pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD CONSTRAINT personnage_ibfk_1 FOREIGN KEY (no_film) REFERENCES film (no_film),
  ADD CONSTRAINT personnage_ibfk_2 FOREIGN KEY (no_act) REFERENCES acteur (no_act);