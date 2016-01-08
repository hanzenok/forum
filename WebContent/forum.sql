-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 08, 2016 at 06:51 PM
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
  `title` varchar(32) NOT NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `conversations`
--

INSERT INTO `conversations` (`id`, `author`, `title`, `creation_date`) VALUES
(1, 'Sara', 'Talking about stuff', '2016-01-04 00:00:00'),
(2, 'Test21', 'A test', '2016-01-04 03:00:00'),
(3, 'Sara', 'New Conversation', '2016-01-04 17:27:31'),
(4, 'Sara', '', '2016-01-04 17:32:33'),
(5, 'Sara', 'fdf', '2016-01-05 11:20:42'),
(6, 'Yomen', 'Yo', '2016-01-06 23:23:18'),
(7, 'Sara', 'as', '2016-01-08 01:02:23'),
(8, 'Sara', 'as', '2016-01-08 01:02:23'),
(9, 'Sara', 'new', '2016-01-08 01:05:19'),
(10, 'Sara', 'nouvelle conversation', '2016-01-08 14:39:40');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `id_conversation`, `number`, `author`, `date`, `text`) VALUES
(1, 1, 1, 'Sara', '2016-01-04 00:00:01', 'Hi everyone! Can we talk about stuff?'),
(2, 2, 1, 'Sara', '2016-01-05 00:00:00', 'What''s all about thouse tests?'),
(3, 1, 2, 'Sara', '2016-01-07 11:21:29', 'dfg'),
(4, 1, 3, 'Sara', '2016-01-07 11:23:40', 'sdf'),
(5, 1, 4, 'Sara', '2016-01-07 11:23:53', 'fds'),
(6, 1, 5, 'Sara', '2016-01-07 11:29:45', 'sdf'),
(7, 1, 6, 'Sara', '2016-01-07 11:34:33', 'sdf'),
(8, 1, 7, 'Sara', '2016-01-07 11:36:01', 'yo'),
(9, 1, 8, 'Sara', '2016-01-07 11:55:38', 'sdf'),
(10, 1, 9, 'Sara', '2016-01-07 11:56:29', 'sdfsd'),
(11, 1, 10, 'Sara', '2016-01-07 11:56:59', 'sdf'),
(12, 1, 11, 'Sara', '2016-01-07 12:10:31', 'fdsf'),
(13, 1, 12, 'Sara', '2016-01-07 12:12:16', 'new comment'),
(14, 1, 13, 'Sara', '2016-01-07 12:13:27', 'another new comment'),
(15, 1, 13, 'Sara', '2016-01-07 12:13:45', 'another new comment'),
(16, 1, 15, 'Sara', '2016-01-07 12:18:29', 'and another one'),
(17, 1, 16, 'Sara', '2016-01-07 12:26:55', 'dfdf'),
(18, 1, 17, 'Sara', '2016-01-07 12:27:52', 'we'),
(19, 1, 18, 'Sara', '2016-01-07 12:28:01', 'we'),
(20, 2, 2, 'Sara', '2016-01-07 12:28:19', 'fdf'),
(21, 2, 3, 'Sara', '2016-01-07 12:29:14', 'f'),
(22, 2, 4, 'Sara', '2016-01-07 12:30:45', 'kgk'),
(23, 2, 5, 'Sara', '2016-01-07 14:09:56', 'yo'),
(24, 2, 6, 'Sara', '2016-01-07 15:20:56', 'What the fuck do you want from me?'),
(25, 2, 7, 'Test21', '2016-01-07 15:21:32', 'Nothing beach'),
(26, 2, 8, 'Test21', '2016-01-07 15:22:41', 'ertwergsdfgsdfgsdfgsdfgsdfgsdfgsdfgsdfgsdfgsdfgsdfg'),
(28, 2, 9, 'Sara', '2016-01-07 16:49:00', 'sdfsdf'),
(29, 2, 10, 'Sara', '2016-01-07 17:18:44', 'sdf'),
(30, 2, 11, 'Sara', '2016-01-07 17:42:22', 'fdfdfdf'),
(31, 2, 12, 'Sara', '2016-01-07 22:42:41', 'jsdf;lksjdf;aklsjdf;laksjdf;laksjdf;laksdjf;laksdjf;alksjdf;laksjdf;lkasjd;flkajs;dlfkja;sldkfj;alskdjf;laksdjf;alksdjf;laksjdf;'),
(32, 5, 1, 'Sara', '2016-01-07 23:27:31', 'oui,salut'),
(33, 2, 13, 'newme', '2016-01-08 01:03:37', 'what''s up?'),
(34, 2, 14, 'Test21', '2016-01-08 12:12:47', 'yo\r\n'),
(35, 2, 15, 'Sara', '2016-01-08 14:21:28', 'sdf'),
(36, 2, 16, 'Sara', '2016-01-08 14:40:10', 'you oy ou '),
(37, 2, 17, 'myself', '2016-01-08 14:42:10', 'the fuck?'),
(38, 2, 18, 'Sara', '2016-01-08 14:55:02', 'yo');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=38 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `login`, `pass`, `firstname`, `secondname`) VALUES
(35, 'Sara', 'j K?<H|qz	z', '', ''),
(36, 'Yomen', 'j K?<H|qz	z', '', ''),
(37, 'dhgd', 'MKN', 'qq', 'qq');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
