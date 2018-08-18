public class Operation {

    private Double firstNum, secondNum;
    private String operator;

    public Operation () {
        this.firstNum = null;
        this.operator = null;
        this.secondNum = null;
    }

    public Operation (Double firstNum, String operator, Double secondNum) {
        this.firstNum = firstNum;
        this.operator = operator;
        this.secondNum = secondNum;
    }

    public Double getFirstNum () {
        return firstNum;
    }

    public void setFirstNum (Double firstNum) {
        this.firstNum = firstNum;
    }

    public Double getSecondNum () {
        return secondNum;
    }

    public void setSecondNum (Double secondNum) {
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
        return this.firstNum + this.operator + this.secondNum;
    }

    public Double process () {
        switch (operator) {
            case "+":
                return firstNum + secondNum;
            case "/":
                return firstNum / secondNum;
            case "*":
                return firstNum * secondNum;
            case "%":
                return firstNum % secondNum;
            default:
                return null;
        }
    }
}