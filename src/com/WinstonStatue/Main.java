/*
Ivan Freeman
January 19, 2022,
The purpose of this program is to be able to successfully run a game of Tic-Tac-Toe with two players, and automatically conclude who wins
 */
package com.WinstonStatue;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialization variables
        Scanner sc = new Scanner(System.in);
        char turn = 'X';
        char[][] gameBoard = new char[6][7];
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
                System.out.print("Player " + turn + ", Which column would you like to drop a chip in a(0,1,2,3,4,5,6): ");
                target = sc.nextInt();
                if(0 > target || 7 < target){
                    System.out.println("Invalid Index");
                }
                for(int i = gameBoard.length - 1; i >=0;i--){
                    if(gameBoard[i][target] == '\u0020'){
                        gameBoard[i][target] = turn;
                        break turnLoop;
                    }
                }
                System.out.println("Please repeat, that row is full");

            }


            if(checkForWin(gameBoard)){
                printArray(gameBoard);
                System.out.println(turn+" wins!!");
                break;
            }
            // checks to see if the board is full: if it is and the win check doesn't come back true, it ends the game with a tie.
            if(turnNumber>=42){
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
            System.out.print("-----------------------------\n" + "| ");
            for(char character : chars){
                System.out.print(character+" | ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
    // checks to see if there is a win in all four directions -- vertically, horizontally, and the two diagonals

    public static boolean checkForWin(char[][] values){
        // checks horizontally
        for (int row = 0; row<values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                /* debugging
                System.out.println(row+ " "+column);
                System.out.println(column + 3);
                System.out.println(values[row].length);

                 */
                if ((column + 3) >= values[row].length) {

                } else if (values[row][column] == values[row][column + 1] && values[row][column + 1] == values[row][column + 2] && values[row][column + 2] == values[row][column + 3] && values[row][column] != '\u0020') {
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