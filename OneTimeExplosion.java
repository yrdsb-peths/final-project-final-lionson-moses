import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * For metorite explosion
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class OneTimeExplosion extends Actor
{

    GreenfootImage[] idle = new GreenfootImage[9];
    public int count = 0 ;
    
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
        
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1 )%  idle.length ;
        count ++ ;
        if(count >= 18)
        {
            getWorld().removeObject(this);
        }
    
    }
    
}
