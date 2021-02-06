package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/cart")
public class CartPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(CartPageServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			getServletContext().getRequestDispatcher("/html/cart.html").include(req, resp);
			getServletContext().getRequestDispatcher("/html/menu.html").include(req, resp);
		} catch (IOException | ServletException e) {
			logger.info(e.getMessage());
		}
	}
	
}
