package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String VALID_USER = "user";
    private static final String VALID_PASS = "pass";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (VALID_USER.equals(username) && VALID_PASS.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.getWriter().write("Login successful!");
        } else {
            response.getWriter().write("Invalid credentials!");
        }
    }
}
