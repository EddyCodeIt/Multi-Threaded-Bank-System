package ie.gmit.sw.client.methods;

public class User implements java.io.Serializable{

	private static final long serialVersionUID = 777L;
	private String bankAccNo;
	private String firstName;
	private String lastName;
	private String address;
	private String username;
	private String password;


	protected User() {
		// TODO Auto-generated constructor stub
	}


	protected String getBankAccNo() {
		return bankAccNo;
	}
	protected void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	protected String getFirstName() {
		return firstName;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	protected String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	protected String getAddress() {
		return address;
	}
	protected void setAddress(String address) {
		this.address = address;
	}
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		
		return "User:\n[Bank A/C: " + bankAccNo + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
					   "\nAddress: " + address + "\nUsername: " + username + "\nPassword: " + password + "]";
	}
}