-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 21, 2017 at 03:51 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oe_java_peterlilli`
--

-- --------------------------------------------------------

--
-- Table structure for table `castingok`
--

CREATE TABLE `castingok` (
  `id` int(11) NOT NULL,
  `datum_start` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datum_veg` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ferohely` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  `helyszin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idopont_start` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idopont_veg` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `leiras` longtext COLLATE utf8_unicode_ci NOT NULL,
  `nev` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `filmek`
--

CREATE TABLE `filmek` (
  `id` int(11) NOT NULL,
  `cim` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `leiras` longtext COLLATE utf8_unicode_ci NOT NULL,
  `mufaj_id` int(11) NOT NULL,
  `rendezo` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mufajok`
--

CREATE TABLE `mufajok` (
  `id` int(11) NOT NULL,
  `nev` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `szereplok`
--

CREATE TABLE `szereplok` (
  `id` int(11) NOT NULL,
  `eletkor` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  `jellem` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `leiras` longtext COLLATE utf8_unicode_ci NOT NULL,
  `nem` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nev` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `castingok`
--
ALTER TABLE `castingok`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `filmek`
--
ALTER TABLE `filmek`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mufajok`
--
ALTER TABLE `mufajok`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `szereplok`
--
ALTER TABLE `szereplok`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `castingok`
--
ALTER TABLE `castingok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `filmek`
--
ALTER TABLE `filmek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mufajok`
--
ALTER TABLE `mufajok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `szereplok`
--
ALTER TABLE `szereplok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
