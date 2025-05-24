import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * make jet more realistic
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class Jetfire extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[6];
    //if set true, will mirror the image
    public  Jetfire(boolean left)
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageFire/tile00" + i + ".png");
            if(left)
            {
                idle[i].mirrorHorizontally();
            }
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
             if(Greenfoot.isKeyDown("space"))
             {
                 move(3);
             }
         }
          else if(Greenfoot.isKeyDown("right"))
         {
             move(5);
             if(Greenfoot.isKeyDown("space"))
             {
                 move(-3);
             }
         }
    }
}
