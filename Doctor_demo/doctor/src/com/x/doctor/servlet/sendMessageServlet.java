package com.x.doctor.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

@WebServlet("/sendMessageServlet")
public class sendMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sendMessage=request.getParameter("sendMessage");
        Socket socket=new Socket("127.0.0.1",33333);
        OutputStream os=socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os);
        pw.write("sendMessage"+"\n");
        pw.flush();
        pw.close();
        os.close();
        socket.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
