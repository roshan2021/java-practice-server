package controllers;

import daos.DoaFactory;
import interfaces.Products;
import models.Product;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "ViewProductsServlet", urlPatterns = "/products")
public class ViewProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Products products = DoaFactory.getProductsDao();
        List<Product> productList = products.all();
        request.setAttribute("products", productList);
        request.getRequestDispatcher("/products/index.jsp").forward(request, response);
    }
}