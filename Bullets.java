import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullets extends Actor
{
    /**
     * Act - do whatever the Bullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullets()
    {
        setImage("images/bullet.jpg");
    }
    public void act()
    {
        setLocation(getX() , getY() - 7);
        MyWorld world = (MyWorld) getWorld();
        if(getY() <= 0 )
        {
            world.removeObject(this);
        }
        /// here is how bullets would move, removed if it's out of  range 
       
        
    }
    /*
     * this check if the bullets is touching bugs, 
     * and if so, delete it self.
     */
    public void hit()
    ///this method also has some bugs,if used in act(), 
    ///the bullet will be removed, but the one in bug class won't work
    {
       
        if(isTouching(Bugs.class))
        {
             
             getWorld().removeObject(this) ;
             
             
        }
    }
    
}
