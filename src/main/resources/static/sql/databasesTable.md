## 현재까지 만든 데이터베이스 테이블 

## 공지사항 테이블 

~~~~sql
CREATE TABLE `spring5fs`.`notice` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TITLE` VARCHAR(45) NULL,
  `DATE` DATE NULL,
  `CONTENT` VARCHAR(1000) NULL,
  PRIMARY KEY (`ID`));
~~~~
