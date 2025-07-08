package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello9")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

out.println("<h1>Hello, World! (Cập nhật từ nhánh feature-fr ngày 08/07/2025)</h1>");
        out.println("<p>Chúc bạn làm bài CI/CD thành công 🚀</p>");
    }
}
