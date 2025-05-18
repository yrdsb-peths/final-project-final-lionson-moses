import greenfoot.*;

public class MyWorld extends World 
{
    private int bulletCooldown = 0 ;
    private Jet jet ;
    
    public int score = 0 ;
    Label scoreLabel;
    public MyWorld() 
    {
        super(250, 500, 1, false);
        
        
        jet = new Jet();
        addObject(jet , 125 , 400 );
        
        scoreLabel = new Label(0,50);
        addObject(scoreLabel , 30,20);
        
       
    }    
    public void act()
    {
        if (bulletCooldown > 0) 
        {
            bulletCooldown--;
        }
        
        creatBullets();
                
        
        
        spawn();
    }
    ///this labels game over 
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 30);
        addObject(gameOverLabel, 125, 250);
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
            bulletCooldown = 20 ;
        }
       
    }
    
    ///this spawns bugs
    public void spawn()
    {
        
        if (getObjects(Bugs.class).isEmpty()) //(buged, need to be fixed)

        {
            /// below part works fine, only the "if statement " is bugged
            for(int i = 0 ; i < 5 ; i++)
            {  
               creatBugs();
            }
        }
    }
    public void creatBugs()
    {
        Bugs bug = new Bugs();
        int x = Greenfoot.getRandomNumber(250);
        int y = 100 ;
        addObject(bug , x, y );
        
    }
}
