package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.repositories.ProductRepository;

@WebServlet(urlPatterns = "/catalog")
public class CatalogPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogPageServlet.class);
	
	private ProductRepository productRepository;
	
	@Override
	public void init() throws ServletException {
		this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
		if (productRepository == null) {
			throw new ServletException("productRepository not init");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setAttribute("products", productRepository.getAll());
			getServletContext().getRequestDispatcher("/WEB-INF/templates/catalog.jsp").forward(req, resp);
		} catch (IOException | ServletException e) {
			logger.info(e.getMessage());
		}
	}

}
