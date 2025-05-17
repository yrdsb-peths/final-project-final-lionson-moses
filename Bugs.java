import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bugs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bugs extends Actor
{
    /*GreenfootImage[] idle = new GreenfootImage[10];
    
    public  Bugs()
    {
        for(int i = 0; i< idle.length ; i++)
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
        
        hit();
        
    }
    
    /*
     * this method check if there's any remain bugs exists
     * if so then nothing happen, else it will creat another wave
     * of bugs.
     */
   
    /*
     * check if bugs is being touched by bullets, and if so, remove themselfs
     */
    public void hit()
    {
        if(isTouching(Bullets.class))
        {
             
             getWorld().removeObject(this) ;
            
        }
    }
    
        
    
}
