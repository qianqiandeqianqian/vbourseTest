/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : vbourse

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-03-01 17:32:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fic_coinzc`
-- ----------------------------
DROP TABLE IF EXISTS `fic_coinzc`;
CREATE TABLE `fic_coinzc` (
  `zcid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `showname` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `num` decimal(20,8) DEFAULT NULL,
  `fee` decimal(20,8) DEFAULT NULL,
  `mum` decimal(20,8) DEFAULT NULL,
  `transhash` varchar(100) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `audittime` datetime DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `dtime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `sign` varchar(100) DEFAULT NULL,
  `filepath` varchar(100) DEFAULT NULL,
  `remark` text,
  `isdeleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`zcid`),
  KEY `FK_Reference_18` (`userid`),
  KEY `FK_Reference_19` (`accountid`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`accountid`) REFERENCES `sys_account` (`accountid`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fic_coinzc
-- ----------------------------

-- ----------------------------
-- Table structure for `fic_coinzr`
-- ----------------------------
DROP TABLE IF EXISTS `fic_coinzr`;
CREATE TABLE `fic_coinzr` (
  `zrid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `showname` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `num` decimal(20,8) DEFAULT NULL,
  `fee` decimal(20,8) DEFAULT NULL,
  `mum` decimal(20,8) DEFAULT NULL,
  `transhash` varchar(100) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `audittime` datetime DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `dtime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `sign` varchar(100) DEFAULT NULL,
  `filepath` varchar(100) DEFAULT NULL,
  `remark` text,
  `isdeleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`zrid`),
  KEY `FK_Reference_16` (`userid`),
  KEY `FK_Reference_17` (`accountid`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`accountid`) REFERENCES `sys_account` (`accountid`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fic_coinzr
-- ----------------------------

-- ----------------------------
-- Table structure for `finc_finance`
-- ----------------------------
DROP TABLE IF EXISTS `finc_finance`;
CREATE TABLE `finc_finance` (
  `fcid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `transname` varchar(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `d_coincode` varchar(10) DEFAULT NULL,
  `dbnum` decimal(20,8) DEFAULT NULL,
  `dbnumd` decimal(20,8) DEFAULT NULL,
  `dbtotal` decimal(20,8) DEFAULT NULL,
  `danum` decimal(20,8) DEFAULT NULL,
  `danumd` decimal(20,8) DEFAULT NULL,
  `datotal` decimal(20,8) DEFAULT NULL,
  `dnum` decimal(20,8) DEFAULT NULL,
  `fee_coincode` varchar(10) DEFAULT NULL,
  `fbnum` decimal(20,8) DEFAULT NULL,
  `fbnumd` decimal(20,8) DEFAULT NULL,
  `fbtotal` decimal(20,8) DEFAULT NULL,
  `fanum` decimal(20,8) DEFAULT NULL,
  `fanumd` decimal(20,8) DEFAULT NULL,
  `fatotal` decimal(20,8) DEFAULT NULL,
  `fnum` decimal(20,8) DEFAULT NULL,
  `trans_coincode` varchar(10) DEFAULT NULL,
  `tbnum` decimal(20,8) DEFAULT NULL,
  `tbnumd` decimal(20,8) DEFAULT NULL,
  `tbtotal` decimal(20,8) DEFAULT NULL,
  `tanum` decimal(20,8) DEFAULT NULL,
  `tanumd` decimal(20,8) DEFAULT NULL,
  `tatotal` decimal(20,8) DEFAULT NULL,
  `tnum` decimal(20,8) DEFAULT NULL,
  `systime` datetime DEFAULT NULL,
  `sign` varchar(200) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`fcid`),
  KEY `FK_Reference_10` (`fee_coincode`),
  KEY `FK_Reference_7` (`d_coincode`),
  KEY `FK_Reference_8` (`trans_coincode`),
  KEY `FK_Reference_9` (`userid`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`fee_coincode`) REFERENCES `sys_coin` (`coincode`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`d_coincode`) REFERENCES `sys_coin` (`coincode`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`trans_coincode`) REFERENCES `sys_coin` (`coincode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录用户流水明细表';

-- ----------------------------
-- Records of finc_finance
-- ----------------------------

-- ----------------------------
-- Table structure for `finc_rmbcz`
-- ----------------------------
DROP TABLE IF EXISTS `finc_rmbcz`;
CREATE TABLE `finc_rmbcz` (
  `rcid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `num` decimal(20,8) DEFAULT NULL,
  `mum` decimal(20,8) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `aname` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `systime` datetime DEFAULT NULL,
  `dtime` datetime DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  `audittime` datetime DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `quetime` datetime DEFAULT NULL,
  `quetype` varchar(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `remark` text,
  `sign` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`rcid`),
  KEY `FK_Reference_12` (`userid`),
  KEY `FK_Reference_13` (`accountid`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`accountid`) REFERENCES `sys_account` (`accountid`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人民币充值明细表';

-- ----------------------------
-- Records of finc_rmbcz
-- ----------------------------

-- ----------------------------
-- Table structure for `finc_rmbtx`
-- ----------------------------
DROP TABLE IF EXISTS `finc_rmbtx`;
CREATE TABLE `finc_rmbtx` (
  `rtid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `num` decimal(6,2) DEFAULT NULL,
  `fee` decimal(6,2) DEFAULT NULL,
  `mum` decimal(6,2) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `bank` varchar(10) DEFAULT NULL,
  `bankcard` varchar(30) DEFAULT NULL,
  `bankaddr` varchar(20) DEFAULT NULL,
  `bankcity` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `audittime` datetime DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `filepath` varchar(100) DEFAULT NULL,
  `sign` varchar(200) DEFAULT NULL,
  `isdeleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`rtid`),
  KEY `FK_Reference_14` (`accountid`),
  KEY `FK_Reference_15` (`userid`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`accountid`) REFERENCES `sys_account` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人民币提现';

-- ----------------------------
-- Records of finc_rmbtx
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_account`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `accountid` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `lgcount` int(11) DEFAULT NULL,
  `ercount` int(11) DEFAULT NULL,
  `ertext` varchar(100) DEFAULT NULL,
  `remark` text,
  `isdeleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理系统后台表';

-- ----------------------------
-- Records of sys_account
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_coin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_coin`;
CREATE TABLE `sys_coin` (
  `cid` int(11) DEFAULT NULL,
  `usname` varchar(50) DEFAULT NULL,
  `enname` varchar(50) DEFAULT NULL,
  `coincode` varchar(10) NOT NULL,
  `img` varchar(200) DEFAULT NULL,
  `sort` varchar(5) DEFAULT NULL,
  `ontime` datetime DEFAULT NULL,
  `offtime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `mainaddr` varchar(100) DEFAULT NULL,
  `isvirtual` int(1) DEFAULT NULL,
  `wallettype` varchar(10) DEFAULT NULL,
  `zrstatus` int(1) DEFAULT NULL,
  `zrtype` int(1) DEFAULT NULL,
  `zrfeeratio` decimal(10,2) DEFAULT NULL,
  `zrfeenum` int(10) DEFAULT NULL,
  `zcstatus` int(1) DEFAULT NULL,
  `zctype` int(1) DEFAULT NULL,
  `zcfeeratio` decimal(10,2) DEFAULT NULL,
  `zcfeenum` int(10) DEFAULT NULL,
  `introduction` text,
  `remark` text,
  PRIMARY KEY (`coincode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上线币种列表';

-- ----------------------------
-- Records of sys_coin
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_notice`
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `time` datetime DEFAULT NULL,
  `sort` varchar(5) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `isdeleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统公告';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userid` int(11) NOT NULL,
  `showname` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `paypassword` varchar(200) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `sign` varchar(200) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `remark` text,
  `invitecode` varchar(50) DEFAULT NULL,
  `invite1` varchar(50) DEFAULT NULL,
  `invite2` varchar(50) DEFAULT NULL,
  `invite3` varchar(50) DEFAULT NULL,
  `creditlevel` int(2) DEFAULT NULL,
  `isdeleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表-用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_coin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_coin`;
CREATE TABLE `sys_user_coin` (
  `ucid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `coincode` varchar(10) DEFAULT NULL,
  `num` decimal(20,8) DEFAULT NULL,
  `numd` decimal(20,8) DEFAULT NULL,
  `numaddr` varchar(100) DEFAULT NULL,
  `coinsign` varchar(200) DEFAULT NULL,
  `isException` int(1) DEFAULT NULL,
  PRIMARY KEY (`ucid`),
  KEY `FK_Reference_1` (`userid`),
  KEY `FK_Reference_2` (`coincode`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`coincode`) REFERENCES `sys_coin` (`coincode`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户财产表，记录某用户对应的币种及金额';

-- ----------------------------
-- Records of sys_user_coin
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_idcard`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_idcard`;
CREATE TABLE `sys_user_idcard` (
  `icid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `enname` varchar(30) DEFAULT NULL,
  `usname` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `idcard` char(10) DEFAULT NULL,
  `ximg` char(10) DEFAULT NULL,
  `反面图` char(10) DEFAULT NULL,
  `手持图` char(10) DEFAULT NULL,
  `提交时间` char(10) DEFAULT NULL,
  `审核时间` char(10) DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `isdeleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`icid`),
  KEY `FK_Reference_20` (`userid`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户身份信息表';

-- ----------------------------
-- Records of sys_user_idcard
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_login`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE `sys_user_login` (
  `loginid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `useragent` varchar(200) DEFAULT NULL,
  `source` varchar(200) DEFAULT NULL,
  `logintype` varchar(10) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `showname` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `ustatus` int(1) DEFAULT NULL,
  PRIMARY KEY (`loginid`),
  KEY `FK_Reference_3` (`userid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录日志记录';

-- ----------------------------
-- Records of sys_user_login
-- ----------------------------

-- ----------------------------
-- Table structure for `td_market`
-- ----------------------------
DROP TABLE IF EXISTS `td_market`;
CREATE TABLE `td_market` (
  `mkid` int(11) NOT NULL,
  `coincode` varchar(10) DEFAULT NULL,
  `g_coincode` varchar(20) DEFAULT NULL,
  `round` int(11) DEFAULT NULL,
  `f_coincode` varchar(20) DEFAULT NULL,
  `feebuy` double(3,2) DEFAULT NULL,
  `feesell` double(3,2) DEFAULT NULL,
  `buymin` decimal(20,8) DEFAULT NULL,
  `buymax` decimal(20,8) DEFAULT NULL,
  `sellmin` decimal(20,8) DEFAULT NULL,
  `sellmax` decimal(20,8) DEFAULT NULL,
  `trademin` decimal(20,8) DEFAULT NULL,
  `trademax` decimal(20,8) DEFAULT NULL,
  `onbuy` int(1) DEFAULT NULL,
  `onsell` int(1) DEFAULT NULL,
  `invit1` double(3,2) DEFAULT NULL,
  `invit2` double(3,2) DEFAULT NULL,
  `invit3` double(3,2) DEFAULT NULL,
  `fxprice` decimal(20,8) DEFAULT NULL,
  `zhang` double(3,2) DEFAULT NULL,
  `die` double(3,2) DEFAULT NULL,
  `newprice` decimal(20,8) DEFAULT NULL,
  `buyprice` decimal(20,8) DEFAULT NULL,
  `sellprice` decimal(20,8) DEFAULT NULL,
  `minprice` decimal(20,8) DEFAULT NULL,
  `maxprice` decimal(20,8) DEFAULT NULL,
  `volume` decimal(20,2) DEFAULT NULL,
  `mchange` double(10,2) DEFAULT NULL,
  `daystime` datetime DEFAULT NULL,
  `dayetime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`mkid`),
  KEY `FK_Reference_6` (`coincode`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`coincode`) REFERENCES `sys_coin` (`coincode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易市场行情数据，最新成交价，24小时最高成交价...';

-- ----------------------------
-- Records of td_market
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade`;
CREATE TABLE `td_trade` (
  `tdid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `coincode` varchar(10) DEFAULT NULL,
  `price` decimal(20,8) DEFAULT NULL,
  `num` decimal(20,8) DEFAULT NULL,
  `deal` decimal(20,8) DEFAULT NULL,
  `g_coincode` varchar(20) DEFAULT NULL,
  `gnum` decimal(20,8) DEFAULT NULL,
  `f_coincode` varchar(20) DEFAULT NULL,
  `fnum` decimal(20,8) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `tradetime` datetime DEFAULT NULL,
  `dealtime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `tradesign` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`tdid`),
  KEY `FK_Reference_4` (`userid`),
  KEY `FK_Reference_5` (`coincode`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`coincode`) REFERENCES `sys_coin` (`coincode`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易委托表';

-- ----------------------------
-- Records of td_trade
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_12h`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_12h`;
CREATE TABLE `td_trade_12h` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_12h
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_15m`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_15m`;
CREATE TABLE `td_trade_15m` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_15m
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_1d`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_1d`;
CREATE TABLE `td_trade_1d` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_1d
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_1h`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_1h`;
CREATE TABLE `td_trade_1h` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_1h
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_2h`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_2h`;
CREATE TABLE `td_trade_2h` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_2h
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_30m`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_30m`;
CREATE TABLE `td_trade_30m` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_30m
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_3m`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_3m`;
CREATE TABLE `td_trade_3m` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_3m
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_4h`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_4h`;
CREATE TABLE `td_trade_4h` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_4h
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_5m`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_5m`;
CREATE TABLE `td_trade_5m` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_5m
-- ----------------------------

-- ----------------------------
-- Table structure for `td_trade_6h`
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_6h`;
CREATE TABLE `td_trade_6h` (
  `id` int(11) NOT NULL,
  `coinname` varchar(10) DEFAULT NULL,
  `d_coinname` varchar(10) DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `time` bigint(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_trade_6h
-- ----------------------------
