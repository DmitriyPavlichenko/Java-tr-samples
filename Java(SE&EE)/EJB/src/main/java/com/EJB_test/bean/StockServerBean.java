package com.EJB_test.bean;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StockServerBean {
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory factory;
    @Resource(lookup = "JMSQueue")
    private Destination textQueue;

    private String price = null;
    private final List<String> nasdaqSymbols = new ArrayList<>();

    public StockServerBean() {
        nasdaqSymbols.add("AAPL");
        nasdaqSymbols.add("MSFT");
        nasdaqSymbols.add("YHOO");
        nasdaqSymbols.add("AMZN");
    }

    public void getQuote(String symbol) {
        if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {
            price = (new Double(Math.random() * 100)).toString();
        }
        try (JMSContext context = factory.createContext("admin", "admin")) {
            JMSProducer producer = context.createProducer();
            producer.send(textQueue, price);
        }
        System.out.println("The price of " + symbol + " is " + price);
    }
}
