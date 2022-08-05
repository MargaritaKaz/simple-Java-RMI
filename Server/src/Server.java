import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends MyWorker {
    public Server() throws RemoteException {
    }
    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            MyWorker obj = new MyWorker();
            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Worker", obj);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
} 