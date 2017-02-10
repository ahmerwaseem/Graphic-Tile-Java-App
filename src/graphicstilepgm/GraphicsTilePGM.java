/*
 * Name: Ahmer Waseem
 * Assignment: 4
 * Due Date: 4/6/14
 * Program: To practice mouse events, allows user to select an image
 * and draw image on empty grid, also allows user to clear grid.
 */
package graphicstilepgm;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*******************************************************
 * Class: GraphicsTilePGM
 * Purpose: Creates and displays GUI
 *******************************************************/
public class GraphicsTilePGM extends JFrame{

    public static void main(String[] args) {
        // TODO code application logic here
        createAndShowGUI();
    }
    
    GraphicsTilePGM(){
        
        super("Graphics PGM");
        // call a class to design the GUI 
        TileDesignerLayout tiledesign = new TileDesignerLayout();
        setLayout(new BorderLayout());
        add(tiledesign,BorderLayout.CENTER);
    }
    
    /*******************************************************
    * Name: createAndShowGUI
    * Purpose: creates and displays GUI
    * Arguments: None
    * Returns: None
    *******************************************************/
    public static void createAndShowGUI(){
        
        GraphicsTilePGM frame = new GraphicsTilePGM();
        frame.setSize(225, 300); //starting size w/h
        frame.setResizable(false); // Stop window resizing
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); //needed to close 
        frame.setVisible(true); //frames are invisible must set this true\
    }
    
}
