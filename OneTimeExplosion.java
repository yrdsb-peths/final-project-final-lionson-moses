import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OneTimeExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OneTimeExplosion extends Actor
{
    /**
     * Act - do whatever the OneTimeExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[9];
    public int count = 0 ;
    public int delay = 3 ;
    public int delayCount = 0 ;
    public  OneTimeExplosion()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageExplosion/explosion00" + i + ".png");
            idle[i].scale(150 , 150);
            count ++ ;
        }
        
        setImage(idle[0]);
    }
    int imageIndex = 0;
    
    
    
    
    public void act()
    {
        if(delay > delayCount)
            {
                delayCount++ ;
            }
            else 
            {
                setImage(idle[imageIndex]);
                imageIndex = (imageIndex + 1 )%  idle.length ;
                count ++ ;
            }
        if(count >= 18)
        {
            getWorld().removeObject(this);
        }
    
    }
    
}
