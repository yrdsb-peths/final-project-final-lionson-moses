import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * our start world, for instruction
 * 
 * @Moses and Lionson
 * @v1.0
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
        
        Label startLabel = new Label("Bug Blaster", 100);
        addObject(startLabel, 300, 220);
        
        
        Label instruction1 = new Label("press space to start the game and SHOOT!", 20);
        Label instruction2 = new Label("press Left and Right to MOVEAROUND!", 20);
        Label instruction3 = new Label("Eat the LIGHTING and press Down to ACTIVATE SECRET BULLET !", 20);
        Label instruction4 = new Label("DONT let the bug touch you or get over you!", 20);
        Label instruction5 = new Label("Eat the Nighting to gain HUGE BULLET SKILL! You can press 'Down' to activate it!" , 20);
        Label instruction6 = new Label("Careful with the Meteorite! you can destrpy it only using skill!" , 20);
        addObject(instruction1 , 300 , 30);
        addObject(instruction2 , 300 , 60);
        addObject(instruction3 , 300 , 90);
        addObject(instruction4 , 300 , 120);
        addObject(instruction5 , 300 , 150);
        addObject(instruction6 , 300 , 180);
        
        
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
        
        if ( ! musicStarted)
        {
            music.playLoop();
            musicStarted = true;
        }
        
    }
    //press space to start the game
    public void act()
    {

        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld startGame = new MyWorld();
            Greenfoot.setWorld(startGame);
            music.pause();
            Greenfoot.playSound("pressToStart.mp3");
        }
    }
}
