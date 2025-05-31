import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[14];
    public  FinalBoss()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/FinalBossUFO/tile00" + i + ".png");
            idle[i].scale(200 , 200);
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
        moveAround();
    }
    public void moveAround()
    {
        
        move(10);
        if(getY() <= getWorld().getHeight() - 200)
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
}
