import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fixed jet for final stage
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class GameOverFixedJet extends Actor
{
    public  GameOverFixedJet()
    {
        setImage("jetremove.png");
    }
    public void act()
    {
        //nothing to act
    }
    //stay at same postion
    public void resizeJet(int x , int y)
    {
        GreenfootImage image = new GreenfootImage("jetremove.png") ;
        image.scale(image.getWidth() +x , image.getHeight() +  y);
        setImage(image);
    }
}
