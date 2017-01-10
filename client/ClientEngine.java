package ie.gmit.sw.client;

public class ClientEngine implements Runnable {

	private UserInterface ui; // object that invokes user interface

	protected ClientEngine() {
		ui = new UserInterface();
	}
	
	// Run the thread here 
	@Override
	public void run() {
		
		ui.menu();
		
	}

}
