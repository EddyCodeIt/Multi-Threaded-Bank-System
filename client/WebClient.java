package ie.gmit.sw.client;

public class WebClient {

	protected WebClient() {
		
		
		Thread server = new Thread(new ClientEngine(), "Client Request Engine"); // Creating thread to assign work described in ClientEngine class
		server.setPriority(Thread.MAX_PRIORITY); //Ask the Thread Scheduler to run this thread as a priority
		server.start(); // Start the thread
	}
	
}
