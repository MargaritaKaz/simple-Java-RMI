import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyWorker extends UnicastRemoteObject implements Worker
{
    public MyWorker() throws RemoteException {
        super();
    }

    public ResultType calculate(Task t) throws RemoteException {
        return t.calculate();
    }

    public boolean hasClassCode(String className) throws RemoteException {
        try {
            Class.forName(className);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}