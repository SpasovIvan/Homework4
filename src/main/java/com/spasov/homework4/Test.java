package com.spasov.homework4;

import com.spasov.homework4.entity.Order;
import com.spasov.homework4.service.OrderService;

public class Test {
    public static void main(String[] args) {
        OrderService service = new OrderService();
//        Order order = service.showInfo(1);
//        System.out.println(order);
//        System.out.println(service.chooseOrder(2500, 3));
        System.out.println(service.searchByProd(1));
    }
}
