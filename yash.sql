-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2016 at 01:04 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `yash`
--

-- --------------------------------------------------------

--
-- Table structure for table `custumer`
--

CREATE TABLE IF NOT EXISTS `custumer` (
  `Name` varchar(16) NOT NULL,
  `Id` int(5) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `DOB` date NOT NULL,
  `MobileNO` varchar(15) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `custumer`
--

INSERT INTO `custumer` (`Name`, `Id`, `Email`, `DOB`, `MobileNO`) VALUES
('yash', 1, 'yashwanth@gmail.com', '1991-05-03', '1147483647');

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE IF NOT EXISTS `emp` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `age` int(3) NOT NULL,
  `salary` int(6) NOT NULL,
  `address` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`id`, `name`, `age`, `salary`, `address`) VALUES
(1, 'Anil', 25, 10000, 'Madhapur'),
(2, 'srujan', 26, 8000, 'Ecil'),
(3, 'Rahul', 25, 25000, 'Delhi');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `empno` int(6) NOT NULL,
  `ename` varchar(16) NOT NULL,
  `salary` int(10) NOT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gmailusers`
--

CREATE TABLE IF NOT EXISTS `gmailusers` (
  `firstName` varchar(10) NOT NULL,
  `lastName` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gmailusers`
--

INSERT INTO `gmailusers` (`firstName`, `lastName`, `password`, `email`) VALUES
('yashwanth', 'merugu', 'yash', 'yashwanth@gmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
