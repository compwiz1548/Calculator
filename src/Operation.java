import java.util.OptionalDouble;


public class Operation {

    private OptionalDouble firstNum, secondNum;
    private String operator;
    private boolean isParenthesis;

    public Operation () {
        this.firstNum = OptionalDouble.empty();
        this.operator = "";
        this.secondNum = OptionalDouble.empty();
        this.isParenthesis = false;
    }

    public Operation (OptionalDouble firstNum, String operator, OptionalDouble secondNum, boolean isParenthesis) {
        this.firstNum = firstNum;
        this.operator = operator;
        this.secondNum = secondNum;
        this.isParenthesis = isParenthesis;
    }

    public boolean isParenthesis () {
        return isParenthesis;
    }

    public void setIsParenthesis (boolean isParenthesis) {
        this.isParenthesis = isParenthesis;
    }

    public double getFirstNum () {
        return firstNum.getAsDouble();
    }

    public void setFirstNum (Double firstNum) {
        this.firstNum = OptionalDouble.of(firstNum);
    }

    public OptionalDouble getSecondNum () {
        return secondNum;
    }

    public void setSecondNum (OptionalDouble secondNum) {
        this.secondNum = secondNum;
    }

    public String getOperator () {
        return operator;
    }

    public void setOperator (String operator) {
        this.operator = operator;
    }

    @Override
    public String toString () {
        return this.isParenthesis ? "(" + this.firstNum + this.operator + this.secondNum + ")" : this.firstNum + this.operator + this.secondNum;
    }

    public OptionalDouble process () {
        switch (operator) {
            case "+":
                return OptionalDouble.of(firstNum.getAsDouble() + secondNum.getAsDouble());
            case "/":
                return OptionalDouble.of(firstNum.getAsDouble() / secondNum.getAsDouble());
            case "*":
                return OptionalDouble.of(firstNum.getAsDouble() * secondNum.getAsDouble());
            case "%":
                return OptionalDouble.of(firstNum.getAsDouble() % secondNum.getAsDouble());
            default:
                return OptionalDouble.empty();
        }
    }
}
