import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UFO, appear every 8 level.
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class UFO extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[14];
    SimpleTimer animationTimer = new SimpleTimer();
    public UFO()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/stage1/tile" + i + ".png");
            idle[i].scale(160 , 160);
        }
        animationTimer.mark();
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateBoss()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1 )%  idle.length ;

    }
    public void act()
    {
        moveAround() ;
        animateBoss() ;
        healthChange();
    }
    //random moving
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
    //subtract health bar when being shot.
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
            int levels = world.getLevel();
            world.subtractBar(levels * 2);
            removeTouching(Skill.class);
        }
    }
}
