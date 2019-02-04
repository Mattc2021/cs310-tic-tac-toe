package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener{

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */
        
        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }
    
    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = null;
        if (event.getSource() instanceof JButton) {
            button = (JButton)(event.getSource());
        }
        String[] coordinates = button.getName().replace("Square", "").split("");
        model.makeMark(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        view.updateSquares();
        if (model.isGameover()) {
            view.disableSquares();
            view.showResult(model.getResult().toString());
        }
        
    }

}