import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The lazer of UFO
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class BossAttack extends Actor
{
    public BossAttack()
    {
        
        GreenfootImage image = new GreenfootImage("bossLazer.png");
        image.scale(28 , 80);
        setImage(image);
    }
    //bullet
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
    //end the game
    public void hit()
    {
        MyWorld world = (MyWorld) getWorld();
        if( isTouching(Jet.class))
        {
             world.gameOver();    
        }
    }
}
