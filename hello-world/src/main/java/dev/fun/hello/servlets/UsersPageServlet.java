package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.entities.User;
import dev.fun.hello.repositories.UserRepository;

@WebServlet(urlPatterns = "/users/*")
public class UsersPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UsersPageServlet.class);
	
	private UserRepository userRepository;
	
	@Override
	public void init() throws ServletException {
		userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getPathInfo() == null) {
			try {
				req.setAttribute("users", userRepository.getAll());
				getServletContext().getRequestDispatcher("/WEB-INF/templates/users.jsp").forward(req, resp);
			} catch (IOException | ServletException e) {
				logger.info(e.getMessage());
			}
		} else if (req.getPathInfo().equals("/edit")) {
			long id;
			try {
				id = Long.parseLong(req.getParameter("id"));
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}
			User u = userRepository.get(id);
			try {
				req.setAttribute("user", u);
				getServletContext().getRequestDispatcher("/WEB-INF/templates/edit-user.jsp").forward(req, resp);
			} catch (IOException | ServletException e) {
				logger.info(e.getMessage());
			}
		} else if (req.getPathInfo().equals("/delete")) {
			long id;
			try {
				id = Long.parseLong(req.getParameter("id"));
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}
			userRepository.delete(id);
			try {
				resp.sendRedirect(getServletContext().getContextPath() + "/users");
			} catch (IOException | IllegalStateException e) {
				resp.setStatus(500);
			}
		} else if (req.getPathInfo().equals("/add")) {
			getServletContext().getRequestDispatcher("/WEB-INF/templates/add-user.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id;
		User u = null;
		if (req.getPathInfo().equals("/edit")) {
			try {
				id = Long.parseLong(req.getParameter("id"));
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}
			u = new User(id, req.getParameter("name"), req.getParameter("role"), req.getParameter("password"));
		} else if (req.getPathInfo().equals("/add")) {
			u = new User(req.getParameter("name"), req.getParameter("role"), req.getParameter("password"));
		}
		
		userRepository.add(u);
		try {
			resp.sendRedirect(getServletContext().getContextPath() + "/users");
		} catch (IOException | IllegalStateException e) {
			resp.setStatus(500);
		}
	}
	
}
