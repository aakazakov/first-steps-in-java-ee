package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/404")
public class PageNotFoundServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PageNotFoundServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			getServletContext().getRequestDispatcher("/html/404.html").include(req, resp);
		} catch (ServletException | IOException e) {
			logger.info(e.getMessage());
		}
	}
	
}
