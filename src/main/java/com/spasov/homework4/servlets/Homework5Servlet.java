package com.spasov.homework4.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Homework5Servlet", urlPatterns = "/homework5-servlet", initParams ={@WebInitParam(name = "age", value = "20"), @WebInitParam(name = "hobie", value = "Java")}  )
public class Homework5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Ivan");
        req.setAttribute("secname", "Spasov");
        Cookie cookie = new Cookie("food", "Eat_Cookies");
        resp.addCookie(cookie);
        req.getRequestDispatcher("/homework5.jsp").forward(req, resp);
    }
}
