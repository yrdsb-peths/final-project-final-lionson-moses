import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossAttack extends Actor
{
    /**
     * Act - do whatever the BossAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BossAttack()
    {
        
        GreenfootImage image = new GreenfootImage("bossAttack.jpg");
        image.scale(30 , 50);
        setImage(image);
    }
    public void act()
    {
        setLocation(getX() , getY() + 3);
        MyWorld world = (MyWorld) getWorld();
        hit();
        if(getY() >= 850)
        {
            world.removeObject(this);
        }
    }
    public void hit()
    {
        MyWorld world = (MyWorld) getWorld();
        if( isTouching(Jet.class))
        {
             world.gameOver();    
        }
    }
}
