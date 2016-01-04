-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 04, 2016 at 12:37 PM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `forum`
--

-- --------------------------------------------------------

--
-- Table structure for table `conversations`
--

CREATE TABLE IF NOT EXISTS `conversations` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `author` varchar(32) NOT NULL,
  `title` varchar(128) NOT NULL,
  `creation_date` datetime NOT NULL,
  `modification_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `conversations`
--

INSERT INTO `conversations` (`id`, `author`, `title`, `creation_date`, `modification_date`) VALUES
(1, 'Sara', 'Talking about stuff', '2016-01-04 00:00:00', '2016-01-04 00:00:00'),
(2, 'Test21', 'A test', '2016-01-04 03:00:00', '2016-01-04 03:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `id_conversation` int(8) NOT NULL,
  `number` int(11) NOT NULL,
  `author` varchar(32) NOT NULL,
  `date` datetime NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `id_conversation`, `number`, `author`, `date`, `text`) VALUES
(1, 1, 1, 'Sara', '2016-01-04 00:00:01', 'Hi everyone! Can we talk about stuff?');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `login` varchar(32) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `firstname` varchar(32) NOT NULL,
  `secondname` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `login`, `pass`, `firstname`, `secondname`) VALUES
(1, 'test', 'test', 'test', 'test'),
(2, 'test2', 'test', 'test', 'test'),
(3, 'aaaaasdfasdfasdf', 'fdfdfff', 'fdf', 'ffffff'),
(5, 'sfsd', 'asdfasdf', '', ''),
(6, 'Sara', 'asdfasdf', '', ''),
(7, 'Sara2', 'asdfasdf', '', ''),
(9, 'fsddds', 'sdfsdf', 'fffd', 'ff'),
(10, 'fsdddsd', 'aaaaaa', 'fffd', 'ff'),
(11, 'TEst32', 'fdfdfd', 'fffd', 'ff'),
(13, 'Test22', 'asdfasdf', 'fffd', 'ff'),
(14, 'Test21', 'asdfasdf', 'fffd', 'ff'),
(15, 'Testsdf', 'asdfasdf', 'fffd', 'ff'),
(16, 'ffTestsdf', 'asdfasdf', 'fffd', 'ff'),
(17, 'ffTestsdfffdf', 'asdfasdf', 'fffd', 'ff'),
(18, 'ffdfdffddf', 'asdfasdf', 'fffd', 'ff'),
(21, 'ffddf', 'asdfasdf', 'fffd', 'ff'),
(22, 'ffddfa', 'asdfasdf', 'fffd', 'ff'),
(23, '1234', '12341234', 'fffd', 'ff'),
(24, '12345', 'asdfasdf', 'fffd', 'ff'),
(25, '123456', 'asdfasdf', 'fffd', 'ff'),
(26, '1234567', 'Ð²Ð°Ð²Ð°Ð²Ð°Ð²Ð°', 'fffd', 'ff');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
