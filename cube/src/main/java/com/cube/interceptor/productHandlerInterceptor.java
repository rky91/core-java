package com.cube.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cube.util.CartCount;

@Service
public class productHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("############### inside preHandle()");
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("cartCount") == null) {
			session.setAttribute("cartCount", new CartCount(0));
		}
		
		return true;
	}

	

}
