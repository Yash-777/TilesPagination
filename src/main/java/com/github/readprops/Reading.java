package com.github.readprops;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reading")
public class Reading extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Entered... :   context: /PropertyFileTest  repositories: /WEB-INF/classes/");
		Properties props = new Properties();
		ClassLoader WebappClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println("Loader : "+WebappClassLoader);
		props.load(WebappClassLoader.getResourceAsStream("webprops.properties"));
		PrintWriter out = response.getWriter();
		out.println(props);
		System.out.println("Ended");
	}
}