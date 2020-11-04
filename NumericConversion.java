import java.util.Scanner;
public class NumericConversion {
    public static short hexCharDecode(char digit){
        char c = digit;
        int a = 0;
        if (c==0){

        }
        if (c == '1' || c == '2'|| c == '3'|| c == '4'|| c == '5'|| c == '6'|| c == '7'|| c == '8'|| c == '9'){
            a = Integer.parseInt(String.valueOf(c));
        }
        //switch statements convert each letter
        else{
            switch (c){
                case 'a':
                case 'A':
                    a = 10;
                    break;
                case 'b':
                case 'B':
                    a = 11;
                    break;
                case 'c':
                case 'C':
                    a = 12;
                    break;
                case 'd':
                case 'D':
                    a = 13;
                    break;
                case 'e':
                case 'E':
                    a = 14;
                    break;
                case 'f':
                case 'F':
                    a = 15;
                    break;

            }


        }
        //convert to short
        short y = (short)a;
        return y;
    }
    public static long hexStringDecode(String hex) {
        int letterConverter = 0;
        double total = 0;
        //removes 0x or 0b from beginning
        if (hex.substring(0,2).equalsIgnoreCase("0x")||hex.substring(0,2).equalsIgnoreCase("0b") ){
            hex = hex.substring(2,hex.length());
        }
        for (int i = 0; i < hex.length(); i++){
            char c = hex.charAt(i);
            int a;
            int x = (hex.length()-1-i);
            //every letter put through hexchardecode
            a = hexCharDecode(c);
            double f = (a*(Math.pow(16, x)));
            int g = (int)f;
            total = f+total;
            letterConverter++;

        }

        long finalTotal = (long)total;
        return finalTotal;
    }

    public static short binaryStringDecode(String binary) {
        int letterConverter = 0;
        double total = 0;
        //removes 0x or 0b from beginning
        if (binary.substring(0,2).equalsIgnoreCase("0x")||binary.substring(0,2).equalsIgnoreCase("0b") ){
            binary = binary.substring(2,binary.length());
        }
        //convert binary. Since only 1 and 2, do not need seperate class to convert each letter
        for (int i = 0; i < binary.length(); i++){
            char c = binary.charAt(i);
            int a = Integer.parseInt(String.valueOf(c));
            int x = (binary.length()-1-i);
            double f = (a*(Math.pow(2, x)));
            int g = (int)f;
            total = f+total;
            letterConverter++;

        }

        short finalTotal = (short)total;
        return finalTotal;
    }



    public static String binaryToHex (String    binary){

        String hex="";
        //makes sure number of characters is divisible by 4
        while (!(binary.length()%4==0)){
            binary = 0+binary;
        }
        //each 4 letters are converted to hex
        for (int i = 0; i <= binary.length(); i++){
            if (i%4==0&&!(i==0)){
                String fourbit = binary.substring(i-4,i);
                if (fourbit.equalsIgnoreCase("0000")){
                    hex = hex+0;
                }

                else if (fourbit.equalsIgnoreCase("0001")){
                    hex = hex+1;
                }
                else if (fourbit.equalsIgnoreCase("0010")){
                    hex = hex+2;
                }
                else if (fourbit.equalsIgnoreCase("0011")){
                    hex = hex+3;
                }
                else if (fourbit.equalsIgnoreCase("0100")){
                    hex = hex+4;
                }
                else if (fourbit.equalsIgnoreCase("0101")){
                    hex = hex+5;
                }
                else if (fourbit.equalsIgnoreCase("0110")){
                    hex = hex+6;
                }
                else if (fourbit.equalsIgnoreCase("0111")){
                    hex = hex+7;
                }
                else if (fourbit.equalsIgnoreCase("1000")){
                    hex = hex+8;
                }
                else if (fourbit.equalsIgnoreCase("1001")){
                    hex = hex+9;
                }
                else if (fourbit.equalsIgnoreCase("1010")){
                    hex = hex+"A";
                }
                else if (fourbit.equalsIgnoreCase("1011")){
                    hex = hex+"B";
                }
                else if (fourbit.equalsIgnoreCase("1100")){
                    hex = hex+"C";
                }
                else if (fourbit.equalsIgnoreCase("1101")){
                    hex = hex+"D";
                }
                else if (fourbit.equalsIgnoreCase("1110")){
                    hex = hex+"E";
                }
                else if (fourbit.equalsIgnoreCase("1111")){
                    hex = hex+"F";
                }
            }
        }
        return hex;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean ProgramRunning = true;
        String operation = "";
        String value = "";
        long result;
        //print menu with while loop
        while (ProgramRunning) {
            System.out.println("Decoding Menu ------------- " +
                    "\n1. Decode hexadecimal " +
                    "\n2. Decode binary " +
                    "\n3. Convert binary to hexadecimal " +
                    "\n4. Quit ");
            System.out.println("Please enter an option: ");
            operation = in.next();
            if (!operation.equals("4")){
                System.out.println("Please enter the numeric string to convert:");
                value = in.next();
            }

            //for each case, prints needed output
            switch (operation) {
                case "4":
                    ProgramRunning = false;
                    System.out.println("Goodbye!");
                    break;
                case "1":
                    result = hexStringDecode(value);
                    System.out.println("Result: "+result);
                    break;
                case "2":
                    result = binaryStringDecode(value);
                    System.out.println("Result: "+result);
                    break;
                case "3":
                    String result2 = binaryToHex(value);
                    System.out.println("Result: "+result2);
                    break;
            }

        }
    }
}
