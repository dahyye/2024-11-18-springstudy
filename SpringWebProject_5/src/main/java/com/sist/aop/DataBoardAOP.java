package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataBoardAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	//전체 메소드
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		System.out.println("수행 메소드 : "+jp.getSignature().getName());
		//사용자가 요청한 메소드이름 출력
		long start = System.currentTimeMillis();
		obj=jp.proceed(); //Exception 의 상위클래스로 예외처리를 해야한다
		//예외처리는 같은 레벨을 선택하거나 상위 레벨을 선택해야한다
		long end = System.currentTimeMillis();
		System.out.println("수행시간 : "+(end-start));
		return obj;
	}
}