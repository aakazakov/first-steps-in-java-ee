package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/home")
public class HomePageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(HomePageServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {	
		try {			
			getServletContext().getRequestDispatcher("/WEB-INF/templates/home.jsp").forward(req, resp);
		} catch (IOException | ServletException e) {
			logger.info(e.getMessage());
		}
	}	

}
