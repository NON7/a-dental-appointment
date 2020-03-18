package com.x.doctor.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServerThread extends Thread {

	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			pw = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));

			while (true) {
				String string = br.readLine();
				System.out.println("Server read = " + string);
				System.out.println("Server�������룺 ");
				Scanner scanner = new Scanner(System.in);
				String str = scanner.next();
				
				pw.println(str
						+ "��"
						+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
								.format(new Date()) + "��");
				pw.flush();
				
				if ("exit".equals(str)) {
					break;
				}
			}

			// Thread.sleep(300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
}
