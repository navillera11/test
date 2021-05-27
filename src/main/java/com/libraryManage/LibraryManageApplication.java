package com.libraryManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.libraryManage.Config.JavaConfig;
import com.libraryManage.Controller.*;

@SpringBootApplication
public class LibraryManageApplication {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
//
//		MainController controllers = (MainController)ctx.getBean("mainController");
//		
		SpringApplication.run(LibraryManageApplication.class, args);
	}

}
