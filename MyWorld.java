import greenfoot.*;
/**
 * Our World
 * By moses and Lionson
 * v2.0
 */
public class MyWorld extends World 
{
    GreenfootImage[] space = new GreenfootImage[40];
    private int bulletCooldown = 0 ;//bullet cooldown
    private int energyStore = 0;//energy cooldown(skill)
    private int powerTimer = 0;//power time counting
    private Jet jet ;
    public int score = 0 ;//score for final and label
    Label scoreLabel;
    public UFO boss ;
    public int level = 0;
    public int bossAttackCooldown = 0 ;//UFO's lazer cooldown
    public int energy = 1;// real energy
    public int elec = 1;//for label
    Label energys;
    Label warning = new Label("WARNING!", 20);
    public boolean bossDefeated = false;//when is true, will not spawn at this level
    public boolean upgrade = false;//power time on or not
    
    private Bar times;//bar of power time
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer frameTimer = new SimpleTimer();
    public boolean isGameover = false ;//jet is dead or not
    public Bar bar;//boss's health bar
    Icon bossIcon = new Icon();//icon for warning boss coming
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
        
        Icon energyIcon = new Icon();//energy icon at down left
        
        energys = new Label(0, 40);
        addObject(energyIcon, 60, 780);
        addObject(energys, 30, 780);
        
        for(int i = 0; i< space.length ; i++)
        {
            space[i] = new GreenfootImage("images/spaceNew/space" + i + ".gif");
        }
        setBackground(space[0]);
        animationTimer.mark();
    }    
    public void act()
    {
        //minus one in one frame.
        if (bulletCooldown  > 0 ) 
        {
            bulletCooldown--;
        }
        if(energyStore > 0 )
        {
            energyStore--;
        }
        if(frameTimer.millisElapsed() >= 1000)
        {
            powerTimer--;
        }
        warning();
        creatBullets();
        creatUFO();
        powerTime();
        
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
        //if jet dead, end game 
        if(isGameover)
        {
            Final gameOverAnimation = new Final(score);
            Greenfoot.setWorld(gameOverAnimation);
        }
        animateSpace();
        //health bar for boss
        if (bar != null && bar.getValue() == 0)
        {
            if (boss != null)
            {
                removeObject(boss);
                boss = null;
                bossDefeated = true;
            }
            removeObject(bar);
            bar = null;
        }
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
    //spawn boss attack
    public void creatBossAttack()
    {
        if( ! getObjects(UFO.class).isEmpty())
        {
            int x = boss.getX() ;
            int y= boss.getY()  ;
            BossAttack attack = new BossAttack();
            addObject( attack , x , y ) ;
            bossAttackCooldown = 150;
            Greenfoot.playSound("UFOLazer.wav");
            
        }
    }
    //for every 8 stage, spwan boss
    public void creatUFO()
    {
        if(getObjects(UFO.class).isEmpty() && bossDefeated == false && level % 8 == 0 && level != 0 )
        {
            boss = new UFO();
            addObject(boss , 200 , 300);
            int health = level* 5;
            bar = new Bar("Boss", "Health Points", health, health);
            addObject(bar, 200, 100);
            removeObject(bossIcon);
            removeObject(warning);
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
            //when is powertime, shoot two line of bullet.
            if(powerTimer > 0)
            {
                Bullets bul2 = new Bullets();
                addObject(bul2 , x2 , y );
                x1 -= 10 ;
            }
            
            Greenfoot.playSound("fires.mp3");
            
            //increase rate of fire by level
            addObject(bul1 , x1 , y );
            //level 12 is the maximum rate
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
        //spend 3 energy to start power time
        if(Greenfoot.isKeyDown("up") && energy >= 3 && upgrade == false)
        {
            energy -= 3;
            elec -= 3;
            setElec();
            upgrade = true;
            powerTimer = 20;
            frameTimer.mark();
            Greenfoot.playSound("PowerTime.mp3");
        }
    }
    
    ///this spawns bugs
    public void spawn()
    {
        if (getObjects(Bug.class).isEmpty() && getObjects(UFO.class).isEmpty() ) 
        
        {
            level += 1 ;
            bossDefeated = false;
            if(level % 8 != 0)//when is level 8, spawn boss
            {
                for(int i = 0 ; i < 2 + level ; i++)
                {
                    creatbug();
                }
            }
            createGift();
            //spawn meteorite after level 6
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
        int x = Greenfoot.getRandomNumber(350);
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
    //subtrack boss health bar.
    public void subtractBar(int numbers)
    {
        bar.subtract(numbers);
    }
    //before UFO coming, add a warning
    public void warning()
    {
       if(level % 8 == 7)
        {
            bossIcon.setBoss();
            addObject(bossIcon, 360, 25);
            addObject(warning, 300, 25);
        }
    }
    //power timer
    public void powerTime()
    {
        if(powerTimer > 0)
        {
            if(times == null)
            {
                times = new Bar("Power!","",20,20);
                times.setBarWidth(100);
                times.setBarHeight(9);
                times.setBreakPercent(20);
                addObject(times, 300, 780);
            }
            if(frameTimer.millisElapsed() >= 1000)
            {
                times.subtract(1);
                frameTimer.mark();
            }
        }
        else
        {
            removeObject(times);
            upgrade = false;
            times = null;
        }
    }
    //get method
    public int getLevel()
    {
        return level;
    }
}
