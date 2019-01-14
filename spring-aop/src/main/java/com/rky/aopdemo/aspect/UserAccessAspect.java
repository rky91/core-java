package com.rky.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	//What kind of method I would intercept
	/*
	 	execution (* PACKAGE.*.*(..))
	 		*: Any return type
			PACKAGE: package name
			*: any class
			*: any method
			(..): any number of arguments
	*/
	
	//@Before("execution(* com.rky.aopdemo.business.*.*(..))")
	@Before("com.rky.aopdemo.aspect.CommonPointCutConfig.BusinessLayerExecution()") //Defined in common pointcut
	public void before(JoinPoint joinPoint) {
		//Inside this method everything is called ADVISE.
		logger.info("Checking for the user access...");
		logger.info("User accessed : {}", joinPoint);
	}


}
