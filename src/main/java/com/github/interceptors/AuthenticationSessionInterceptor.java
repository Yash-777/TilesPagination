package com.github.interceptors;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationSessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		
		ArrayList<String> urlList = new ArrayList<String>();
		urlList.add("/login");
		urlList.add("/login.form");
		urlList.add("/regestrationForm");
		urlList.add("/regestrationForm.form");
		
		System.out.println("session PreHandling...");
		
		String contextPath = request.getContextPath();
		System.out.println("Resource Path : "+ contextPath );
		
		String url = request.getServletPath();
		System.out.println("URL ***** "+url);
		
		// /regestrationForm /login /lsit
		String userName = ( String ) request.getSession().getAttribute("userName");
		if( !urlList.contains(url) && userName == null ) {
			System.out.println("redirecting..");
			response.sendRedirect(contextPath+"/login.form");
			return false;
		}
		return true;
	}
}