import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final extends World
{

    /**
     * Constructor for objects of class Final.
     * 
     */
    public Final(int finalScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/space.jpg");
        
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 170);
        
        Label mark = new Label("Your Mark:" + finalScore , 50);
        addObject(mark, 300, 280);
    }
}
