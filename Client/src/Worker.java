import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Worker extends Remote {
    public ResultType calculate(Task t) throws RemoteException;
    boolean hasClassCode(String className) throws RemoteException;
    static void storeClassCode(String className, byte[] classByteCode) throws RemoteException {
        java.io.FileOutputStream out;
        try {
            out = new java.io.FileOutputStream(className + ".class");
            out.write(classByteCode);
            out.close();
        } catch (Exception e) {
            System.out.println("I/O Error for class: " + className);
            e.printStackTrace();
        }
    }
}
