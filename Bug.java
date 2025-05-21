import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bugs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    public Bug()
    {
        setImage("fly.png");
    }
    /*
    GreenfootImage[] idle = new GreenfootImage[10];
    public  Bug()
    {
        for(int i = 1; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageBugs/Bug0" + i + ".png");
        }
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateBugs()
    {
       
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1 )%  idle.length ;
        
    }
    */
    
    public void act()
    {
        
        setLocation(getX() , getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight() || isTouching(Jet.class) )
        {
            
            world.gameOver();
            
        }
        hit();
        ///animateBugs();
    }
    
    
   
    /*
     * check if bugs is being touched by bullets, and if so, remove themselfs
     */
    public void hit()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Bullets.class))
        {
             world.scoreIncrease();
             removeTouching(Bullets.class);
             getWorld().removeObject(this) ;
             Greenfoot.playSound("hit.mp3");
             
        }
    }
    
        
    
}
