package com.libraryManage.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;
import com.libraryManage.Exception.*;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
   @Autowired
   BookService bookService;
   @Autowired
   BookDAO bookDAO;

   @Autowired
   MemberService memberService;
   @Autowired
   MemberDAO memberDAO;

   @Autowired
   CheckOutDAO checkOutDAO;

   // 도서 상세 페이지 이동
   @RequestMapping(value = "/book_detail", method = RequestMethod.GET)
   public String book_detail(Model model, @RequestParam String bookISBN) {
      BookDTO bookDTO = bookDAO.selectByISBN(bookISBN);

      model.addAttribute("bookDTO", bookDTO);

      return "book_detail";
   }

   // 도서 대여
   @PostMapping("/book_detail")
   public void book_detail(HttpSession session, @RequestParam String bookISBN, HttpServletResponse response)
         throws Exception {
      try {
         MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

         BookDTO bookDTO = bookDAO.selectByISBN(bookISBN);

         if (sessionMemberDTO == null)
            throw new NotLoginException("로그인 먼저 해주세요.");
         else {
            if (sessionMemberDTO.getMemberRank() == -1)
               throw new BlackListException("대여하지 못하는 등급입니다.");
            else {
               if (sessionMemberDTO.getMemberReturnAvailable() > 0 && bookDTO.getBookCount() > 0) {
                  checkOutDAO.insertCheckOut(sessionMemberDTO.getMemberEmail(), bookDTO);

                  bookDTO.setBookCount(bookDTO.getBookCount() - 1); // 재고 수 - 1
                  bookDTO.setBookHit(bookDTO.getBookHit() + 1); // 대여 횟수 + 1

                  bookDAO.updateBook(bookDTO); // 도서 정보 업데이트

                  response.sendRedirect("/book/book_detail?bookISBN=" + bookISBN);
               } else
                  throw new NotAvailableException("더 이상 대여할 수 없습니다.");
            }
         }
      } catch (NotLoginException ex) {
         response.setContentType("text/html; charset=UTF-8");

         PrintWriter out = response.getWriter();

         out.println("<script>alert('로그인 먼저 해주세요.'); location.href='/member/login';</script>");

         out.flush();
      } catch (BlackListException ex) {
         response.setContentType("text/html; charset=UTF-8");

         PrintWriter out = response.getWriter();

         out.println("<script>alert('대여하지 못하는 등급입니다.'); location.href='/member/my_page';</script>");

         out.flush();
      } catch (NotAvailableException ex) {
         response.setContentType("text/html; charset=UTF-8");

         PrintWriter out = response.getWriter();

         out.println("<script>alert('더 이상 대여할 수 없습니다.'); location.href='/member/my_page';</script>");

         out.flush();
      }
   }

   // 도서 전체 검색
   @RequestMapping(value = "/unified_search", method = RequestMethod.GET)
   public String book_unified_search(Model model) {
      List<BookDTO> bookList = bookDAO.showAll();

      model.addAttribute("bookList", bookList);

      return "book_unified_search";
   }
   
   // 인기 도서 목록
   @RequestMapping(value = "/hit_unified_search", method = RequestMethod.GET)
   public String hit_book_unified_search(Model model) {
      List<BookDTO> hitBookList = bookDAO.hitBook();
      
      model.addAttribute("hitBookList", hitBookList);
      
      return "hit_book_unified_search";
   }
}