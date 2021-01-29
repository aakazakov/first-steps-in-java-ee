package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleServlet implements Servlet {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleServlet.class);
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;		
		logger.info("The servlet has been initialized...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().println("<h1 style=\"color: green\">hello, world</h1>");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		logger.info("The servlet was destroyed...");
	}

}
