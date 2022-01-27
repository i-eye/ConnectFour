package com.WinstonStatue;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // initialization variables
        Nathan.digitSum(2);

        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Number of Columns: ");
        int columns = sc.nextInt();
        char turn = 'X';
        char[][] gameBoard = new char[rows][columns];
        int target;
        int turnNumber=1;

        for(char[] chars: gameBoard){
            Arrays.fill(chars, '\u0020');
        }

        System.out.println("Hey, if you don't win this match of Connect Four i'm gonna replace all the 1997 Ford Fiestas in your house with Nathan's class");
        // a while true loop that takes input from the two players
        // it checks for a win every loop and breaks when it finishes.
        while(true) {
            printArray(gameBoard);
            turnLoop: while (true) {
                System.out.print("Player " + turn + ", Which column would you like to drop a chip in a: ");
                target = sc.nextInt() - 1;
                if(0 > target || gameBoard[0].length - 1 < target){
                    System.out.println("Invalid Index");
                } else {
                    for (int i = gameBoard.length - 1; i >= 0; i--) {
                        if (gameBoard[i][target] == '\u0020') {
                            gameBoard[i][target] = turn;
                            break turnLoop;
                        }
                    }
                    System.out.println("Please repeat, that row is full");
                }

            }


            if(checkForWin(gameBoard)){
                printArray(gameBoard);
                System.out.println(turn+" wins!!");
                break;
            }
            // checks to see if the board is full: if it is and the win check doesn't come back true, it ends the game with a tie.
            if(turnNumber>=(gameBoard.length*gameBoard[0].length)){
                printArray(gameBoard);
                System.out.println("It is a tie............how rare");
                break;
            }
            // swaps player after every turn and adds to the turn count
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            turnNumber++;
        }
    }
    // A method that prints the board of the game
    public static void printArray(char[][] gameBoard){
        for (char[] chars : gameBoard) {
            for(char ignored : chars){
                System.out.print("----");
            }
            System.out.print("-\n" + "| ");
            for(char character : chars){
                System.out.print(character+" | ");
            }
            System.out.println();
        }
        for(char[] chars : gameBoard){
            for(char ignored : chars){
                System.out.print("----");
            }
            System.out.println("-\n");
            break;
        }

        System.out.print("| ");
        for(int i = 0;i<gameBoard[0].length;i++){
            System.out.print((i+1) + " | ");
        }
        System.out.println();

    }
    // checks to see if there is a win in all four directions -- vertically, horizontally, and the two diagonals

    public static boolean checkForWin(char[][] values){
        for(int i = 0; i<20;i++){
            System.out.println();
        }
        // checks horizontally
        for (char[] value : values) {
            for (int column = 0; column < value.length; column++) {
                /* debugging
                System.out.println(row+ " "+column);
                System.out.println(column + 3);
                System.out.println(values[row].length);

                 */
                if ((column + 3) >= value.length) {

                } else if (value[column] == value[column + 1] && value[column + 1] == value[column + 2] && value[column + 2] == value[column + 3] && value[column] != '\u0020') {
                    return true;
                }
            }
        }

        // checks vertically
        for(int row=0;row<values.length;row++){
            for(int column=0;column<values[row].length;column++){
                if((row+3) >= values.length){

                } else if (values[row][column] == values[row+1][column] && values[row][column] == values[row+2][column] && values[row][column] == values[row+3][column] && values[row][column] != '\u0020'){
                    return true;
                }
            }
        }

        //checks diagonally to the right
        for(int row=0;row<values.length;row++){
            for(int column=0;column<values[row].length;column++){
                if((column + 3) >= values[row].length || (row+3) >= values.length){

                }else if (values[row][column] == values[row+1][column+1] && values[row][column] == values[row+2][column+2] && values[row][column] == values[row+3][column+3] && values[row][column] != '\u0020'){
                    return true;
                }
            }
        }

        // check diagonally to the left
        for(int row=0;row<values.length;row++){
            for(int column=values[row].length-1;column>=0;column--){
                if((column - 3)  < 0 || (row+3) >= values.length){
                    // debugging
                    //System.out.println("Breaking at "+row+" "+column);
                }else if (values[row][column] == values[row+1][column-1] && values[row][column] == values[row+2][column-2] && values[row][column] == values[row+3][column-3] && values[row][column] != '\u0020'){
                    return true;
                }
            }
        }
        return false;
    }
}