package com.x.doctor.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DoctorSocket {
    public void doctorSockets() throws IOException {

        ServerSocket serverSocket=new ServerSocket(2020);
        System.out.println("服务器启动，等待连接...");
       // System.out.println(doctorMessage);
        while(true)
        {
            //监听请求，阻塞等待，直到有客户端发起连接...
            Socket conn = serverSocket.accept();

            //从连接里得到输入输出流
            //InputStream:可以读取客户端发来的数据
            //OutputStream:可以发送数据给客户端
            InputStream inputStream = conn.getInputStream();
            OutputStream outputStream = conn.getOutputStream();

            //接收数据
            byte[] inputData = new byte[4000];
            int n = inputStream.read(inputData);
            if(n <= 0)
            {
                conn.close();
                continue;
            }
            //发送数据
            String inputMsg = new String(inputData , 0 , n , StandardCharsets.UTF_8);
            System.out.println("GOT:" + inputMsg);
            String outputMsg = "Welcome!";
            byte[] ouputData = outputMsg.getBytes();
            outputStream.write(ouputData);
            System.out.println("ECHO:" + outputMsg + "\n");

            //关闭连接
            conn.close();

        }
    }
}
