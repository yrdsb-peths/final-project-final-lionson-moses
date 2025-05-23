import greenfoot.*;

public class MyWorld extends World 
{
    //speed     
    private int bulletCooldown = 0 ;
    private int energyStore = 0;
    private Jet jet ;
    
    public int score = 0 ;
    Label scoreLabel;
    
    public int level = 0 ;
    
    
    public int energy = 1;
    public int elec = 1;
    Label energys;
    
    private int explosionCooldown = 0 ;
    
    
    public boolean isGameover = false ;
    public MyWorld() 
    {
        super(400, 800, 1, false);
        
        setBackground("images/space.jpg");
        
        jet = new Jet();
        addObject(jet , 200 , 670 );
        
        Jetfire fire = new Jetfire(false);
        addObject(fire , 220 , 790);
        
        Jetfire fire2 = new Jetfire(true);
        addObject(fire2 , 182 , 790);
        
        scoreLabel = new Label(0,50);
        addObject(scoreLabel , 30,20);
        
        Icon energyIcon = new Icon();
        energys = new Label(0, 40);
        addObject(energyIcon, 60, 780);
        addObject(energys, 30, 780);
        
        
        
        /*
        Label levelLabel = new Label(0,50);
        addObject(levelLabel ,100 , 20);
        */
        /// there's some bugs happening here, 
        ///cant run the levelIncrease method
    }    
    public void act()
    {
        if (bulletCooldown  > 0 ) 
        {
            bulletCooldown--;
        }
        if(energyStore > 0)
        {
            energyStore--;
        }
        
        creatBullets();
        
        spawn();
        setElec();
        
        if(isGameover)
        {
            Final gameOverAnimation = new Final(score);
            Greenfoot.setWorld(gameOverAnimation);
        }
    }
    /*public void levelIncrease()
    {
        level ++ ;
        levelLabel.setValue(level);
    }
    */
    
   
    ///this is label Gameover,
    public void gameOver()
    {
        /*
        Label gameOverLabel = new Label("Game Over", 90);
        addObject(gameOverLabel, 200, 400);
        Greenfoot.stop() ;
        */
        isGameover = true ;
    }
    ///this increases the score every time one bug is killed
    public void scoreIncrease()
    {
        score++ ;
        scoreLabel.setValue(score);
    }
    //set the value of energy
    public void setElec()
    {
        energys.setValue(elec);
    }
    
    ///this creats bullets, 
    ///they spawn with the same location as the jet class.
    public void creatBullets()
    {
        if (Greenfoot.isKeyDown("space") && bulletCooldown == 0)
        
        {
            
            Bullets bul = new Bullets();
            Greenfoot.playSound("fire.mp3");
            int x = jet.getX() ;
            int y = jet.getY() ;
            
            addObject(bul , x , y );
            if(level < 11)
            {
                bulletCooldown = 27 - 2*level ;
            }
            else
            {
                bulletCooldown = 5 ;
            }
        }
    
        //when there's energy, spawn a huge bullet
        if(Greenfoot.isKeyDown("down") && energy > 0 && energyStore == 0)
        {
            Skill bom = new Skill();
            Greenfoot.playSound("lazer.mp3");
            int x = jet.getX() ;
            int y = jet.getY() ;
            addObject(bom , x, y);
            energy--;
            elec--;
            setElec();
            energyStore = 60;
        }
    }
    
    ///this spawns bugs
    public void spawn()
    {
        
        if (getObjects(Bug.class).isEmpty()) //(buged, need to be fixed)
        
        {
            level += 1 ;
            for(int i = 0 ; i < 2 + level ; i++)
            {  
                creatbug();
            }
            createGift();
            if(level >= 6)
            {
                createMeteorite();
            }
        }
    }
    /// the game became super laggy if I don't creat 
    /// and use this method
    public void creatbug()
    {
        Bug bug = new Bug();
            int x = Greenfoot.getRandomNumber(400);
            int y = 100 + Greenfoot.getRandomNumber(50) ;
            addObject(bug , x, y );
    }
    //create gift for jet
    public void createGift()
    {
        Gift gift = new Gift();
        int x = Greenfoot.getRandomNumber(300);
        int y = 100 + Greenfoot.getRandomNumber(50) ;
        addObject(gift , x, y );
    }
    //create Meteorite
    public void createMeteorite()
    {
        Meteorite mete = new Meteorite();
        int x = Greenfoot.getRandomNumber(300);
        addObject(mete, x, -20);
        Greenfoot.playSound("boom.mp3");
    }
}
