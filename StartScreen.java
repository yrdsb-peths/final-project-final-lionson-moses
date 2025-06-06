import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * our start world, for instruction
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class StartScreen extends World
{

    GreenfootSound music = new GreenfootSound("startingpageloopmusic.mp3");
    private boolean musicStarted;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/space.jpg");
        
        Label startLabel = new Label("Bug Blaster", 100);
        addObject(startLabel, 300, 220);
        
        
        
        Label instruction1 = new Label("press space to start the game and SHOOT!", 35);
        Label instruction2 = new Label("press Tab to start tutorial!", 35);
        
        addObject(instruction1 , 300 , 30);
        addObject(instruction2 , 300 , 60);
        
        
        
        Jet demonJet = new Jet();
        addObject(demonJet , 300 , 280);
        
        for(int i = 0 ; i < 5 ; i++)
        {
            StartScreenBug demonBug = new StartScreenBug();
            int x = Greenfoot.getRandomNumber(600);
            addObject(demonBug , x , 100);
        }
        Jetfire startScreenFire = new Jetfire(false);
        Jetfire startScreenFireleft = new Jetfire(true);
        addObject(startScreenFire , 317 , 420);
        addObject(startScreenFireleft , 283 , 420);
        //background music
        if ( ! musicStarted)
        {
            music.playLoop();
            musicStarted = true;
        }
        
    }
    //press space to start the game
    public void act()
    {

        if(Greenfoot.isKeyDown("tab"))
        {
            Instruction instructionWorld = new Instruction();
            Greenfoot.setWorld(instructionWorld);
            music.pause();
            Greenfoot.playSound("pressToStart.mp3");
        }
        else if(Greenfoot.isKeyDown("space"))
        {
            MyWorld startGame = new MyWorld();
            Greenfoot.setWorld(startGame);
            music.pause();
            Greenfoot.playSound("pressToStart.mp3");
        }
    }
}
