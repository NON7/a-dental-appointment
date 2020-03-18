package com.x.doctor.serviceimpl;

import com.x.doctor.dao.socketDao;
import com.x.doctor.daoimpl.socketDaoImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientService extends socketDaoImpl {
    /**
     * 客户端
     * 1、创建Socket，指定连接的服务器的地址和端口号
     * 2、建立连接后，通过输出流向服务器端发送请求信息
     * 3、通过输入流获取服务器相应的信息
     * 4、关闭相应资源
     */
    String sendMessage = null;
    String info = null;

    public clientService(String sendMessage) {
        this.sendMessage = sendMessage;
    }


    public void sendMessage() {

    }


}

