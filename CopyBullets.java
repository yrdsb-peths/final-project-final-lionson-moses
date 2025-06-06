import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet for instruction
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class CopyBullets extends Actor
{
    public CopyBullets()
    {
        GreenfootImage image = new GreenfootImage("bulletImage.png");
        image.scale(30 , 50);
        setImage(image);
    }
    // speed and optimization of bullet
    public void act()
    {
        setLocation(getX() , getY() - 7);
        Instruction world = (Instruction) getWorld();
        if(getY() <= 0 )
        {
            world.removeObject(this);
        }
    }
}
