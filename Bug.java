 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The basic eneies
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class Bug extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[10];
    SimpleTimer animationTimer = new SimpleTimer();
    public  Bug()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageBugs/Bug0" + i + ".png");
        }
        setImage(idle[0]);
        animationTimer.mark();
    }
    int imageIndex = 0;
    //animation of bugs
    public void animateBugs()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1 )%  idle.length ;
        
    }
    //if it leave the world or touch jet, kill the game
    public void act()
    {
        
        setLocation(getX() , getY() + 1);
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight() || isTouching(Jet.class) )
        {
            
            world.gameOver();
            
        }
        hit();
        animateBugs();
    }
    
    
   
    /*
     * check if bugs is being touched by bullets, and if so, remove themselfs
     */
    public void hit()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Bullets.class) || isTouching(Skill.class))
        {
             world.scoreIncrease();
             removeTouching(Bullets.class);
             getWorld().removeObject(this) ;
             Greenfoot.playSound("hit.mp3");
             world.subtractBar(1);
        }
    }  
}
