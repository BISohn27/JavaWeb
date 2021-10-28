package naverAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatService {
	private Socket socket;
	
	public ChatService(String host, int port) throws Exception {
		socket = new Socket(host,port);
	}
	
	public void close() throws IOException{
		socket.close();
	}
	
	public void echo() throws IOException {
		System.setProperty("file.encoding","UTF-8");
//		OutputStream os = socket.getOutputStream();
//		InputStream is = socket.getInputStream();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		BufferedReader con = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		while(true) {
			String msg = con.readLine();
			out.println(msg);
			if(msg.equals("bye"))
				break;
			System.out.println(br.readLine());
		}
	}
	public static void main(String[] args) {
		String id = "s";
		String pwd = "s";
		
		LoginService.getInstance().login(id, pwd);

		try {
			ChatService ec;
			System.out.println("메세지를 입력하세요");
			if(args.length >0) {
				ec = new ChatService(args[0],10000);
			}else {
				ec = new ChatService("115.85.182.118",43503);
			}
			ec.echo();
			ec.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
