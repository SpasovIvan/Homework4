package com.spasov.homework4.servlets;

import com.spasov.homework4.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        int numProd = Integer.parseInt(req.getParameter("numProd"));
        List<Integer> list = orderService.searchByProd(numProd);
        StringBuilder listStr = new StringBuilder();
        if (list == null) {
            listStr.append("None");
        } else {
            listStr.append("ID зазаков, содержащих данный товар:<br>");
            for (int item : list) {
                listStr.append(item).append("<br>");
            }
        }
        req.setAttribute("searchProd", listStr);
        req.getRequestDispatcher("search-prod.jsp").forward(req, resp);

    }
}
