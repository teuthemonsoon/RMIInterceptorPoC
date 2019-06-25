import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) throws Exception{
        RmiServerImpl rmiserver=new RmiServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("msg",rmiserver);
        System.out.println("RMI Service Start");
    }
}
