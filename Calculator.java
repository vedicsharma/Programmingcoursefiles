import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {
        //initializing result variable
        double result = 0;
        //importing scanner object to get input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first operand: ");
        //assigning next input of user to double variables "operandOne" and "operandTwo"
        double operandOne = in.nextDouble();
        System.out.print("Enter second operand: ");
        double operandTwo = in.nextDouble();
        System.out.print("Calculator Menu " +
                "\n--------------- " +
                "\n1. Addition " +
                "\n2. Subtraction " +
                "\n3. Multiplication " +
                "\n4. Division "+
                "\n\nWhich operation do you want to perform?");
        String operation = in.next();
        //this boolean will check to see if the entered value is acceptable
        boolean isError = false;
        //calculate result based on entered value
        if (operation.equals("1")) {
            result = operandOne+operandTwo;
        }
        else if (operation.equals("2")) {
            result = operandOne-operandTwo;
        }
        else if (operation.equals("3")) {
            result = operandOne*operandTwo;
        }
        else if (operation.equals("4")) {
            result = operandOne/operandTwo;
        }
        else {
            System.out.println("Error: Invalid selection! Terminating program.");
            isError = true;
        }


        //if there is no error, print out value. if there is error, message already printed, and this will be ignored
        if (isError == false) {
            System.out.println("The result of the operation is "+result+". Goodbye!");
        }

    }
}
