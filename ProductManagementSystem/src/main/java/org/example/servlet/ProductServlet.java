package org.example.servlet;


import org.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalog/products")

public class ProductServlet extends HttpServlet {

    static final List<Product> products = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String createdBy = (String) request.getSession().getAttribute("user");
        products.add(new Product(name, price, createdBy));
        response.getWriter().println("Product added!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Product product : products) {
            response.getWriter().println(product);
        }
    }
}
