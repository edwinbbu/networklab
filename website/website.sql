-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2016 at 02:24 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `website`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `passwrd` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `passwrd`) VALUES
('alan', 'alan123'),
('edwin', 'edwin123');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `username` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `tenth` varchar(10) DEFAULT NULL,
  `tweth` varchar(10) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`username`, `name`, `age`, `email`, `mobile`, `gender`, `address`, `tenth`, `tweth`, `department`) VALUES
('alan', 'Alan George', '21', 'alangp@gmail.com', '8281331981', 'Male', 'Ernakulam', '90', '90', 'CS'),
('edwin', 'Edwin Babu', '21', 'edwinbbu@gmail.com', '7356217081', 'Male', 'Ukken House, Vinpy Nagar, Paravattani\r\nThrissur East', '86', '86', 'CS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
