## 현재까지 만든 데이터베이스 테이블 

## 도서 테이블

   * 2021-05-31 이전
   
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

   * 2020-05-31 이후
   
~~~~sql
CREATE TABLE spring5fs.book
(
   `ISBN`         VARCHAR(45)
                    CHARACTER SET utf8
                    COLLATE utf8_general_ci
                    NOT NULL
                    DEFAULT '',
   `TITLE`        VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `AUTHOR`       VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `GENRE`        VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `PUBLISHER`    VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `IMAGE`        BLOB NULL,
   `COUNT`        INT(11) NULL DEFAULT 1,
   `SUMMARY`      TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `HIT`          TINYINT(100) NULL DEFAULT 0,
   PRIMARY KEY(`ISBN`)
)
ENGINE INNODB
COLLATE 'utf8_general_ci'
ROW_FORMAT DEFAULT;
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

## 대여 테이블 

   * 2021-05-31 이전
   
~~~~sql
CREATE TABLE spring5fs.`checkout`
(
   `ISBN`               VARCHAR(45) NULL,
   `EMAIL`              VARCHAR(45) NULL,
   `RENTAL_DATE`        DATE NULL,
   `RETURN_DUE_DATE`    DATE NULL,
   PRIMARY KEY(`ISBN`, `EMAIL`)
)
ENGINE = INNODB
CHARACTER SET 'utf8'
COLLATE 'utf8_general_ci';

ALTER TABLE spring5fs.`checkout`
   ADD CONSTRAINT `FK_checkout_1` FOREIGN KEY(`ISBN`)
          REFERENCES spring5fs.book (`ISBN`);

ALTER TABLE spring5fs.`checkout`
   ADD CONSTRAINT `FK_checkout_2` FOREIGN KEY(`EMAIL`)
          REFERENCES spring5fs.member (`EMAIL`)
~~~~

## 추천 도서 테이블

~~~~sql
CREATE TABLE spring5fs.good
(
   `ID`         INT(11) NOT NULL AUTO_INCREMENT,
   `ISBN`       VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `TITLE`      VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `CONTENT`    VARCHAR(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `DATE`       DATE NULL,
   PRIMARY KEY(`ID`)
)
ENGINE INNODB
COLLATE 'utf8_general_ci'
ROW_FORMAT DEFAULT;
~~~~

   * 2020-05-31 이후
   
~~~~sql
CREATE TABLE spring5fs.good
(
   `ID`         INT(11) NOT NULL AUTO_INCREMENT,
   `ISBN`       VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `TITLE`      VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `CONTENT`    VARCHAR(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `DATE`       DATE NULL,
   PRIMARY KEY(`ID`)
)
ENGINE INNODB
COLLATE 'utf8_general_ci'
ROW_FORMAT DEFAULT;
~~~~

## 게시판 테이블

~~~~sql
CREATE TABLE `board` (
  `FBID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(45) DEFAULT NULL,
  `TITLE` varchar(45) DEFAULT NULL,
  `CONTENT` varchar(1000) DEFAULT NULL,
  `DATE` varchar(45) DEFAULT NULL,
  `PUBLIC` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FBID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
~~~~