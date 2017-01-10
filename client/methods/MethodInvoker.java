package ie.gmit.sw.client.methods;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoker implements InvocationHandler{

	private Object returnObject = null; // object that will hold any returns from invoked methods
	private final Driveable userInterface; // object that will store locally object of type Driveable to invoke its methods
										   // any object(class) that implements Driveable interface IS-A Driveable type object. (Polymorphism)
    									   // In this program, "Driveable" is a user interface, where user press an options,
										   // and program invokes methods corresponding to an option. 
	// Constructor that takes our Proxy class with methods implementation as a parameter  
    protected MethodInvoker(Driveable ui) {
        this.userInterface = ui;
    }
    public Object invoke(Object proxy, Method method, Object[] args)
            	  throws IllegalAccessException, IllegalArgumentException,
            	  InvocationTargetException{
    	
        System.out.println("BEFORE");
        returnObject = method.invoke(userInterface, args);
        System.out.println(method.getName());
        System.out.println("AFTER");
        
        return returnObject;
    }
}
