import java.util.*;

public class Calculator {

    private static Double parseOperations (List<Operation> pemdas) {
        double finalProduct = 0.0;
        for (Operation op : pemdas) {
            if (op.getFirstNum() == null) {
                op.setFirstNum(finalProduct);
            }
            try {
                if (op.getIsParenthesis()) {
                    finalProduct += op.process();
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
        boolean firstNumber = true;
        Double first = 0.0;
        int numChar = 0;

        for (String c : equation) {

            if (c.equals(" ")) continue; //Ignore spaces

            if (numChar == 0 && c.equals("-")) { //Check for negative first number
                currentNumber += "-";
                numChar++;
                continue;
            } else {
                if (c.equals(".")) { //Grumble, grumble, decimals
                    currentNumber += c;
                    continue;
                }
                try {
                    Integer.parseInt(c); //TODO: Surely there's a better way than going character by character...
                    currentNumber += c;
                } catch (NumberFormatException e) {
                    if (firstNumber) { //Keep track of the first number. Currently how order of operations works.
                        first = Double.parseDouble(currentNumber);
                        firstNumber = false;
                    } else { //Create operation since it's not the first number
                        currentOp.setSecondNum(Double.parseDouble(currentNumber));

                        if (currentOp.getOperator().equals("*") || currentOp.getOperator().equals("/")) {
                            pemdas.add(0, currentOp); //Add multiplication to the top of the list
                        } else if (c.equals("*") || c.equals("/")) { //Upcoming multiplication. Create operation with old first number, and make this the new first number.
                            Operation temp = new Operation(null, "+", first, false);
                            pemdas.add(temp);
                            first = Double.parseDouble(currentNumber);
                        } else {
                            pemdas.add(currentOp);
                        }

                        //Reset trackers
                        currentOp = new Operation();
                    }
                    switch (c) {
                        case "-":
                            currentNumber += c;
                            currentOp.setOperator("+");
                            break;
                        case "*":
                        case "+":
                        case "/":
                        case "%":
                            currentOp.setOperator(c);
                            break;
                        case "(":
                            currentOp.setIsParenthesis(true);
                            break;
                    }
                    currentNumber = "";
                }
                numChar++;
            }
        }

        //Add leftover currentNumber as operation to the end, unless it's multiplication
        currentOp.setSecondNum(Double.parseDouble(currentNumber));
        if (currentOp.getOperator().equals("*") || currentOp.getOperator().equals("/")) {
            pemdas.add(0, currentOp);
        } else {
            pemdas.add(currentOp);
        }

        //Add first number as an operation (adding to 0.0) to the beginning of list.
        pemdas.add(0, new Operation(0.0, "+", first, false));


        System.out.println("Result: " + parseOperations(pemdas));
    }
}
