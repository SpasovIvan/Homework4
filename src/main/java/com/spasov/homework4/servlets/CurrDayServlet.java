package com.spasov.homework4.servlets;

import com.spasov.homework4.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CurrDayServlet", value = "/curr_day-servlet")
public class CurrDayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        int notProd = Integer.parseInt(req.getParameter("notProd"));
        StringBuilder listStr = new StringBuilder();
        List<Integer> list = orderService.currentDayOrd(notProd);
        if (list != null) {
            listStr.append("ID товаров с сегодняшней датой и не содержащих заданный товар.<br>");
            list.forEach(item -> listStr.append(item).append("<br>"));
//        for (int i : orderService.currentDayOrd(notProd)) {
//
//        }
        } else {
            listStr.append("Не найдено.<br>");
        }
        req.setAttribute("currDay", listStr);
        req.getRequestDispatcher("curr-day.jsp").forward(req, resp);

    }


}
