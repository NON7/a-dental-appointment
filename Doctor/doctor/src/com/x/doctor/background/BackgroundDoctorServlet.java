package com.x.doctor.background;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

@WebServlet("/BackgroundDoctorServlet")

public class BackgroundDoctorServlet extends HttpServlet {
    /**
     * 服务端发送与接收请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String doctorMessage = request.getParameter("sendMessage");

        Socket socket=new Socket("127.0.0.1",12345);

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);

        pw.write(doctorMessage+"\n");
        pw.flush();
        //5、关闭资源
        pw.close();
        os.close();
       socket.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}