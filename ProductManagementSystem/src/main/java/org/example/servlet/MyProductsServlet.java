package org.example.servlet;

import org.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/catalog/my-products")
public class MyProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("user");

        if (username != null) {
            for (Product product : ProductServlet.products) {
                if (product.getCreatedBy().equals(username)) {
                    response.getWriter().println(product);
                }
            }
        } else {
            response.getWriter().println("You need to log in to view your products.");
        }
    }
    }

