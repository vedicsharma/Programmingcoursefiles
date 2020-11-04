import java.util.Scanner;

public class ConnectFour {

    static char [][] board;
    static int row;
    static int col;
    public static boolean checkIfTie(){
        for(int x = 0; x<board.length; x++){
            for (int y=0; y<board[x].length; y++){
                if (board[x][y]=='-'){
                    return false;
                }
            }
        }
    return true;
    }


    public static void generateArray(int row1, int column1){
        String[][] result = new String[row1][column1];
        row = row1;
        col = column1;

    }
    public char[][] getBoard(){
        return board;
    }
    public static void initializeBoard(char[][] array) {
        if (!(array == null)){
            row = array.length-1;
            col = array[row].length-1;
        }
        char[][] result = new char[row][col];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                result[x][y] = '-';
            }
        }
        board = result;
    }
    public static int insertChip(char[][] array,  int col, char chipType){
        int rowNumber = 0;
        int row = array.length;
        for (int x = row-1; x>=0; x--){
            if(!(array[x][col] == '-')){
            }
            else{
                array[x][col] = chipType;
                rowNumber = x;
                break;
            }
        }
        board = array;
        return rowNumber;
    }
    public static void printBoard(char[][] array){
        for(int x = 0; x<board.length; x++){
            for (int y=0; y<board[x].length; y++){
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
        }


        public static boolean checkIfWinner(char[][] board, int col, int row, char chipType) {
            int height = board.length;
            int width = board[height-1].length;
            for (int x = 0; x < height; x++) {
                int counter = 0;
                for (int y = 0; y < width; y++) {
                    if (board[x][y]==chipType) {
                        counter++;
                    }
                    if (counter == 4) {
                        return true;
                    }
                }


            }
            for (int x = 0; x < width; x++) {
                int counter = 0;
                for (int y = 0; y < height; y++) {
                    if (board[y][x]== chipType) {
                        counter++;
                    }
                    if (counter == 4) {
                        return true;
                    }
                }


            }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like the height of the board to be?");
        int row = in.nextInt();
        System.out.println("What would you like the length of the board to be?");
        int column = in.nextInt();

        generateArray(row,column);
        initializeBoard(board);
        printBoard(board);
        System.out.println("Player 1: x " +
                "\nPlayer 2: o");





        boolean gameOver = false;
        boolean tie = false;
        int playerMove = 0;
        while (!gameOver){
            System.out.println("Player 1: Which column would you like to choose?");
            playerMove = in.nextInt();
            int col = insertChip(board, playerMove, 'x' );
            printBoard(board);
            System.out.println();
            gameOver = checkIfWinner(board, col, row, 'x');
            if (gameOver){
                System.out.println("Player 1 won the game!");
                continue;
            }
            tie = checkIfTie();
            if (tie){
                System.out.println("Draw. Nobody wins.");
                gameOver =true;
                continue;
            }
            System.out.println("Player 2: Which column would you like to choose?");
            playerMove = in.nextInt();
            col = insertChip(board,  playerMove, 'o' );
            printBoard(board);
            System.out.println();
            gameOver = checkIfWinner(board, col, row, 'o');
            if (gameOver){
                System.out.println("Player 2 won the game!");
                continue;
            }
            tie = checkIfTie();
            if (tie) {
                System.out.println("Draw. Nobody wins.");
                gameOver = true;
                continue;
            }
            System.out.println();
        }



    }
}
