package com.example.sba.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatService {
	private ChatService instance = new ChatService();

	public ChatService getInstance() {
		if (instance == null)
			instance = new ChatService();
		return instance;
	}

	public static String getMessage(String message) {
		String send = null;
		try {
			Socket socket = new Socket("115.85.182.118", 43503);
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "ms949"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "ms949"));

			out.println(message);
			send = br.readLine();
			System.out.println(send);			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return send;
	}
}