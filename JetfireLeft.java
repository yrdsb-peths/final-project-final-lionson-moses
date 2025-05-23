import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JetfireLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JetfireLeft extends Actor
{
    /**
     * Act - do whatever the Jetfire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[6];
    public JetfireLeft()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageFire/tile00" + i + ".png");
            idle[i].mirrorHorizontally();
        }
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateFire()
    {
       
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1 )%  idle.length ;
        
    }
    
    public void act()
    {
        animateFire();
        followingJet();
    }
    public void followingJet()
    {
         if(Greenfoot.isKeyDown("left"))
         {
             move(-5);
         }
          else if(Greenfoot.isKeyDown("right"))
         {
             move(5);
         }
    }
}

