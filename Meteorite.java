import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Can't be broke, destoryed power for jet
 * 
 * @Lionson and Moses 
 * v1.0
 */
public class Meteorite extends Actor
{
    public int meteoriteHealth = 30 ;
    GreenfootImage[] idle = new GreenfootImage[4];
    public Meteorite()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageMeteorite/Meteorite" + i + ".gif");
        }
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateMeteorite()
    {
       
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1)%  idle.length ;
        
    }
    public void act()
    {
        
        fly();
        
        animateMeteorite();
    }
    public void fly()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Bullets.class))
        {
            setLocation(getX() , getY() + 4);
            meteoriteHealth -- ;
            if(meteoriteHealth == 0)
            {
                getWorld().removeObject(this);
            }
            if(isTouching(Jet.class))
        {
            
            world.gameOver();
            
        }
        }
        else
        {
            setLocation(getX() , getY() + 6);
            if(isTouching(Jet.class))
        {
            
            world.gameOver();
            
        }
        }
    }
    
}
