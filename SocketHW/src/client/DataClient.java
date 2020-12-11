package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

public class DataClient {
	
	private List<Integer> data;
	
	public DataClient(List<Integer> data) {
		this.data = data;
	}
	public List<Integer> getData(String host, int port) {
		
		Socket socket;
		
		try {
			
			System.out.println( "CLIENT STARTING" );
			
			 socket = new Socket(host,port);
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			dout.writeUTF(dataToString());
			dout.flush();

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			dataInputStream.readUTF();
			
			dout.close();
		
		System.out.println( "CLIENT ENDING" );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	private String dataToString() {
		StringBuilder strbul  = new StringBuilder();
	    Iterator<Integer> iter = this.data.iterator();
	    while(iter.hasNext())
	    {
	      strbul.append(iter.next());
	      if(iter.hasNext()){
	      strbul.append(",");
	      }
	    }
	   return strbul.toString();
	}
}
