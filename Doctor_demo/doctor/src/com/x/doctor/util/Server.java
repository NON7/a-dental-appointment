package com.x.doctor.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket ss = new ServerSocket(10086);
		
		System.out.println("��������������������");
		
		while(true){
			Socket socket = ss.accept();
			System.out.println("�û�����ɹ�������");
			/*
			 * ÿ�����ӳɹ�һ���ͻ��ˣ�������һ���߳�Ϊ�����
			 */
			new ServerThread(socket).start();
		}
		
		
		
	}

}
