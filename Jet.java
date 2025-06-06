import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * our jet, the player's actor, beating bugs
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class Jet extends Actor
{
    public  Jet()
    {
        GreenfootImage image = new GreenfootImage("jetremove.png");
        image.scale(97 , 150);
        setImage(image);
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
    
}
