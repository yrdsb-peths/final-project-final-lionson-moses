import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[9];
    public  Explosion()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageExplosion/explosion00" + i + ".png");
            idle[i].scale(50 , 50);
        }
        
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateExplosion()
    {
       
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1 )%  idle.length ;
        
    }
    
    
    
    public void act()
    {
        animateExplosion();
        
    }
    
}
