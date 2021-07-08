package com.company;

public class Order {
    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    private int id;
    private String symbol;
    private int quantity;
    private float price;

    public Order(int id, String stockSymbol, int quantity, float price) {
        this.id = id;
        this.symbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }
}