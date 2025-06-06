import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The basic method to kill bugs
 * 
 * @Moses and Lionson
 * @v1.0
 */

public class Bullets extends Actor
{
    public Bullets()
    {
        GreenfootImage image = new GreenfootImage("bulletImage.png");
        image.scale(30 , 50);
        setImage(image);
    }
    // speed and optimization of bullet
    public void act()
    {
        setLocation(getX() , getY() - 7);
        World world = getWorld();
        if(getY() <= 0 )
        {
            world.removeObject(this);
        }
    }
}
