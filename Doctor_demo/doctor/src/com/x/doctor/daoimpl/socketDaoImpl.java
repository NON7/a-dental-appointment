package com.x.doctor.daoimpl;

import com.x.doctor.dao.socketDao;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class socketDaoImpl extends Thread implements socketDao {
    public Socket socket;
    public BufferedReader br;
    public PrintWriter pw;
    public BufferedWriter bw;
    public ServerSocket serverSocket;
    public InputStream is;
    public InputStreamReader isr;
    public OutputStream os;
    @Override
    public void closeSocket() throws IOException {
        bw.close();
        pw.close();
        socket.close();
        System.out.println(socket.getInetAddress().getHostAddress() + "has disconnected");
    }

    @Override
    public void closeSockets() throws IOException {
        //5、关闭资源
        pw.close();
        os.close();
        br.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
