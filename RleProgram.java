import java.util.Arrays;
import java.util.Scanner;

public class RleProgram {

    public static String charToHex(byte data) {
        String a = "";
        if (data == 0 || data == 1 || data == 2 || data == 3 || data == 4 || data == 5 || data == 6 || data == 7 || data == 8 || data == 9) {
            a = String.valueOf(data);
        } else {
            switch (data) {
                case 10:
                    a = "a";
                    break;
                case 11:
                    a = "b";
                    break;
                case 12:
                    a = "c";
                    break;
                case 13:
                    a = "d";
                    break;
                case 14:
                    a = "e";
                    break;
                case 15:
                    a = "f";
                    break;
            }
        }
        return a;
    }
    public static String toHexString(byte[] data) {
        String result = "";
        for (int x = 0; x < data.length; x++) {
            String a = "";
            if (data[x] == 0 ||data[x] == 1 || data[x] == 2|| data[x] == 3|| data[x] == 4|| data[x] == 5|| data[x] == 6|| data[x] == 7|| data[x] == 8|| data[x] == 9) {
                a = String.valueOf(data[x]);
            }
            else {
                switch (data[x]) {
                    case 10:
                        a = "a";
                        break;
                    case 11:
                        a = "b";
                        break;
                    case 12:
                        a = "c";
                        break;
                    case 13:
                        a = "d";
                        break;
                    case 14:
                        a = "e";
                        break;
                    case 15:
                        a = "f";
                        break;
                }
            }
            result = result + a;

        }
        return result;
    }

    public static int countRuns(byte[]flatData){
        int counter = 1;
        int runlength = 1;
        for (int x=1; x < flatData.length; x++){
            if (!(flatData[x] == flatData[x-1])){
                counter ++;
                runlength = 1;
            }
            else {
                runlength ++;
                if (runlength>15){
                    counter ++;
                    runlength = 1;
                }
            }
        }
        return counter;
    }

    public static byte[] encodeRle(byte[]flatData) {
        int a = countRuns(flatData);
        byte[] result = new byte[a * 2];
        int arraylength = 0;
        int runlength = 1;
        for (int x = 1; x < flatData.length; x++) {
            if (!(flatData[x] == flatData[x - 1])) {
                result[arraylength] = (byte) runlength;
                result[arraylength + 1] = flatData[x - 1];
                arraylength = arraylength + 2;
                runlength = 1;
                if (x + 1 == flatData.length) {
                    result[arraylength] = (byte) runlength;
                    result[arraylength + 1] = flatData[x];
                    arraylength = arraylength + 2;
                    runlength = 1;
                }
            } else {

                runlength++;
                if (runlength > 15) {
                    result[arraylength] = (byte) (runlength - 1);
                    result[arraylength + 1] = flatData[x - 1];
                    arraylength = arraylength + 2;
                    runlength = 1;

                }
                if (x + 1 == flatData.length) {
                    result[arraylength] = (byte) runlength;
                    result[arraylength + 1] = flatData[x];
                    arraylength = arraylength + 2;
                    runlength = 1;
                }

            }

        }
        return result;
    }


    public static int getDecodedLength(byte[]rleData){
        int result = 0;
        for (int x = 0; x< rleData.length; x=x+2){
            result= result + rleData[x];
        }
        return result;
    }


    public static byte[] decodeRle(byte[] rleData){
        int a = getDecodedLength(rleData);
        int listPlace = 0;
        byte[] result = new byte[a];
        for (int b = 0; b< rleData.length; b=b+2){
            for (int c = 0; c<rleData[b]; c++){
                result[listPlace] = rleData[b+1];
                listPlace ++;
            }
        }
        return result;
    }


    public static int dataStringCharDecode(char digit){
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
        return a;
    }

    public static byte[] stringToData(String dataString){
        byte [] result = new byte[dataString.length()];
            for (int i = 0; i < dataString.length(); i++){
                char c = dataString.charAt(i);
                int a = dataStringCharDecode(c);
                result[i] = (byte) a;


            }
            return result;
    }
    public static String toRleString(byte[] rleData){
        String result = "";
        for(int x=0; x<rleData.length; x++){
            if (x%2 == 0){
                result = result + rleData[x];
            }
            else{
                String part =charToHex(rleData[x]);
                result = result + part;
                if (!(x== rleData.length-1)){
                    result = result + ":";
                }
            }
        }
        return result;


    }

    public static byte[] stringToRle(String rleString){
        int counter = 0;
        int lengthCounter = 0;
        int arrayPosition = 0;
        for(int x=0; x<rleString.length(); x++){
            if (rleString.charAt(x) == ':'){
                lengthCounter ++;
            }
        }


        byte [] result = new byte[2*(lengthCounter+1)];
        for(int x=0; x<rleString.length(); x++){

            if (rleString.charAt(x) == ':'){
                if(counter == 2){
                    result [arrayPosition] = (byte)Integer.parseInt(rleString.substring(x-2, x-1));
                    arrayPosition ++;
                    int b = dataStringCharDecode(rleString.charAt(x-1));
                    result [arrayPosition] = (byte)b;
                    arrayPosition ++;

                }
                else if(counter == 3){
                     result [arrayPosition] = (byte)Integer.parseInt(rleString.substring(x-3, x-1));
                    arrayPosition ++;
                    int b = dataStringCharDecode(rleString.charAt(x-1));
                    result [arrayPosition] = (byte)b;
                    arrayPosition ++;

                }

                    counter = 0;
                }

             else{
                counter++;
                if (x == rleString.length()-1){
                    if(counter == 2){
                        result [arrayPosition] = (byte)Integer.parseInt(rleString.substring(x-1, x));
                        arrayPosition ++;
                        int b = dataStringCharDecode(rleString.charAt(x));
                        result [arrayPosition] = (byte)b;
                        arrayPosition ++;

                    }
                    else if(counter == 3){
                        result [arrayPosition] = (byte)Integer.parseInt(rleString.substring(x-2, x));
                        arrayPosition ++;
                        int b = dataStringCharDecode(rleString.charAt(x));
                        result [arrayPosition] = (byte)b;
                        arrayPosition ++;

                    }
                }
            }

            }
        return result;
        }

    public static void main(String[] args) {
        System.out.println("Welcome to the RLE image encoder!");
        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        byte[] imageData = null;
        Scanner in = new Scanner(System.in);
        //menu here

        byte [] a = stringToRle("28:10:6B:10:10B:10:2B:10:12B:10:2B:10:5B:20:11B:10:6B:10");
        String ab = toRleString(new byte[] { 15, 15, 6, 4});
           // System.out.println(Arrays.toString(a));

        boolean ProgramRunning = true;
        while (ProgramRunning) {
            System.out.println("RLE Menu" +
                    "\n--------" +
                    "\n0. Exit"+
                    "\n1. Load File" +
                    "\n2. Load Test Image" +
                    "\n3. Read RLE String" +
                    "\n4. Read RLE Hex String" +
                    "\n5. Read Data Hex String" +
                    "\n6. Display Image" +
                    "\n7. Display RLE String" +
                    "\n8. Display Hex RLE Data" +
                    "\n9. Display Hex Flat Data" +
                    "\n\nSelect a Menu Option:");

            String menuOption = in.next();
           String input;
            switch (menuOption){
                case "0":
                    ProgramRunning = false;
                    break;
                case "1":
                    System.out.println("Enter name of file to load: ");
                    String fileName = in.next();
                    imageData = ConsoleGfx.loadFile(fileName);
                    break;
                case "2":
                    imageData = ConsoleGfx.testImage;
                    System.out.println("Test image data loaded.");
                    break;
                case "3":
                    System.out.print("Enter an RLE string to be decoded:");
                    input = in.next();
                    imageData = stringToRle(input);
                    //System.out.println("Test image data loaded.");
                    break;
                case "4":
                    System.out.print("Enter the hex string holding RLE data:");
                    input = in.next();
                    imageData = stringToData(input);
                    //System.out.println("Test image data loaded.");
                    break;
                case "5":
                    System.out.print("Enter the hex string holding flat data:");
                    input = in.next();
                    imageData = encodeRle(stringToData(input));
                    //System.out.println("Test image data loaded.");
                    break;
                case "6":
                    System.out.println("Displaying image...");
                    if (imageData == null){
                        System.out.println("(no data)");
                    }
                    else {
                        ConsoleGfx.displayImage(imageData);
                    }
                    break;
                case "7":
                    System.out.print("RLE representation: ");
                    if (imageData == null){
                        System.out.println("(no data)");
                    }
                    else {
                        System.out.println(toRleString(imageData));
                    }

                    break;
                case "8":
                    System.out.print("RLE hex values: ");
                    if (imageData == null){
                        System.out.println("(no data)");
                    }
                    else {
                        System.out.println(toHexString(imageData));
                    }

                    break;
                case "9":
                    System.out.print("Flat hex values: ");
                    if (imageData == null){
                        System.out.println("(no data)");
                    }
                    else {
                        System.out.println(toHexString(decodeRle(imageData)));
                    }


                    break;
            }


        }
    }
}
