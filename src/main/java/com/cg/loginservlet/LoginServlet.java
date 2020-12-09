package com.cg.loginservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description= "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" }

)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//get request parameters for userID and password
//        String user = request.getParameter("user");
//        String pwd= request.getParameter("pwd");
//get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        if (Pattern.matches("(^[A-Z])([a-zA-Z]){2,}", userID) && Pattern.matches("(?=.*?[A-Z])(?=.*?[0-9])(?=[^!@#$%^&*-]*[!@#$%^&*-][^!@#$%^&*-]*$)[a-zA-Z0-9!@#$%6&*-]{8,}", password)) {
            request.setAttribute("user", userID);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
