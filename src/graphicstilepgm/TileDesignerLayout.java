/*
 * Name: Ahmer Waseem
 * Assignment: 4
 * Due Date: 4/6/14
 * Program: To practice mouse events, allows user to select an image
 * and draw image on empty grid, also allows user to clear grid.
 */
package graphicstilepgm;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.ActionListener; 
import javax.swing.*;
import java.awt.Image;

/*******************************************************
 * Class: TileDesignerLayout
 * Purpose: Sets layout for display of buttons/toolbars
 *******************************************************/
public class TileDesignerLayout extends JPanel
{	
    Image[] imageA = new Image[5];	 //image array to hold 5 images that are loaded
    
    public TileDesignerLayout(){
    setLayout(new BorderLayout());
 
     
    final TileCanvas centerPanel1ptr = new TileCanvas(); //call class to make center grid
 
    add(centerPanel1ptr, BorderLayout.CENTER); //Adding centerPanel to outerFrame.

    centerPanel1ptr.ResetGridTile(); // reset GridTile		
    centerPanel1ptr.LoadImageArray(); // load images into array
    imageA = centerPanel1ptr.imageA;   //connect pointer
    centerPanel1ptr.CreateMouseListener();								

    JToolBar tileToolBar = new JToolBar();	//add buttons to toolbar							
    JButton patch1btn = new JButton(new ImageIcon(imageA[0])); 
    tileToolBar.add(patch1btn); //add button to toolbar
    add(tileToolBar,BorderLayout.NORTH);
    
    JButton patch2btn = new JButton(new ImageIcon(imageA[1])); 
    tileToolBar.add(patch2btn); //add button to toolbar
    add(tileToolBar,BorderLayout.NORTH);
    
    JButton patch3btn = new JButton(new ImageIcon(imageA[2])); 
    tileToolBar.add(patch3btn); //add button to toolbar
    add(tileToolBar,BorderLayout.NORTH);
    
    JButton patch4btn = new JButton(new ImageIcon(imageA[3])); 
    tileToolBar.add(patch4btn); //add  button to toolbar
    add(tileToolBar,BorderLayout.NORTH);
    
    JButton patch5btn = new JButton(new ImageIcon(imageA[4])); 
    tileToolBar.add(patch5btn); //add  button to toolbar
    add(tileToolBar,BorderLayout.NORTH);
    
    JPanel tileResetBar = new JPanel();  //Panel for reset button
    JButton resetButton = new JButton("RESET"); //create resut button
    tileResetBar.add(resetButton, BorderLayout.CENTER); //add button to panel
    add(tileResetBar,BorderLayout.SOUTH);
    
    /*******************************************************
    * Name: actionPerformed -- Action Listeners for button
    * Purpose: Sets event for button clicks
    * Arguments: ActionEvent e
    * Returns: None
    *******************************************************/
    
    resetButton.addActionListener(new ActionListener(){ 
     @Override       
     public void actionPerformed(ActionEvent e) 
    {
        centerPanel1ptr.ResetGridTile();
    }
 });
    
    patch1btn.addActionListener(new ActionListener(){ 
     @Override       
     public void actionPerformed(ActionEvent e) 
    {
        centerPanel1ptr.selectedTile = 0;
    }
 });
            
     patch2btn.addActionListener(new ActionListener(){
     @Override        
     public void actionPerformed(ActionEvent e) 
    {
        centerPanel1ptr.selectedTile = 1;
    }
 });
     patch3btn.addActionListener(new ActionListener(){ 
     @Override        
     public void actionPerformed(ActionEvent e) 
    {
        centerPanel1ptr.selectedTile = 2;
    }
 });
     patch4btn.addActionListener(new ActionListener(){
     @Override        
     public void actionPerformed(ActionEvent e) 
    {
        centerPanel1ptr.selectedTile = 3;
    }
 });
     
     patch5btn.addActionListener(new ActionListener(){ 
     @Override        
     public void actionPerformed(ActionEvent e) 
    {
        centerPanel1ptr.selectedTile = 4;
    }
 });
			
    }
}
