package com.spasov.homework4.servlets;

import com.spasov.homework4.entity.Order;
import com.spasov.homework4.entity.Product;
import com.spasov.homework4.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShowInfoServlet", value = "/show_info-servlet")
public class ShowInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        long numOrder = Long.parseLong(req.getParameter("numOrder"));
        Order order = orderService.showInfo(numOrder);
        StringBuilder orderInfo = new StringBuilder();
        if (order != null) {
            orderInfo.append("ID: ").append(order.getId()).append("<br>").append("Date: ").append(order.getDateOrder()).append("<br><br>PRODUCTS:<br><br>");
            for (Product product : order.getProductsList()) {
                orderInfo.append(product).append("<br>");
            }
        } else {
            orderInfo.append("Заказ не найден");
        }
        req.setAttribute("showOrder", orderInfo);
        req.getRequestDispatcher("/show_info.jsp").forward(req, resp);
    }
}
