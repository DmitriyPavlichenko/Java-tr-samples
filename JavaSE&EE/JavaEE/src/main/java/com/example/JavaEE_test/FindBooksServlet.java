package com.example.JavaEE_test;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/books")
public class FindBooksServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String price = (new Double(Math.random()*100)).toString();
        out.println("Price of \"" + request.getParameter("Company name") + "\" is " + price);
    }

    public void destroy() {
    }
}