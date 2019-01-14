package com.rky.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	
	//@AfterReturning(value="execution(* com.rky.aopdemo.business.*.*(..))", returning="result")
	@AfterReturning(value="com.rky.aopdemo.aspect.CommonPointCutConfig.BusinessLayerExecution()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("After returing {}, JoinPoint : {}", result, joinPoint);
	}
	
	//@AfterThrowing(value="execution(* com.rky.aopdemo.business.*.*(..))", throwing="exception")
	@AfterThrowing(value="com.rky.aopdemo.aspect.CommonPointCutConfig.BusinessLayerExecution()", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		logger.info("After Throwing: {}, JoinPoint : {}", exception, joinPoint);
	}
	
	//@After(value="execution(* com.rky.aopdemo.business.*.*(..))")
	@After(value="com.rky.aopdemo.aspect.CommonPointCutConfig.BusinessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("After Execution, JoinPoint : {}", joinPoint);
	}

}
