package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class HelloServletTest {

    @Test
    public void testDoGet() throws Exception {
        // Mock các đối tượng Servlet
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Giả lập PrintWriter để bắt nội dung đầu ra
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Tạo và gọi phương thức doGet
        HelloServlet servlet = new HelloServlet();
        servlet.doGet(request, response);

        // Xác minh hành vi
        Mockito.verify(response).setContentType("text/html");

        // Kiểm tra nội dung đầu ra
        writer.flush(); // Đảm bảo nội dung được ghi
        String output = stringWriter.toString();
        assertTrue(
            output.contains("<h1>Hello, World! (Dev1 sửa nội dung test ngày 08/07/2025)</h1>") ||
            output.contains("<p>Chúc bạn làm bài CI/CD thành công 🚀</p>"),
            "Nội dung đầu ra không chứa chuỗi dự kiến sau khi cập nhật từ Dev1"
        );
    }
}
