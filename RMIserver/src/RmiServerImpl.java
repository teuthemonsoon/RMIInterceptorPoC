import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiServerImpl extends UnicastRemoteObject implements RmiServerInterface {
    protected RmiServerImpl() throws RemoteException {
        super();
    }
    @Override
    public String action(String msg){
    	System.out.println(msg);
    	return msg;
    }
    public void action2(Object msg){
        System.out.println(msg.toString());
    }
}