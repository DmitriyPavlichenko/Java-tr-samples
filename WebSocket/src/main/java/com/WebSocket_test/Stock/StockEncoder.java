package com.WebSocket_test.Stock;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class StockEncoder implements Encoder.Text<Stock> {
    @Override
    public String encode(Stock stock) throws EncodeException {
        System.out.println("Server response was encoded");
        return "Name: " + stock.getName() + "; price: " + stock.getPrice();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
