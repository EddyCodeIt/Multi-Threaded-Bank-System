package ie.gmit.sw.client.methods;

import java.net.Socket;

public interface Driveable {
	
	Socket connect(String ip, int port) throws Exception;
	void disconnect() throws Exception;
	void registration() throws Exception;
	boolean login() throws Exception;
	void sendMessage(Object message) throws Exception;
	Object receiveMessage() throws Exception;
	
	
}
