import greenfoot.*;

public class MyWorld extends World 
{
    //speed
    GreenfootImage[] space = new GreenfootImage[40];
    private int bulletCooldown = 0 ;
    private int energyStore = 0;
    private Jet jet ;
    private DoubleBulletsAbility ability ; 
    public int score = 0 ;
    Label scoreLabel;
    public int bossNumber = 1;
    public FinalBoss boss ;
    public int level = 0 ;
    public int bossAttackCooldown = 0 ;
    public int bossAttackShotCount = 0 ;
    //public int bossAttackPause = 0 ;
    public int energy = 1;
    public int elec = 1;
    Label energys;
    
    private int explosionCooldown = 0 ;
    SimpleTimer animationTimer = new SimpleTimer();
    public boolean isGameover = false ;
    public Bar bar;
    public MyWorld() 
    {
        super(400, 800, 1, false);
        
        jet = new Jet();
        addObject(jet , 200 , 670 );
        
        Jetfire fire = new Jetfire(false);
        addObject(fire , 220 , 790);
        
        Jetfire fire2 = new Jetfire(true);
        addObject(fire2 , 182 , 790);
        
        scoreLabel = new Label(0,50);
        addObject(scoreLabel , 40,20);
        
        Icon energyIcon = new Icon();
        energys = new Label(0, 40);
        addObject(energyIcon, 60, 780);
        addObject(energys, 30, 780);
        
        for(int i = 0; i< space.length ; i++)
        {
            space[i] = new GreenfootImage("images/spaceNew/space" + i + ".gif");
        }
        setBackground(space[0]);
        animationTimer.mark();
        
        
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
        if(energyStore > 0 )
        {
            energyStore--;
        }
        
        
        creatBullets();
        creatBoss();
        
        if (bossAttackCooldown  > 0 ) 
        {
            bossAttackCooldown --;
        }
        else if (bossAttackCooldown == 0  )
        {
            creatBossAttack();
        }
        spawn();
        setElec();
        
        if(isGameover)
        {
            Final gameOverAnimation = new Final(score);
            Greenfoot.setWorld(gameOverAnimation);
        }
        animateSpace();
    }
    int backgroundIndex = 0;
    public void animateSpace()
    {
        if(animationTimer.millisElapsed() < 30)
        {
            return;
        }
        animationTimer.mark();
        setBackground(space[backgroundIndex]);
        backgroundIndex = (backgroundIndex + 1 )%  space.length ;
        
    }
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
    public void creatBossAttack()
    {
        if( ! getObjects(FinalBoss.class).isEmpty())
        {
            int x = boss.getX() ;
            int y= boss.getY()  ;
            BossAttack attack = new BossAttack();
            addObject( attack , x , y ) ;
            bossAttackCooldown = 30 ;
            bossAttackShotCount += 1 ;
        }
    }
    public void creatBoss()
    {
        if(getObjects(FinalBoss.class).isEmpty() && level % 2 == 0 && level != 0 )
        {
            boss = new FinalBoss();
            addObject(boss , 200 , 300);
            bar = new Bar("Boss", "Health Points", 70, 70);
            addObject(bar, 200, 100);
           
        }
        
    }
    ///this creats bullets, 
    ///they spawn with the same location as the jet class.
    public void creatBullets()
    {
        if (Greenfoot.isKeyDown("space") && bulletCooldown == 0)
        
        {
            int x1 = jet.getX() ;
            int y= jet.getY() -50  ;
            int x2 = jet.getX() + 10 ;
            Bullets bul1 = new Bullets();
            if( level >= 10 )
            {
                
                Bullets bul2 = new Bullets();
                addObject(bul2 , x2 , y );
                x1 -= 10 ;
            }
            else
            {
                ;
            }
            
            Greenfoot.playSound("fire.mp3");
            
            
            addObject(bul1 , x1 , y );
                        
            if(level < 12)
            {
                bulletCooldown = 29 - 2*level ;
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
        if (getObjects(Bug.class).isEmpty()) 
        
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
    
    public void subtractBar(int numbers)
    {
        bar.subtract(numbers);
    }
}
