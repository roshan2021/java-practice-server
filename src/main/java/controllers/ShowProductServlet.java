package controllers;
import models.Product;
import daos.DoaFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowProductServlet", urlPatterns = "/product")
public class ShowProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        try {
            Product product = DoaFactory.getProductsDao().findOne(id);
            request.setAttribute("product", product);
        } catch (IndexOutOfBoundsException ex) {
            request.setAttribute("error", "Product does not exist");
            ex.printStackTrace();

        }
        request.getRequestDispatcher("/products/show.jsp").forward(request, response);
    }
}