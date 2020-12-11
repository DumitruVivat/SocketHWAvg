package client;

import java.util.Arrays;
import java.util.List;

public class ClientApp {
	
	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(4,4,4);

		DataClient dataClient = new DataClient(ints);

		dataClient.getData("localhost", 8888);
	}
}
