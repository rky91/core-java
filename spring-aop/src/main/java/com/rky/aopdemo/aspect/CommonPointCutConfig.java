package com.rky.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {
	
	@Pointcut("execution(* com.rky.aopdemo.business.*.*(..))")
	public void BusinessLayerExecution() {}
	
	@Pointcut("execution(* com.rky.aopdemo.data.*.*(..))")
	public void DataLayerExecution() {}

}
