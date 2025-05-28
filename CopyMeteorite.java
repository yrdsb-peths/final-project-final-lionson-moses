import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyMeteorite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopyMeteorite extends Actor
{
    public int meteoriteHealth = 20 ;
    GreenfootImage[] idle = new GreenfootImage[4];
    public CopyMeteorite()
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
        if(getY() >= 700)
        {
            world.removeObject(this);
        }
        
    }
    //when it touching skill or shoot 20times by bullet, will explosion
    public void hit()
    {
        Instruction world = (Instruction) getWorld();
        if(! world.getObjects(CopyMeteorite.class).isEmpty() && isTouching(CopySkill.class) || meteoriteHealth == 0)
        {
            OneTimeExplosion explo = new OneTimeExplosion();
            getWorld().addObject(explo , getX() , getY());  
            removeTouching(CopySkill.class);
            getWorld().removeObject(this) ;
            Greenfoot.playSound("rock.mp3");
             
        }
        
    }
    
}
