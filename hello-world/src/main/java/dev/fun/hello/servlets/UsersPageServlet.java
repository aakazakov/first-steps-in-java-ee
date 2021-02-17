package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.repositories.UserRepository;

@WebServlet(urlPatterns = "/users")
public class UsersPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogPageServlet.class);
	
	private UserRepository userRepository;
	
	@Override
	public void init() throws ServletException {
		userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("users", userRepository.getAll());
			getServletContext().getRequestDispatcher("/WEB-INF/templates/users.jsp").forward(req, resp);
		} catch (IOException | ServletException e) {
			logger.info(e.getMessage());
		}
	}
	
}
