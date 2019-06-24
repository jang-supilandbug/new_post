package com.example.post.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class MyExceptionHandler extends RuntimeException {
	
	@ExceptionHandler(Exception.class)
	public void handlerException(HttpServletRequest request, HttpServletResponse response,
									Exception e) throws Exception{
		StringWriter error = new StringWriter();
		e.printStackTrace(new PrintWriter(error));
		request.setAttribute("error", error);
		
		request.getRequestDispatcher("/WEB-INF/views/error/error.jsp").forward(request, response);
	}
}

