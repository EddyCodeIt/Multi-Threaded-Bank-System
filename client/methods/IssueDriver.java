package ie.gmit.sw.client.methods;

import java.lang.reflect.Proxy;

public class IssueDriver extends DriveableImpl {

	private DriveableImpl di = new DriveableImpl(); // creating Object with implemented methods that are required to handle
    private MethodInvoker handler = new MethodInvoker(di); // creating Object that handles/executes methods from implementation class
    // Creating driver through which methods can be called
    private final Driveable driver = (Driveable) Proxy.newProxyInstance(Driveable.class.getClassLoader(),
            new Class[] { Driveable.class },
            handler);
    
    // Constructor that carries driver object
	public IssueDriver() {
		getDriver();
	}

	// returns driver
	private Driveable getDriver() {
		return driver;
	}
}
