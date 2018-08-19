package com.compwiz1548.calculator;

import java.util.Optional;

public class Lexer {
    public static Optional<OperationType> isOperator(char c) {
        switch (c) {
            case '+': return Optional.of(OperationType.ADD);
            case '-': return Optional.of(OperationType.SUB);
            case '*': return Optional.of(OperationType.MULT);
            case '/': return Optional.of(OperationType.DIV);
            default: return Optional.empty();
        }
    }

    private static Optional<Boolean> isParenthesis(char c) {
        switch (c) {
            case '(': return Optional.of(true);
            case ')': return Optional.of(false);
            default: return Optional.empty();
        }
    }

    public boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
