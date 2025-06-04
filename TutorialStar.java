import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The stars of Instruction, moving or shoot to remove it.
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class TutorialStar extends Actor
{

    public TutorialStar()
    {
        setImage("red-draught.png");
    }
    public void act()
    {
        hit();
    }
    public boolean hit()
    {
        if(isTouching(Jet.class) || isTouching( CopyBullets.class ))
        {
            getWorld().removeObject(this) ;
            return true ;
        }
        else
        {
            return false ;
        }
    }
}
