import java.util.Scanner;
public class SciCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //initializing result variable
        double result = 0.0;
        double operandOne = 0.0;
        double operandTwo = 0.0;
        int numCalculations = 0;
        double totCalculations = 0.0;
        double averageCalc;
        String operation = "";
        //importing scanner object to get input
        boolean CalcRunning = true;
        boolean inputNeeded = true;
        while (CalcRunning) {
            System.out.println("Current Result: " + result);
            System.out.println(
                    "Calculator Menu" +
                            "\n--------------- " +
                            "\n0. Exit Program " +
                            "\n1. Addition " +
                            "\n2. Subtraction " +
                            "\n3. Multiplication " +
                            "\n4. Division " +
                            "\n5. Exponentiation " +
                            "\n6. Logarithm " +
                            "\n7. Display Average " +
                            "\n");
            boolean isError = true;
            while (isError) {
                System.out.println("Enter Menu Selection: ");
                operation = in.next();
                if (operation.equals("0")) {
                    isError = false;
                    CalcRunning = false;
                    inputNeeded = false;
                    System.out.println("Thanks for using this calculator. Goodbye!");

                } else if (operation.equals("1") || operation.equals("2") || operation.equals("3") || operation.equals("4") || operation.equals("5") || operation.equals("6")) {
                    isError = false;
                } else if (operation.equals("7") && numCalculations == 0) {
                    System.out.println("Error: No calculations yet to average!");
                } else if (operation.equals("7") && numCalculations != 0) {
                    averageCalc = totCalculations/numCalculations;
                    double roundOffTotal = Math.round(totCalculations * 100.0) / 100.0;
                    double roundOffAverage = Math.round(averageCalc * 100.0) / 100.0;
                    System.out.println("Sum of calculations: "+ totCalculations+
                                        "\nNumber of calculations: " + numCalculations+
                                        "\nAverage of calculations: " + roundOffAverage);

                } else {
                    System.out.println("Error: Invalid selection!");
                }
            }

            if (inputNeeded) {
                System.out.print("Enter first operand: ");
                //assigning next input of user to double variables "operandOne" and "operandTwo"
                String firstValue = in.next();
                if (firstValue.equals("RESULT")) {
                    operandOne = result;
                } else {
                    operandOne = Double.parseDouble(firstValue);
                }
                System.out.print("Enter second operand: ");
                String secondValue = in.next();
                if (secondValue.equals("RESULT")) {
                    operandTwo = result;
                } else {
                    operandTwo = Double.parseDouble(secondValue);
                }
                //this boolean will check to see if the entered value is acceptable
                //calculate result based on entered value

                if (operation.equals("0")) {
                    CalcRunning = false;
                } else if (operation.equals("1")) {
                    result = operandOne + operandTwo;
                } else if (operation.equals("2")) {
                    result = operandOne - operandTwo;
                } else if (operation.equals("3")) {
                    result = operandOne * operandTwo;
                } else if (operation.equals("4")) {
                    result = operandOne / operandTwo;
                } else if (operation.equals("5")) {
                    result = Math.pow(operandOne, operandTwo);
                } else if (operation.equals("6")) {
                    result = Math.log(operandTwo) / Math.log(operandOne);
                }

                totCalculations = totCalculations + result;
                numCalculations++;
                //if there is no error, print out value. if there is error, message already printed, and this will be ignored
                //System.out.println("The result of the operation is " + result + ". Goodbye!");
            }

        }
    }
}
