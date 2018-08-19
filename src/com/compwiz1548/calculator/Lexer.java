package com.compwiz1548.calculator;

import java.util.*;

public class Lexer {
    private static Optional<OperationType> isOperator(char c) {
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

    private static boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    public static List<Operation> parseEquation(Character[] equation) {
        List<Operation> opsList = new ArrayList<>();

        StringBuilder currentNumber = new StringBuilder();

        Operation currentOp;

        ListIterator<Character> iterator = Arrays.asList(equation).listIterator();

        char c = iterator.next();

       

        return opsList;
    }
}
