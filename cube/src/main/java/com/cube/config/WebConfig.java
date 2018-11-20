package com.cube.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cube.interceptor.productHandlerInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	public productHandlerInterceptor prodInterCeptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("auth/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(prodInterCeptor).addPathPatterns("/");
		
	}
	
	
	
	
	

	
	
}
