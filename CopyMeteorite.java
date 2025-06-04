import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Meteorite in Instruction
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class CopyMeteorite extends Actor
{
    //same as the origin meteorite
    public int meteoriteHealth = 20 ;
    GreenfootImage[] idle = new GreenfootImage[4];
    SimpleTimer animationTimer = new SimpleTimer();
    public CopyMeteorite()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageMeteorite/Meteorite" + i + ".gif");
        }
        setImage(idle[0]);
        animationTimer.mark();
    }
    int imageIndex = 0;
    public void animateMeteorite()
    {
       if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        setImage(idle[imageIndex]);
       imageIndex = (imageIndex + 1)%  idle.length ;
        
    }
    public void act()
    {
        animateMeteorite();
        fly();
        hit();
        
    }
    public void fly()
    {
        Instruction world = (Instruction) getWorld();
        //when touching bullet, decrease the speed of meteorite
        if( isTouching(CopyBullets.class))
        {
            setLocation(getX() , getY() -3);
            meteoriteHealth--;
            OneTimeExplosion explo = new OneTimeExplosion();
            getWorld().addObject(explo , getX() , getY());  
            removeTouching(CopySkill.class);
            removeTouching(CopyBullets.class);
        }
        else
        {
            setLocation(getX() , getY() + 4);
        }
       
    }
    //when it touching skill or shoot 20times by bullet, will explosion
    public void hit()
    {
        Instruction world = (Instruction) getWorld();
        
        if(isTouching(CopySkill.class) )
        {
             
             removeTouching(CopySkill.class);
             getWorld().removeObject(this) ;
             Greenfoot.playSound("hit.mp3");
             
        }
        else if ( getY() >= 800 )
        {
            getWorld().removeObject(this) ;
        }
    }
    
}
