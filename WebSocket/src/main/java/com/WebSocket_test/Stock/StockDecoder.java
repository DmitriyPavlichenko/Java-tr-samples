package com.WebSocket_test.Stock;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class StockDecoder implements Decoder.Text<Stock> {
    @Override
    public Stock decode(String s) throws DecodeException {
        Stock stock = new Stock();
        stock.setName(s);

        System.out.println("Client request was decoded");
        return stock;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
