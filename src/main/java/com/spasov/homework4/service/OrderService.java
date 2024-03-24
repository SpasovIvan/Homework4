package com.spasov.homework4.service;

import com.spasov.homework4.DbManager;
import com.spasov.homework4.entity.Order;
import com.spasov.homework4.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {

    public Order showInfo(long numOrder) {
        try (Connection connection = DbManager.createConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select product.id, product.title, product.description, product.price,\n" +
                            "    orders_product.count, orders.date_order from orders_product\n" +
                            "    join product on orders_product.product_id = product.id join\n" +
                            "    orders on orders_product.order_id = orders.id where order_id = ?",
                            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setLong(1, numOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                List<Product> productList = new ArrayList<>();
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    float price = resultSet.getFloat("price");
                    int count = resultSet.getInt("count");
                    productList.add(new Product(id, title, description, price, count));
                }
                resultSet.absolute(1);
                Date date = resultSet.getDate("date_order");

                return new Order(numOrder, date, productList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Integer> chooseOrder(float sum, int count) {
        List<Integer> list;
        try (Connection connection = DbManager.createConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select orders_product.order_id from orders_product " +
                            "join product on orders_product.product_id = product.id " +
                            "group by orders_product.order_id having sum(orders_product.count * product.price) <= ? " +
                            "and count(product_id) = ?");
            preparedStatement.setFloat(1, sum);
            preparedStatement.setInt(2, count);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    int orderNum = resultSet.getInt("order_id");
                    list.add(orderNum);
                }

                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Integer> searchByProd(int numProd) {
        List<Integer> list;
        try (Connection connection = DbManager.createConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select distinct orders_product.order_id from orders_product where product_id = ?");
            preparedStatement.setInt(1, numProd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    int numOrd = resultSet.getInt("order_id");
                    list.add(numOrd);
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> currentDayOrd(int notProd) {
        List<Integer> list;
        try (Connection connection = DbManager.createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select orders_product.order_id from orders_product join orders on orders_product.order_id = orders.id where product_id != ? and date_order = CURRENT_DATE;");
            preparedStatement.setInt(1, notProd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    int ordNum = resultSet.getInt("order_id");
                    list.add(ordNum);
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
