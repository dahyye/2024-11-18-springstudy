package com.sist.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
import com.sist.vo.*;

@Aspect // 메모리 할당 (X) => 공동 모듈  	이 클래스가 Aspect라는 걸 명시
@Component 
// request : @Controller , @RestController 
// Interceptor
public class GoodsAOP {
   @Autowired
   private MovieDAO mDao;
   
   @After("execution(* com.sist.web.*Controller.*(..))")
   public void after()
   {
	   // 현재 사용중인 request를 가지고 온다 
	   HttpServletRequest request=
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	   List<MovieVO> kList=mDao.movieListData();
	   request.setAttribute("kList", kList);
   }
   
   @Around("execution(* com.sist.web.*Controller.*(..))")
   public void Around(ProceedingJoinPoint jp) throws Throwable
   {
	   Object obj=null;
	   System.out.println("사용자 요청 : "+jp.getSignature().getName());
	   obj=jp.proceed();
	   System.out.println("요청 처리 완료 : "+jp.getSignature().getName());
	   
   }
   
}