public class MyTask implements Task{
    private static final long serialVersionUID = 101L;
    String operation;
    public double x1;
    public double x2;

    public double getx1() {
        return x1;
    }

    public double getx2() {
        return x2;
    }

    public ResultType calculate(){
        double zm1, zm2;
        ResultType res = new ResultType();
        zm1 = getx1();
        zm2 = getx2();
        res.result_description = "Operation "+operation;
        switch (operation) {
            case "add" -> res.result = zm1 + zm2;
            case "sub" -> res.result = zm1 - zm2;
            default -> {
                res.result = 0;
                res.result_description = "Bad operation is specified!";
                return res;
            }
        }
        return res;
    }
}