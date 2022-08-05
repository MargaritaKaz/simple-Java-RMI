import java.io.Serializable;

//class which will be the type of calculation
//result returned by the remote object
public class ResultType implements Serializable {
    private static final long serialVersionUID = 102L;
    String result_description;
    public double result;
}