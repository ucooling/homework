/**
 * Created by lbma on 12/3/15.
 */
public class Calculator {

    private Length length;
    private OperationType type;

    public void Calculator(Length length, OperationType type){
        this.length = length;
        this.type = type;
    }

    public Length getLength(){
        return length;
    }

    public OperationType getOperationType(){
        return type;
    }

    public int calculatorLength(Length length)
}
