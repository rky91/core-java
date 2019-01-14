package com.rky.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Around(value="com.rky.aopdemo.aspect.CommonPointCutConfig.DataLayerExecution()")
	public void after(ProceedingJoinPoint joinPoint) {
		
		//get the Start time
		long startTime = System.currentTimeMillis();
		
		// Proceed with the execution
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//get the end time after the execution
		long finalTime = System.currentTimeMillis() - startTime;
		
		logger.info("After Execution The time taken is : {}, JoinPoint : {}", finalTime, joinPoint);
	}
	
}
