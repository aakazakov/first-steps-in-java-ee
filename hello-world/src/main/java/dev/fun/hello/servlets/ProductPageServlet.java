package dev.fun.hello.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.entities.Product;
import dev.fun.hello.repositories.ProductRepository;

@WebServlet(urlPatterns = "/product/*")
public class ProductPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductRepository productRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductPageServlet.class);
	
	@Override
	public void init() throws ServletException {
		this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		try {
			if (req.getPathInfo() == null) {
				getServletContext().getRequestDispatcher("/WEB-INF/templates/product.jsp").forward(req, resp);
			} else if (req.getPathInfo().equals("/edit")) {
				long id;
				try {
					id = Long.parseLong(req.getParameter("id"));
				} catch (NumberFormatException e) {
					resp.setStatus(400);
					return;
				}
				Product p = productRepository.get(id);
				req.setAttribute("product", p);
				getServletContext().getRequestDispatcher("/WEB-INF/templates/edit-product.jsp").forward(req, resp);
			} else if (req.getPathInfo().equals("/add")) {
				getServletContext().getRequestDispatcher("/WEB-INF/templates/add-product.jsp").forward(req, resp);
			}
		} catch (IOException | ServletException e) {
			logger.info(e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id;
		float price;
		String title;
		Product p = null;
		if (req.getPathInfo().equals("/edit")) {
			try {
				id = Long.parseLong(req.getParameter("id"));
				price = Float.parseFloat(req.getParameter("price"));
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}
			title = req.getParameter("title");
			p = new Product(id, title, price);
		} else if (req.getPathInfo().equals("/add")) {
			try {
				price = Float.parseFloat(req.getParameter("price"));
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}
			title = req.getParameter("title");
			p = new Product(title, price);
		}
		productRepository.add(p);
		try {
			resp.sendRedirect(getServletContext().getContextPath() + "/catalog");
		} catch (IOException | IllegalStateException e) {
			resp.setStatus(500);
		}
	}
	
}
