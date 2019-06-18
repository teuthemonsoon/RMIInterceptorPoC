import java.rmi.RemoteException;

public interface RmiServerInterface {
    public String action(String msg) throws RemoteException;
    public void action2(Object msg) throws RemoteException;
}
