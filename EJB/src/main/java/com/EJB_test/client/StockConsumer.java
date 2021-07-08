package com.EJB_test.client;

import com.EJB_test.bean.StockServerBean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "JMSQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class StockConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("The message is:\n" + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public StockConsumer() {
        ConnecTonFactory factory = new com.sun.messaging.ConnecTonFactory();
        actory.setProperty(ConnecTonConfiguraTon.imqAddressList, "mq://localhost:7677,mq://localhost:7677");
        connecTon = factory.createQueueConnecTon("admin", "admin");
        connecTon.start();
        Session session = connecTon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue ioQueue = session.createQueue("TestQueue");
        consumer = session.createConsumer(ioQueue);
        consumer.setMessageListener(this);
        System.out.println("Listening    to    the    TestQueue...");
        Thread.sleep(100000);
    }
}