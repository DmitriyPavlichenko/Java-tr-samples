package com.WebSocket_test;

import com.WebSocket_test.Stock.*;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
@ServerEndpoint(value = "/Stock",
        decoders = {StockDecoder.class},
        encoders = {StockEncoder.class})
public class StockWebSocket {

    @OnMessage
    public Stock getPriceQuote(Stock stock){
        stock.setPrice(Math.random());
        return stock;
    }
}
