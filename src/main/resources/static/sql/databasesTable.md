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

## 대여 테이블 

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
CREATE TABLE `book` (
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


## PUSH 목록

2020-05-31:
  * databasesTable.md - 추천 도서 테이블 sql
  * admin_alarm_good_add, delete.jsp - 추천 도서 목록 출력, 도서 목록 출력
  * AdminGoodController.java - 추천 도서 추가, 삭제
  * GoodDAO.java - 추천 도서 추가, 삭제
  * GoodDTO.java - 추천 도서 DTO
  * GoodService - 추천 도서 추가, 삭제
  * CheckOutDTO.java - 대여 도서 DTO
  * AdminController.java - 주석 처리
  * MemberDAO.java - 모든/블랙리스트 회원 조회 기능
  * MemberDTO.java - Getter/Setter 추가
  * admin_member_show.jsp - 회원 목록 조회, 블랙리스트 회원 조회 페이지로 가는 링크 수정
  * AdminMemberController.java - 회원 조회, 블랙리스트 회원 조회
  * admin_index.jsp - 이미지 이름 살짝 수정
  	* alarm_freeBoard -> alarm_free_board
  	* member_blackList -> member_black_show
  * admin_member_black_show.jsp - 블랙리스트 회원 조회 페이지
  * admin_member_reset.jsp - 블랙리스트 회원 조회 페이지로 가는 링크 수정
  * admin_index.jsp - 블랙리스트 회원 조회 페이지로 가는 링크 수정 및 썸네일 이미지 이름 수정