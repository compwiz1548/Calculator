import java.util.*;

public class Calculator {

    private static Double parseOperations (List<Operation> pemdas) {
        double finalProduct = 0.0;
        for (Operation op : pemdas) {
            if (op.getFirstNum() == null) {
                op.setFirstNum(finalProduct);
            }
            try {
                finalProduct = op.process();
                System.out.println("Processed: " + op.toString());
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

            if (numChar == 0 && c.equals("-")) {
                currentNumber += "-";
                numChar++;
                continue;
            } else {
                if (c.equals(".")) {
                    currentNumber += c;
                    continue;
                }
                try {
                    Integer.parseInt(c);
                    currentNumber += c;
                } catch (NumberFormatException e) {
                    if (firstNumber) {
                        pemdas.add(new Operation(0.0, "+", Double.parseDouble(currentNumber)));
                        currentNumber = "";
                        firstNumber = false;
                    } else {
                        currentOp.setSecondNum(Double.parseDouble(currentNumber));

                        pemdas.add(currentOp);

                        //Reset trackers
                        currentOp = new Operation();
                        currentNumber = "";
                    }
                    switch (c) {
                        case "-":
                            currentNumber += c;
                            currentOp.setOperator("+");
                            break;
                        case "+":
                        case "*":
                        case "/":
                        case "%":
                            currentOp.setOperator(c);
                            break;
                    }
                }
            }
        }

        currentOp.setSecondNum(Double.parseDouble(currentNumber));
        pemdas.add(currentOp);

        System.out.println("Result: " + parseOperations(pemdas));
    }
}
