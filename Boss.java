import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Final boss, the ufo of bugs
 * 
 * @Lionson and Moses
 * @1.0
 */
public class Boss extends Actor
{
    private Bar bossbar;
    public Boss(Bar barrequire)
    {
        bossbar = barrequire;
    }
    public void act()
    {
        if(bossbar.getValue() > 400)
        {
            
        }
    }
}
