package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
	
	public DataServer() {
	}
	
	public void startServer(int port) {
		
		System.out.println("SERVER STARTING");

		try {
			ServerSocket serverSocket = new ServerSocket(port);

			System.out.println("SERVER >> accepting client");
			Socket client = serverSocket.accept();

			DataInputStream dis = new DataInputStream(client.getInputStream()); 
			String data = dis.readUTF();
			System.out.println("SERVER >> client sent:  "+data);
			
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			String m = getAvg(data);
			
			System.out.println( "SERVER >> : " + m);
			dos.writeUTF(m);

			serverSocket.close();
			System.out.println("SERVER ENDING");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private String getAvg(String data) {

		int sum = 0;
		int length = data.split(",").length;
		for (String num : data.split(",") ) {
			sum += Integer.parseInt(num);
		}

		return "The average is " + sum / length;
	}

}
