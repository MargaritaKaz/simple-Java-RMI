import java.io.Serializable;

//Task object an object containing a task to
//be processing by a remote object
//compute
interface Task extends Serializable {
    static final long serialVersionUID = 101L;
    public double getx1();
    public double getx2() ;
    public ResultType calculate();
}