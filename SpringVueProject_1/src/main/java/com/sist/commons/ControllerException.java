package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//공통 예외처리
@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception ex)
	{
		System.out.println("*** Controller에서 오류 발생 ***");
		ex.printStackTrace();
	}

}
