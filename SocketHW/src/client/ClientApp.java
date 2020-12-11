package client;

import java.util.Arrays;
import java.util.List;

public class ClientApp {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(4,4,4);

		DataClient data = new DataClient(list);

		data.getData("localhost", 8888);
	}
}
