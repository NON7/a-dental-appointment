package com.x.doctor.servlet;

import com.x.doctor.dao.socketDao;
import com.x.doctor.daoimpl.socketDaoImpl;
import com.x.doctor.serviceimpl.ServerService;
import com.x.doctor.serviceimpl.clientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.Socket;

@WebServlet("/ChatClientServlet")
public class ChatClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*控制层
        1、统一字符集
        2、接收来自view界面的值：此处为信息
        3、将这个消息传递给service层的线程中——>转到service层中
        4、开启这个线程
         */
        /**
         * 客户端发送与接收请求
         */
        String info = null;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sendMessage=request.getParameter("sendMessage") ;

        //客户端
        //1、创建客户端Socket，指定服务器地址和端口
        Socket socket = new Socket("127.0.0.1", 33333);
        //2、获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
        pw.write(sendMessage);
        pw.flush();
        socket.shutdownOutput();
        //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        while ((info = br.readLine()) != null) {
            System.out.println("我是客户端，服务器说：" + info);
            response.getWriter().write(info);
            //out.close();

        }
        //pw.print(info);
        //4、关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}