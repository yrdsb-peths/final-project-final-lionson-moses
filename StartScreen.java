import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    GreenfootSound music = new GreenfootSound("startingpageloopmusic.mp3");
    private boolean musicStarted;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/space.jpg");
        
        Jet demonJet = new Jet();
        addObject(demonJet , 300 , 300);
        if ( ! musicStarted)
        {
            music.playLoop();
            musicStarted = true;
        }
    }
    public void act()
    {

        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld startGame = new MyWorld();
            Greenfoot.setWorld(startGame);
            music.pause();
        }
    }
}
