package com.x.doctor.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("127.0.0.1",10086);
		PrintWriter pw = new PrintWriter(
							new OutputStreamWriter(
									socket.getOutputStream()));//写操作
		BufferedReader br = new BufferedReader(
									new InputStreamReader(
											socket.getInputStream()));//读操作
		Scanner scanner = new Scanner(System.in);
		while(true){
			String arg = scanner.nextLine();
			if("exit".equals(arg.trim())){
				pw.println("exit");
				pw.flush();
				break;
			}
			pw.println(arg);
			pw.flush();
			String str = br.readLine();
			System.out.println("Client read = "+str);
		}
//		Thread.sleep(300);
		pw.close();
		br.close();
	}
}
