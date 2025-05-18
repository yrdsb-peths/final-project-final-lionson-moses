import greenfoot.*;

public class MyWorld extends World 
{
    private int bulletCooldown = 0 ;
    private Jet jet ;
    
    public int score = 0 ;
    Label scoreLabel;
    
    public int level = 0 ;
    public MyWorld() 
    {
        super(400, 800, 1, false);
        
        
        jet = new Jet();
        addObject(jet , 200 , 700 );
        
        scoreLabel = new Label(0,50);
        addObject(scoreLabel , 30,20);
        
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
        
        creatBullets();
                
        
        
        spawn();
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
        Label gameOverLabel = new Label("Game Over", 30);
        addObject(gameOverLabel, 125, 250);
        Greenfoot.stop() ;
    }
    ///this increases the score every time one bug is killed
    public void scoreIncrease()
    {
        score++ ;
        scoreLabel.setValue(score);
    }
    
    ///this creats bullets, 
    ///they spawn with the same location as the jet class.
    public void creatBullets()
    {
        if (Greenfoot.isKeyDown("space") && bulletCooldown == 0)
        /*
         * it seems there's some problems with this if statement, 
         * it couldn't run properly.
         * there's also difficulty in terms if getting the location of the jet
         * my suggestion is set the origional location of creat bullet 
         * as the same as the jet. 
         * and then copy the code of the jet class "fly()". 
         * so the bullet moves as same as jet.
         */
        {
            Bullets bul = new Bullets();
            int x = jet.getX() ;
            int y = jet.getY() ;
            addObject(bul , x, y);
            bulletCooldown = 20 - level ;
        }
       
    }
    
    ///this spawns bugs
    public void spawn()
    {
        
        if (getObjects(Bugs.class).isEmpty()) //(buged, need to be fixed)
        
        {
            level += 1 ;
            /// below part works fine, only the "if statement " is bugged
            for(int i = 0 ; i < 5 + level ; i++)
            {  
               creatBugs();
            }
        }
    }
    public void creatBugs()
    {
        Bugs bug = new Bugs();
        int x = Greenfoot.getRandomNumber(300);
        int y = 100 + Greenfoot.getRandomNumber(50) ;
        addObject(bug , x, y );
        
    }
}
