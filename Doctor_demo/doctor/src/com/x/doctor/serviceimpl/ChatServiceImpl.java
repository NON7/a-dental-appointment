package com.x.doctor.serviceimpl;

import com.x.doctor.service.ChatService;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ChatServiceImpl extends Thread implements ChatService {

    @Override
    public String ClientService(String sendMessage) throws IOException {//客户端消息

        //一个socket代表一路连接
       Socket socket=new Socket();
       //连接至服务器
       socket.connect(new InetSocketAddress("127.0.0.1",2020));
       InputStream inputStream=socket.getInputStream();
       OutputStream outputStream=socket.getOutputStream();

        System.out.println(sendMessage);
       //发送数据
        byte[] outputData=sendMessage.getBytes(StandardCharsets.UTF_8);
        outputStream.write(outputData);
        System.out.println(">>"+sendMessage);

        //接收数据
        byte[] inputData=new byte[4000];
        int n=inputStream.read(inputData);
        String  inputMsg=new String(inputData,0,n, StandardCharsets.UTF_8);
        System.out.println("<<"+inputMsg);
        socket.close();

        return inputMsg;
    }

    @Override
    public String ServerService(String doctorMessage) throws IOException {//医生端：需要时刻监听来自客户端的消息
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("服务器启动，等待连接...");
        JOptionPane.showMessageDialog(null, "有客户端连接到了本机的2020端口");
        System.out.println(doctorMessage);
        while (true) {
            Socket conn = serverSocket.accept();//监听请求，阻塞等待，直到有客户端发起链接
            InputStream inputStream = conn.getInputStream();//从链接里得到输入输出流：InputStream：可以读取发来的数据；OutputStream：可以发送数据给客户端
            OutputStream outputStream = conn.getOutputStream();

            //接收数据
            byte[] inputData = new byte[4000];
            int n = inputStream.read(inputData);
            if (n <= 0) {
                conn.close();
                continue;
            }
            //发送数据
            String inputMsg = new String(inputData, 0, n, StandardCharsets.UTF_8);
            System.out.println("GOT:" + inputMsg);
            String outputMsg = "welcome!";
            byte[] outputData = outputMsg.getBytes();
            outputStream.write(outputData);
            System.out.println("ECHO:" + outputMsg + "\n");
            conn.close();
        }


        }

        public String getAddress() throws UnknownHostException{//获取本机地址

            InetAddress address = InetAddress.getLocalHost();//获取本机地址
            String name = address.getHostName();
            String ip = address.getHostAddress();
            System.out.println(name + "----------" + ip);

            return ip;
        }

}
