## 현재까지 만든 데이터베이스 테이블 

## 도서 테이블

~~~~sql
CREATE TABLE `spring5fs`.`book` (
  `ISBN` varchar(45) NOT NULL DEFAULT '',
  `TITLE` varchar(45) DEFAULT NULL,
  `AUTHOR` varchar(45) DEFAULT NULL,
  `GENRE` varchar(45) DEFAULT NULL,
  `PUBLISHER` varchar(45) DEFAULT NULL,
  `IMAGE` blob,
  `COUNT` int(11) DEFAULT '1',
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
~~~~

## 회원 테이블

~~~~sql
CREATE TABLE `spring5fs`.`member` (
  `EMAIL` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `RANK` int(11) DEFAULT '0',
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
~~~~

## 공지사항 테이블 

~~~~sql
CREATE TABLE `spring5fs`.`notice` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(45) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `CONTENT` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
~~~~
