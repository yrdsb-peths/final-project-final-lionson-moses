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
    public Final(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 800, 1); 
        setBackground("images/space.jpg");
        
        Label gameOverLabel = new Label("Game Over", 80);
        addObject(gameOverLabel, 200, 700);
        
        
        Jet gameOverJet = new Jet();
        gameOverJet.resizeJet(100 , 200);
        addObject(gameOverJet , 200 , 400);
        
        Label mark = new Label("You defeat:" + score + "bugs!", 40);
        addObject(mark, 200, 770);
        for(int i = 0 ; i < 10 ; i++)
        {
            Explosion explo = new Explosion();
            int x = 150 + Greenfoot.getRandomNumber(100);
            int y = 300 + Greenfoot.getRandomNumber(300);
            addObject(explo , x , y);
        }
        Greenfoot.playSound("explosion.mp3");
        
    }
}
