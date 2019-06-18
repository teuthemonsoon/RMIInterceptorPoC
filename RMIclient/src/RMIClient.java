import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObjectInvocationHandler;

public class RMIClient {
    public static void main(String[] args)throws Exception{
		
		//specify the vulnerable host and port
        Registry registry= LocateRegistry.getRegistry("127.0.0.1",1099);
		
		//needs to write method abstract in RMIServerInterface before rmi lookup.
		//here needs you to specify the name of the vulnerable registry
        RmiServerInterface rmi_stuff = (RmiServerInterface) registry.lookup("msg");
		
		// this is where RMIInterceptor works.
        rmi_stuff.action("this is RMI SPEAKING"); 
    }
}