package com.x.doctor.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@WebServlet("/receiveMessageServlet")
public class receiveMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String connection=request.getParameter("connect");
        ServerSocket serverSocket=new ServerSocket(12345);
        Socket socket=serverSocket.accept();
        while(true){
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取数据
            System.out.println(br.readLine());
            response.getWriter().write(br.readLine());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
