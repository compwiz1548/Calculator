package com.compwiz1548.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main (String[] args) {
        List<Operation> pemdas = new ArrayList<>();
        System.out.print("Enter an equation: ");
        Scanner in = new Scanner(System.in);

        Character[] equation =
                in.nextLine().chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        System.out.println("Calculating... This won't time a while!");

        List<Operation> tokenList = Lexer.parseEquation(equation);

        for (Operation op : tokenList) {

            System.out.println("Result: " + op.process());
        }
    }
}
