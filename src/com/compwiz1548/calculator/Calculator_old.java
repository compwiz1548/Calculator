package com.compwiz1548.calculator;

import java.util.*;

public class Calculator_old {

    private static OptionalDouble parseOperations (List<Operation> pemdas) {
        OptionalDouble finalProduct = OptionalDouble.of(0.0);
        for (Operation op : pemdas) {
            if (!op.getFirstNum().isPresent()) {
                op.setFirstNum(finalProduct);
            }
            try {
                if (op.isParenthesis()) {
                    finalProduct = OptionalDouble.of(finalProduct.getAsDouble() + op.process().getAsDouble());
                    System.out.println("Processed: " + op.toString());
                } else {
                    finalProduct = op.process();
                    System.out.println("Processed: " + op.toString());
                }
            } catch (Exception e) { //TODO: Specific error reporting
                System.out.println("Oopsy woopsy! You just did a fucky wucky!");
            }
        }
        return finalProduct;
    }

    public static void main (String[] args) {
        List<Operation> pemdas = new ArrayList<>();
        System.out.print("Enter an equation: ");
        Scanner in = new Scanner(System.in);

        String[] equation = in.nextLine().split("");
        System.out.println("Calculating... This won't time a while!");
        String currentNumber = "";
        Operation currentOp = new Operation();

        for (String c : equation) {

            if (c.equals(" ")) continue; //Ignore spaces

            if (c.equals("-") || c.equals(".")) { //Check for negative number or decimal
                currentNumber = c;
                currentOp.setOperator("+");
                continue;
            } else {
                try {
                    Integer.parseInt(c);
                    currentNumber += c;
                } catch (NumberFormatException e) {
                    if (currentOp.isParenthesis()) {
                        currentOp.setSecondNum(Double.parseDouble(currentNumber));
                        pemdas.add(currentOp);
                        currentOp = new Operation(null, c, null, false);
                        currentNumber = "";
                        continue;
                    }

                    switch (c) {
                        case "*":
                        case "/":
                        case "%":
                            currentOp.setFirstNum(Double.parseDouble(currentNumber));
                            currentOp.setOperator(c);
                            currentOp.setIsParenthesis(true);
                            break;
                        case "+":
                            currentOp.setOperator(c);
                            currentOp.setSecondNum(Double.parseDouble(currentNumber));
                            pemdas.add(currentOp);
                            currentOp = new Operation(null, c, null, false);
                            break;
                        case "(":
                            currentOp.setIsParenthesis(true);
                            break;
                        case ")":
                            currentOp.setSecondNum(Double.parseDouble(currentNumber));
                            pemdas.add(0,currentOp);
                            currentOp = new Operation();
                            break;
                    }

                    currentNumber = "";
                }
            }
        }

        //Add leftover currentNumber as operation to the end
        currentOp.setSecondNum(Double.parseDouble(currentNumber));
        pemdas.add(currentOp);


        System.out.println("Result: " + parseOperations(pemdas));
    }
}
