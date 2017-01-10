package ie.gmit.sw.client;

import java.util.Scanner;

import ie.gmit.sw.client.methods.Driveable;
import ie.gmit.sw.client.methods.IssueDriver;

public class UserInterface {
	
	private int option;
	private Scanner input;
	private Driveable driver; // methods driver object 
	private String ip;
	private int port;
	private boolean authenticated = false; // Variable to verify authentication and give corresponding authorization rights.
										   

	protected UserInterface() {
		driver = new IssueDriver(); // creating new instance of a methods driver i.e., user options in UI
	}

	protected void menu() {

        input = new Scanner(System.in);
        
        /***************************************************/
/*        System.out.println("Server IP Address: ");
        ip = input.nextLine();
        System.out.println("Server Port Number: ");
        port = input.nextInt();*/
        
        
        try {			 /*	 ip 	    port*/
        	driver.connect("localhost", 2017); // Method that connects to a server. Excepts parameters with ip address and port number.
		} catch (Exception connect) {
			connect.printStackTrace();
		}
        

        do{
        	
        	if(authenticated == false){
        		
        		System.out.println("Choose from these choices");
                System.out.println("-------------------------\n");
                System.out.println("1 - Login");
                System.out.println("2 - Register");
                System.out.println("0 - Quit");
                
                option = input.nextInt();
            	switch(option){
            		case 1: System.out.println("Login");
            				try {
            					authenticated = driver.login(); // Method sends an object with user input for login 
            													// and returns status response from the server.
							} catch (Exception login) {
								// TODO Auto-generated catch block
								login.printStackTrace();
							}
            				
            				break;
            		case 2: System.out.println("Registration");
            				System.out.println();
							try {
								driver.registration(); // Method sends an object with registration data to the server. 
													   // Receives status message from server.
							} catch (Exception registration) {
								// TODO Auto-generated catch block
								registration.printStackTrace();
							}
            				break;
            		case 0: System.out.println("Quit");
		            		try {
		    					driver.disconnect(); // Method closes connection with server.
		    				} catch (Exception discon){
		    					discon.printStackTrace();
		    				}
							break;
            	}
        	}
        	else if(authenticated == true){
        		
        		System.out.println("Choose from these choices");
                System.out.println("-------------------------\n");
                System.out.println("1 - View Customer Details");
                System.out.println("2 - Change Customer Details");
                System.out.println("3 - Lodgement");
                System.out.println("4 - Withdrawal");
                System.out.println("5 - Last 10 transactions");
                System.out.println("0 - Quit");
                
                option = input.nextInt();
            	switch(option){
            		case 1: 
            				System.out.println("View Customer Details");
            				break;
            		case 2: System.out.println("Change Customer Details");
            				break;
            		case 3: System.out.println("Lodgement");
    						break;
            		case 4: System.out.println("Withdrawal");
    						break;
            		case 5: System.out.println("Last 10 transactions");
    						break;
            		case 0: System.out.println("Quit");
		            		try {
		    					driver.disconnect();
		    				} catch (Exception e){
		    					e.printStackTrace();
		    				}
    						break;
            	}
        	}

        }while(option != 0);            
    }
}
