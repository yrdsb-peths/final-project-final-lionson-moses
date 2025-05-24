import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Energy gift for players
 * 
 * @Lionson and Moses
 * @v1.0
 */
public class Gift extends Actor
{
    public Gift()
    {
        setImage("energy.png");
    }
    //spawn with bugs, when touch it add energy for player
    public void act()
    {
        setLocation(getX() , getY() + 1);
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Jet.class))
        {
            Greenfoot.playSound("gaingift.mp3");
            world.energy++;
            world.removeObject(this);
            world.elec++;
            world.setElec();
        }
    }
}
