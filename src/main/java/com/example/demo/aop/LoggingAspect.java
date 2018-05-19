//package com.example.demo.aop;
//
//import java.util.Arrays;
//import java.util.WeakHashMap;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.validation.User;
//@Component
//@Aspect
//public class LoggingAspect {
//	
//	
//	
//	 private WeakHashMap<Object[], Object> cache = new WeakHashMap<Object[], Object>();
//
//	@Around("execution(public * com.example..*.addUser(..))")
//	public void doAroundAllPublicMethods(ProceedingJoinPoint  joinPoint) {
//		System.out.println("Aspect methode aufgerufen "+joinPoint);
//		
//		
//		 User args = (User)joinPoint.getArgs()[0];
//		 System.out.println(Arrays.asList(args));
//
//	        if (args != null)
//	        {
//	            Object response = cache.get(Arrays.asList(args));
//	            
//	        }
//	        try {
//				Object obj = joinPoint.proceed();
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	     
//		
//		
//	      
//	}
//}