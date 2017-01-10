package ie.gmit.sw.client.methods;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DriveableImpl implements Driveable{

	private Socket socket = null;
	private User user;
	private Scanner input;
	private ObjectOutputStream out; // output stream for any kind of java object that can travel through the socket
 	private	ObjectInputStream in; // input stream for socket communication with server
	
	protected DriveableImpl() {
		super();

	}

	private void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public Socket connect(String ip, int port){
		try {
			socket = new Socket(ip, port);
			setSocket(socket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socket;
	}

	@Override
	public void disconnect(){
		sendMessage(0); // send a tag number for a method to a server
		if(socket != null){
			try {
				System.out.println("Closing socket: " + socket);
				socket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void sendMessage(Object message) {
		try{
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(message);
			out.flush();
			System.out.println("client>" + message);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	@Override
	public Object receiveMessage() throws Exception {
		try{
			in = new ObjectInputStream(socket.getInputStream());
			return in.readObject();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		return null;
	}

	@Override
	public void registration(){
		sendMessage(2); // send a tag number for a method to a server

		input = new Scanner(System.in);
		user = new User();
		
		int randomNum = ThreadLocalRandom.current().nextInt(100000, 999998 + 1);
		// Registration Form
		System.out.println("First Name: ");
		user.setFirstName(input.nextLine());
		System.out.println("Last Name: ");
		user.setLastName(input.nextLine());
		System.out.println("Address: ");
		user.setAddress(input.nextLine());
		System.out.println("Login Name: ");
		user.setUsername(input.nextLine());
		System.out.println("Password: ");
		user.setPassword(input.nextLine());
		user.setBankAccNo(user.getFirstName().substring(0, 1) + user.getLastName().substring(0, 1) + String.valueOf(randomNum));
		
		System.out.println(user.toString());
		
		sendMessage(user); // sending user details to server via serializable object
		String outcome;
		try {
			outcome = (String) receiveMessage(); // waiting for response from server
			System.out.println(outcome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public boolean login(){
		sendMessage(1); // send a tag number for a method to a server
		
		input = new Scanner(System.in);
		user = new User();
		
		System.out.println("Enter Username: ");
		user.setUsername(input.nextLine());
		System.out.println("Enter Password: ");
		user.setPassword(input.nextLine());
		
		sendMessage(user);
		String outcome;
		try {
			outcome = (String) receiveMessage();
			System.out.println(outcome);
			return (boolean)receiveMessage(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // waiting for response from server
		
		return false;
	}



} // end of DriveableImpl class
