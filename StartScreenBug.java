import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * random bugs for fun
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class StartScreenBug extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[10];
    public  StartScreenBug()
    {
        for(int i = 0; i< idle.length ; i++)
        {
            idle[i] = new GreenfootImage("images/imageBugs/Bug0" + i + ".png");
        }
        setImage(idle[0]);
    }
    int imageIndex = 0;
    //animation
    public void animateStartScreenBugs()
    {
       
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1 )%  idle.length ;
        
    }
    //fly in random place
    public void act()
    {
        animateStartScreenBugs();
        moveAround();
    }
    public void moveAround()
    {
        move(4);
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
}
