-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3307
-- Generation Time: 2016-04-21 15:10:23
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `atm`
--

-- --------------------------------------------------------

--
-- 表的结构 `admininfo`
--

CREATE TABLE IF NOT EXISTS `admininfo` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `adminType` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `admininfo`
--

INSERT INTO `admininfo` (`adminId`, `adminName`, `password`, `adminType`) VALUES
(1, '1', '1', 0),
(2, '2', '2', 1),
(3, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- 表的结构 `card`
--

CREATE TABLE IF NOT EXISTS `card` (
  `cardId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `password` varchar(6) NOT NULL,
  `frozen` int(1) NOT NULL DEFAULT '0',
  `loss` int(1) NOT NULL DEFAULT '0',
  `cash` decimal(30,3) NOT NULL DEFAULT '0.000',
  `closed` int(1) NOT NULL DEFAULT '0',
  `openDate` datetime NOT NULL,
  `cardNum` varchar(20) NOT NULL,
  PRIMARY KEY (`cardId`),
  KEY `FK_Reference_Card_UserInfo_CustomerID` (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- 转存表中的数据 `card`
--

INSERT INTO `card` (`cardId`, `userId`, `password`, `frozen`, `loss`, `cash`, `closed`, `openDate`, `cardNum`) VALUES
(1, 1, '123456', 0, 0, '397.000', 0, '2015-10-02 07:04:03', '10000000001'),
(2, 2, '123456', 0, 0, '2351.700', 1, '2016-03-31 15:33:54', '10000000002'),
(9, 1, '123456', 0, 0, '900.000', 0, '2016-04-13 01:43:04', '10000000003'),
(10, 1, '123456', 0, 0, '5000.000', 0, '2016-04-13 01:43:04', '10000000004'),
(11, 1, '123456', 0, 0, '10000.000', 0, '2016-04-13 01:45:50', '10000000005'),
(12, 2, '123456', 0, 0, '1000.000', 0, '2016-04-13 01:45:50', '10000000006'),
(13, 18, '123456', 0, 0, '5000.000', 0, '2016-04-13 15:07:17', '10000000007'),
(14, 18, '123456', 0, 0, '1000.000', 0, '2016-04-13 15:11:21', '10000000008'),
(15, 19, '123456', 0, 0, '0.000', 0, '2016-04-15 20:40:58', '10000000009'),
(16, 24, '123456', 0, 0, '0.000', 0, '2016-04-19 21:05:31', '10000000010'),
(17, 24, '123456', 0, 0, '0.000', 0, '2016-04-19 21:05:31', '10000000011'),
(18, 24, '123456', 0, 1, '0.000', 1, '2016-04-19 21:05:31', '10000000012'),
(19, 25, '123456', 0, 0, '0.000', 0, '2016-04-20 23:39:06', '10000000014');

-- --------------------------------------------------------

--
-- 表的结构 `cardnum`
--

CREATE TABLE IF NOT EXISTS `cardnum` (
  `maxNum` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `cardnum`
--

INSERT INTO `cardnum` (`maxNum`) VALUES
('10000000014');

-- --------------------------------------------------------

--
-- 表的结构 `tradeinfo`
--

CREATE TABLE IF NOT EXISTS `tradeinfo` (
  `tradeId` int(11) NOT NULL AUTO_INCREMENT,
  `cardId` int(11) NOT NULL,
  `tradeDate` datetime NOT NULL,
  `tradeType` int(11) NOT NULL,
  `tradeMoney` decimal(30,3) DEFAULT NULL,
  `target` int(11) DEFAULT NULL,
  PRIMARY KEY (`tradeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=59 ;

--
-- 转存表中的数据 `tradeinfo`
--

INSERT INTO `tradeinfo` (`tradeId`, `cardId`, `tradeDate`, `tradeType`, `tradeMoney`, `target`) VALUES
(2, 1, '2016-01-09 20:49:23', 2, '1.000', 2),
(3, 1, '2016-03-31 20:58:33', 2, '1.000', 2),
(4, 1, '2016-03-31 23:20:47', 1, '100.000', -1),
(5, 1, '2016-03-31 23:46:50', 0, '100.000', -1),
(6, 1, '2016-03-31 23:56:24', 1, '12.000', -1),
(7, 2, '2016-04-01 00:13:59', 0, '123.000', -1),
(8, 2, '2016-04-01 00:13:59', 2, '1.000', 1),
(9, 2, '2016-04-01 00:35:07', 1, '20.000', -1),
(10, 2, '2016-04-01 00:35:07', 1, '100.000', -1),
(11, 1, '2016-04-01 00:44:59', 1, '1.000', -1),
(12, 1, '2016-04-01 00:55:38', 0, '1.000', -1),
(13, 1, '2016-04-01 00:57:00', 1, '100.000', -1),
(14, 1, '2016-04-01 19:07:24', 1, '100.000', -1),
(15, 1, '2016-04-01 19:16:13', 1, '100.000', -1),
(16, 1, '2016-04-01 19:16:13', 1, '100.000', -1),
(17, 1, '2016-04-01 19:41:23', 1, '100.000', -1),
(18, 1, '2016-04-01 19:41:23', 1, '500.000', -1),
(19, 1, '2016-04-01 20:48:46', 1, '1000.000', -1),
(20, 1, '2016-04-01 21:10:08', 1, '100.000', -1),
(21, 1, '2016-04-01 23:51:49', 0, '100.000', -1),
(22, 1, '2016-04-01 23:56:20', 2, '222.000', 2),
(23, 1, '2016-04-02 00:09:00', 2, '10.000', 2),
(24, 1, '2016-04-08 20:50:46', 1, '1000.000', -1),
(25, 1, '2016-04-08 20:54:46', 1, '300.000', -1),
(26, 1, '2016-04-08 20:58:35', 0, '1000.000', -1),
(27, 1, '2016-04-09 00:08:20', 0, '500.000', -1),
(28, 1, '2016-04-09 00:08:57', 0, '500.000', -1),
(29, 1, '2016-04-09 12:21:43', 2, '1.200', 2),
(30, 1, '2016-04-09 12:33:04', 0, '1000.000', -1),
(31, 1, '2016-04-13 01:49:25', 1, '100.000', -1),
(32, 1, '2016-04-13 01:49:25', 1, '100.000', -1),
(33, 9, '2016-04-13 01:52:12', 0, '1000.000', -1),
(34, 9, '2016-04-13 01:52:12', 1, '100.000', -1),
(35, 1, '2016-04-13 20:54:00', 1, '300.000', -1),
(36, 1, '2016-04-13 20:54:00', 2, '1.500', 2),
(37, 1, '2016-04-13 20:55:43', 2, '1.000', 2),
(38, 1, '2016-04-13 20:55:43', 1, '100.000', -1),
(39, 1, '2016-04-15 00:40:22', 2, '1000.000', 14),
(40, 1, '2016-04-15 17:15:26', 1, '100.000', -1),
(41, 1, '2016-04-15 17:16:17', 0, '500.000', -1),
(42, 1, '2016-04-15 18:14:12', 0, '100.000', -1),
(43, 1, '2016-04-15 18:14:34', 0, '1000.000', -1),
(44, 1, '2016-04-15 18:14:37', 0, '500.000', -1),
(45, 1, '2016-04-15 18:14:40', 0, '5000.000', -1),
(46, 1, '2016-04-15 18:14:43', 0, '3000.000', -1),
(47, 1, '2016-04-15 18:14:46', 0, '10000.000', -1),
(48, 1, '2016-04-15 18:15:39', 0, '300.000', -1),
(49, 1, '2016-04-15 18:52:23', 2, '5050.000', 10),
(50, 1, '2016-04-15 20:00:18', 1, '1000.000', -1),
(51, 1, '2016-04-15 20:05:51', 1, '100.000', -1),
(52, 1, '2016-04-15 20:37:21', 1, '600.000', -1),
(53, 1, '2016-04-15 20:37:31', 1, '500.000', -1),
(54, 1, '2016-04-19 00:10:09', 0, '100.000', -1),
(55, 1, '2016-04-19 00:46:47', 0, '3200.000', -1),
(56, 1, '2016-04-19 01:34:00', 2, '3.000', 2),
(57, 1, '2016-04-20 22:50:12', 1, '500.000', -1),
(58, 1, '2016-04-20 22:51:19', 1, '100.000', -1);

-- --------------------------------------------------------

--
-- 表的结构 `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `personID` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `address` text,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- 转存表中的数据 `userinfo`
--

INSERT INTO `userinfo` (`userId`, `userName`, `personID`, `phone`, `sex`, `address`) VALUES
(1, '诓兵', '1', '18311188888', '女', '广东财经小学'),
(2, '柯南', '445222190401248210', '15132006453', '男', '广东财经小学'),
(15, 'hzy', '123123', NULL, '男', '123123'),
(18, '服部平次', '445210190400243212', '18311188888', '男', '123123'),
(19, '服部平次', '13245', '5453453', '男', '123123'),
(20, '服部平次', '472173912', '18311188888', '男', '123123'),
(21, '你好', '123123', '213', '男', '广东财经小学'),
(22, '服部平次', '1002', '18311188888', '男', 'huiyadsad'),
(23, '服部平次', '44011222112', '18311188888', '女', '广东财经小学'),
(24, '张三4', '445222199123243001', '18316000123', '男', '广东省揭阳市派出所233'),
(25, '23', '21321', '3213123', '男', '嘎嘎嘎嘎嘎');

--
-- 限制导出的表
--

--
-- 限制表 `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `FK_Reference_Card_UserInfo_CustomerID` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
