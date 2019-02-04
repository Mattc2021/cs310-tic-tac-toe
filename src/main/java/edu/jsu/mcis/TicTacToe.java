package edu.jsu.mcis;

import javax.swing.JFrame;

public class TicTacToe {
    
    public static final int DEFAULT_WIDTH = 3;
    
    public static void main(String[] args) {
        
        /* Set initial size of game board (default is 3x3) */

        int width = DEFAULT_WIDTH;
        
        /* If a different size is provided as an argument, use it instead */

        if(args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
        
        /* Create Controller */

        TicTacToeController controller = new TicTacToeController(width);
        
        /* Start Main Loop */
        
        JFrame win = new JFrame("Tic-Tac-Toe");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        win.add(controller.getView());
        win.pack();
        win.setVisible(true);
        
    }
    
}