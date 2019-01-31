package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        // INSERT YOUR CODE HERE
        
        if(isXTurn) {
            System.out.print("Player 1 (X) Move:\n");
        } else {
            System.out.print("Player 2 (O) Move:\n");
        }
        
        System.out.print("Enter the row and column numbers, separated by a space: ");
        String line = keyboard.nextLine();
        String[] coordinates = line.split(" ");
        boolean valid = true;
        int row = -1;
        int col = -1;
        for (String i: coordinates) {
            char[] prep = i.toCharArray();
            for (char j : prep) {
                if (coordinates.length != 2 || !Character.isDigit(j))
                    valid = false;
            }
        }
        if (valid) {
            row = Integer.parseInt(coordinates[0]);
            col = Integer.parseInt(coordinates[1]);
        }
        
        return new TicTacToeMove(row, col);

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
