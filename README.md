# [Spring Framework 기말 고사 과제] LibraryManage

주제 : 도서관 프로그램

조원 : 민지 * 2

## 목차
   * [1.Admin 기능](#Admin-기능)
   * [2.Member 기능](#Member-기능)
   * [3.Database 구조](#Database-구조)
   * [4.PUSH 목록](#PUSH-목록)

## Admin 기능

    * **도서**
      * 도서 추가 - 이미지 제외
      * 도서 삭제 - 구현 완료
      * 도서 수정 - 이미지 제외
      * 연체 도서 - 페이지 미완성
      
    * **공지 사항**
      * 공지 사항 추가 - 공지 사항 내용 기능 미완성
      * 공지 사항 삭제 - 구현 완료
      
    * 추천 도서
      * 추천 도서 추가 - 구현 완료
      * 추천 도서 삭제 - 구현 완료
      
    * **게시물 비공개 설정**
      * 게시글 테이블 생성하기
      * 댓글 테이블 생성하기
      * 게시글 목록 페이지 생성하기
      * 게시글 세부 페이지 생성하기 (With 댓글)
      * 게시글 작성 페이지 생성하기
      * 관리자 게시물 비공개 페이지 - 공개 여부 컬럼 출력
    
    * **회원**
      * 회원 목록 - 구현 완료
      * 회원 블랙리스트 - 구현 완료
      * 회원 신청 도서 목록 조회 - 구현 완료(2020-05-31)
   

## Member 기능

    * **회원**
      * 회원가입 - 구현 완료
      * 로그인 - 구현 완료
      * 비밀번호 수정
      
    * **도서**
      * 도서 대여
      * 도서 반납
      * 도서 검색
      * 도서 신청
      * 도서 예약 - 보류
      * 대여 기간 연장
      
    * **내 서재**
      * 연체 도서 확인
    
    * **신간 도서 조회**
      * 도서 상세 페이지
      
    * **사서 추천 도서 조회**
    
    * **공지사항 조회**
 

## Database 구조

[현재까지 구현한 Database Table 모음집](./src/main/resources/static/sql/databasesTable.md)

    * 회원 - 완성
    * 도서 - 완성
    * 공지 사항 - 완성
    * 추천 도서 - 완성
    * 대여 도서 - 완성
    * 신청 도서
    * 게시판
    * 댓글

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
  * AdminMemberController.java - 회원 조회, 블랙리스트 회원 조회 페이지 매핑
  * admin_index.jsp - 이미지 이름 살짝 수정
  	* alarm_freeBoard -> alarm_free_board
  	* member_blackList -> member_black_show
  * admin_member_black_show.jsp - 블랙리스트 회원 조회 페이지
  * admin_member_reset.jsp - 블랙리스트 회원 조회 페이지로 가는 링크 수정
  * admin_index.jsp - 블랙리스트 회원 조회 페이지로 가는 링크 수정 및 썸네일 이미지 이름 수정

2020-05-31:

   * 희망 도서
      * src/main/java/com/libraryManage/Controller/AdminController.java - 경로 추가
      * src/main/webapp/WEB-INF/VIEWS/admin_index.jsp - 경로 추가
      * src/main/webapp/WEB-INF/VIEWS/admin_member_black_show.jsp - 경로 추가
      * src/main/webapp/WEB-INF/VIEWS/admin_member_hope.jsp - 희망 도서 페이지 생성
      * src/main/webapp/WEB-INF/VIEWS/admin_member_reset.jsp - 초기화 페이지 삭제
      * src/main/webapp/WEB-INF/VIEWS/admin_member_show.jsp - 경로 추가

   * 연체 도서
      * src/main/webapp/WEB-INF/VIEWS/admin_book_overdue.jsp - 연체 도서 페이지 생성
      * src/main/webapp/WEB-INF/VIEWS/admin_book_add.jsp - 경로 추가
      * src/main/webapp/WEB-INF/VIEWS/admin_book_delete.jsp - 경로 추가
      * src/main/webapp/WEB-INF/VIEWS/admin_book_update.jsp - 경로 추가
      * src/main/webapp/WEB-INF/VIEWS/admin_index.jsp -경로 추가
      * src/main/java/com/libraryManage/Controller/AdminController.java - 경로 추가 
