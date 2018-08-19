public class Operation {

    private Double firstNum, secondNum;
    private String operator;
    private boolean isParenthesis;

    public Operation () {
        this.firstNum = null;
        this.operator = null;
        this.secondNum = null;
        this.isParenthesis = false;
    }

    public Operation (Double firstNum, String operator, Double secondNum, boolean isParenthesis) {
        this.firstNum = firstNum;
        this.operator = operator;
        this.secondNum = secondNum;
        this.isParenthesis = isParenthesis;
    }

    public boolean isParenthesis () {
        return isParenthesis;
    }

    public void setIsParenthesis (Boolean isParenthesis) {
        this.isParenthesis = isParenthesis;
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
        return this.isParenthesis ? "(" + this.firstNum + this.operator + this.secondNum + ")" : this.firstNum + this.operator + this.secondNum;
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
