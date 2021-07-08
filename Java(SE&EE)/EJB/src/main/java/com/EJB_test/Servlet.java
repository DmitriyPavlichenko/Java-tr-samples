package com.EJB_test;

import com.EJB_test.bean.StockServerBean;
import com.EJB_test.client.StockConsumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        StockServerBean bean = new StockServerBean();
        bean.getQuote("HELL!");

//        StockConsumer stockConsumer = new StockConsumer();
//        stockConsumer.

    }
}