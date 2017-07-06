package com.github.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TimeInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler)throws Exception {
		
		long time = System.currentTimeMillis();
		request.setAttribute("time", time);
		System.out.println("pre handle method, time in ms is : "+time);
		return true;
	}
	@Override  	
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		long totalTime = System.currentTimeMillis() - (Long)request.getAttribute("time");
		modelAndView.addObject("totalTime", totalTime);
		System.out.println(" post handle method, totalTime passed: " + totalTime + "ms" );
	}
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp,
			Object handler, Exception ex) throws Exception {
		
		super.afterCompletion(req, resp, handler, ex);
		System.out.println("####### after comletion");
	}
}