package com.spasov.homework4.servlets;

import com.spasov.homework4.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChooseServlet", value = "/choose-servlet")
public class ChooseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        float sum = Float.parseFloat(req.getParameter("sum"));
        int count = Integer.parseInt(req.getParameter("count"));
        List<Integer> list = orderService.chooseOrder(sum, count);
        StringBuilder listStr = new StringBuilder();
        if (list == null) {
            listStr.append("None");
        } else {
            listStr.append("ID зазаков, удовлетворяющих условиям:<br>");
            for (int item : list) {
                listStr.append(item).append("<br>");
            }
        }
        req.setAttribute("chooseOrder", listStr);
        req.getRequestDispatcher("choose-order.jsp").forward(req, resp);
    }
}
