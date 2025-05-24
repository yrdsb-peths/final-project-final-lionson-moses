import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jet extends Actor
{
    /**
     * Act - do whatever the Jet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public  Jet()
    {
        setImage("jetremove.png");
    }
    public void act()
    {
       fly();
    }
    public void fly()
    {
         if(Greenfoot.isKeyDown("left"))
         {
             move(-5);
             //if player always shoot, the difficulty will decrease
             if(Greenfoot.isKeyDown("space"))
             {
                 move(3);
             }
         }
          else if(Greenfoot.isKeyDown("right"))
         {
             move(5);
             //so it's for more balanced
             if(Greenfoot.isKeyDown("space"))
             {
                 move(-3);
             }
         }
    }
    public void resizeJet(int x , int y)
    {
        GreenfootImage image = new GreenfootImage("jetremove.png") ;
        image.scale(image.getWidth() +x , image.getHeight() +  y);
        setImage(image);
    }
}
