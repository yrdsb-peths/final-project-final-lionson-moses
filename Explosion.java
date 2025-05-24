import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The animate of Meteorite and Jet
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class Explosion extends Actor
{
    //all for animate
    GreenfootImage[] idle = new GreenfootImage[9];
    public  Explosion()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageExplosion/explosion00" + i + ".png");
            idle[i].scale(150 , 150);
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
