/*
 * Name: Ahmer Waseem
 * Assignment: 4
 * Due Date: 4/6/14
 * Program: To practice mouse events, allows user to select an image
 * and draw image on empty grid, also allows user to clear grid.
 */
package graphicstilepgm;


import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

/*******************************************************
 * Class: TileCanvas
 * Purpose: Contains methods to draw images, grids, and
 * listen to mouse events to create interactivity
 *******************************************************/
class TileCanvas extends JPanel implements MouseListener
{
static final int squareSide = 25; 
int gridRow=5,gridCol=5;						
int[][] tilesArray = new int[gridRow][gridCol];  //row is y, col is x
int startX, startY;
int gridWidth, gridHeight;
public int selectedTile = -1;
String[] stringImageName = {"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif"};
Image[] imageA = new Image[5]; //hold 5 gifs
Image[][] gif2dArray = new Image[gridRow][gridCol];

    
    /*******************************************************
    * Name: LoadImageArray
    * Purpose: Loads images into an array
    * Arguments: None
    * Returns: None
    *******************************************************/
    
    public void LoadImageArray(){ // Use toolkit to fill imageA..5 gifs}
        for (int i = 0; i < 5; i++)
            imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(stringImageName[i]); 
    }

    /*******************************************************
    * Name: ResetGridTile
    * Purpose: Sets center grid to null, erases graphics
    * Arguments: None
    * Returns: None
    *******************************************************/
    public void ResetGridTile(){
        for (int row=0; row < 5; row++)
     {
        for (int col=0; col < 5; col++){
            gif2dArray[row][col] = null;
            this.repaint();
        }
     }
    
}
    
    /*******************************************************
    * Name: CreateMouseListener
    * Purpose: Adds mouselistener to the center panel for grid
    * Arguments: None
    * Returns: None
    *******************************************************/
    
    public void CreateMouseListener()//Add mouselistener to Center panel
    { addMouseListener(this);}
    
    /*******************************************************
    * MouseEvents Methods
    * Purpose: Keeps track of mouse clicks
    * Arguments: MouseEvent event
    * Returns: None
    *******************************************************/
    
    //user has clicked a tile on panel, now has clicked in the 5 x 5 grid
    @Override
    public void mouseClicked(MouseEvent event){							  
     //here we get  a position of the click of mouse –x,y
     int x = event.getX();
     int y = event.getY();
     //if it was a valid click in grid
     if(x >= startX && x <= startX+gridWidth && y >= startY && y <= startY+gridWidth)
     {
       int xIndex = (x-startX)/squareSide; //will be an integer of square clicked
       int yIndex = (y-startY)/squareSide; //wil be an integer of squear clicked

       //            col      row     
       gif2dArray[xIndex][yIndex] = imageA[selectedTile];
        this.repaint();  //show new grid
     }
    }

    @Override
    public void mouseExited(MouseEvent event){}

    @Override
    public void mouseEntered(MouseEvent event){}

    @Override
    public void mouseReleased(MouseEvent event){}

    @Override
    public void mousePressed(MouseEvent event){}

    
    /*******************************************************
    * Name: paintComponent
    * Purpose: Draws graphics/grid
    * Arguments: Graphics g
    * Returns: None
    *******************************************************/
    
    @Override
    public void paintComponent(Graphics g)	//Implementing paint component
    { 
          super.paintComponent(g);
          gridWidth = gridCol*squareSide;
          gridHeight = gridRow*squareSide;
          int panelWidth = getWidth();
          int panelHeight = getHeight();
          startX = (panelWidth-gridWidth)/2;//get starting point to draw grid based
          startY = (panelHeight-gridHeight)/2;


         //Drawing empty grid of 5*5 with an inner outer loop
         for (int row=0; row < 5; row++)
         {
            for (int col=0; col < 5; col++){
                g.drawRect(startX+(squareSide*row), startY+(squareSide*col), squareSide, squareSide);
            }
         }

         //copy gif image array over to the drawing grid with inner outer loop
        for (int row=0; row < 5; row++)
         {
            for (int col=0; col < 5; col++){
                g.drawImage(gif2dArray[row][col], startX+(squareSide*row), startY+(squareSide*col), this);
            }
     }
 

}
}