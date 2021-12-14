package com.bharath.spring.springaop.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogginAspect {

	@Before("execution(* com.bharath.spring.springaop.ProductServiceImpl.multiply(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before Calling the method" + joinPoint );
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
	}

	@After("execution(* com.bharath.spring.springaop.ProductServiceImpl.multiply(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After the method invocation");
	}
	
	@AfterReturning(pointcut="execution(* multiply(..))", returning="x")
	public void getNameReturningAdvice(int x){
		System.out.println("getNameReturningAdvice executed. Returned String="+x);
	}
	
	@Around("execution(* com.bharath.spring.springaop.ProductServiceImpl.multiply(..))")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Before invoking multiply() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getName() method. Return value="+value);
		return value;
	}
	

}


