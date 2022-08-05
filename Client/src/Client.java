import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);
            // Looking up the registry for the remote object
            Worker stub = (Worker) registry.lookup("Worker");
            MyTask inObj = new MyTask();

            String className = inObj.getClass().getName();//??
            boolean isOK = stub.hasClassCode(className);
            if (! isOK) {
                java.io.File f = new java.io.File(className + ".class");
                byte[] t = new byte[(int) f.length()];
                java.io.FileInputStream in = new java.io.FileInputStream(className + ".class");
                in.read(t);
                in.close();
                Worker.storeClassCode(className, t);
            }

            ResultType resObj;
            inObj.x1 = 3;
            inObj.x2 = 2;
            inObj.operation = "add";
            resObj = stub.calculate(inObj);
            System.out.println(resObj.result_description);
            System.out.println("Result: " + resObj.result);

            System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}