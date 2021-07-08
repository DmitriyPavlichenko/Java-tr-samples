package com.company;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Portfolio {
    List<Order> order = new LinkedList<>();

    public Portfolio() {
        String sqlQuery = "SELECT * FROM Portfolio";
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson21");
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sqlQuery)) {
            while (result.next()) {
                int id = result.getInt(1);
                String symbol = result.getString(2);
                int quantity = result.getInt(3);
                float price = result.getFloat(4);
                order.add(new Order(id, symbol, quantity, price));
                System.out.println(id + ", " + symbol + ", " + quantity + ", " + price + ", total value: " + (quantity * price));
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getErrorCode());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Order> getOrder() {
        return order;
    }
}
