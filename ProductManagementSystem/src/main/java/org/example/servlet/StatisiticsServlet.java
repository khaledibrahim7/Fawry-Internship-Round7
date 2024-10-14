package org.example.servlet;

import org.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/catalog/statisitics")
public class StatisiticsServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalProducts = ProductServlet.products.size();

        double totalPrice = ProductServlet.products.stream().mapToDouble(Product::getPrice).sum();
        response.getWriter().println("Total products: " + totalProducts);
        response.getWriter().println("Total price: " + totalPrice);
    }

}