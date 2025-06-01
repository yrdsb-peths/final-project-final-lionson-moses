import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[14];
    public  FinalBoss()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/stage1/tile" + i + ".png");
            idle[i].scale(200 , 200);
        }
        
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateBoss()
    {
       
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1 )%  idle.length ;
        
    }
    public void act()
    {
        moveAround() ;
        animateBoss() ;
        healthChange();
    }
    public void moveAround()
    {
        
        move(5);
        if(getY() <= getWorld().getHeight() - 300 && getY() > 0 && getX() < getWorld().getWidth() && getX() > 0)
        {
            if(Greenfoot.getRandomNumber(100)<10)
            {
                turn(Greenfoot.getRandomNumber(90) - 45);
            }
            if(getX() <= 5 || getY() >= getWorld().getWidth() - 5)
            {
                turn(180);
            }
            if(getX() <= 5 || getY() >= getWorld().getHeight() - 5)
            {
                turn(180);
            }
        }
        else
        {
            turn(180);
        }
    }
    public void healthChange()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Bullets.class))
        {
            world.subtractBar(1);
            removeTouching(Bullets.class);
        }
        else if (isTouching(Skill.class))
        {
            world.subtractBar(5);
            removeTouching(Skill.class);
        }
    }
}
