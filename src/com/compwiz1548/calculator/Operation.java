package com.compwiz1548.calculator;

import java.util.Optional;
import java.util.OptionalDouble;

public class Operation {

    private OptionalDouble firstNum, secondNum;
    private Optional<OperationType> operator;
    private boolean isParenthesis;

    public Operation () {
        this.firstNum = OptionalDouble.empty();
    }

    public Operation (OptionalDouble firstNum, Optional<OperationType> operator, OptionalDouble secondNum, boolean isParenthesis) {
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

    public OptionalDouble getFirstNum () {
        return firstNum;
    }

    public void setFirstNum (OptionalDouble firstNum) {
        this.firstNum = firstNum;
    }

    public OptionalDouble getSecondNum () {
        return secondNum;
    }

    public void setSecondNum (OptionalDouble secondNum) {
        this.secondNum = secondNum;
    }

    public Optional<OperationType> getOperator () {
        return operator;
    }

    public void setOperator (Optional<OperationType> operator) {
        this.operator = operator;
    }

    @Override
    public String toString () {
        return this.isParenthesis ? "(" + this.firstNum.toString() + this.operator + this.secondNum.toString() + ")" : this.firstNum.toString() + this.operator + this.secondNum.toString();
    }

    public OptionalDouble process () {
        if (!firstNum.isPresent() || !secondNum.isPresent()) {
            System.out.println("Oopsy woopsy! You just did a fucky wucky!");
        } else {
            switch (operator) {
                case ADD:
                    return OptionalDouble.of(firstNum.getAsDouble() + secondNum.getAsDouble());
                case DIV:
                    return OptionalDouble.of(firstNum.getAsDouble() / secondNum.getAsDouble());
                case MULT:
                    return OptionalDouble.of(firstNum.getAsDouble() * secondNum.getAsDouble());
                case MOD:
                    return OptionalDouble.of(firstNum.getAsDouble() % secondNum.getAsDouble());
            }
        }
        return OptionalDouble.empty();
    }
}
