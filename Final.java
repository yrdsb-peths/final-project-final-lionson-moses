import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ending world
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class Final extends World
{
    //to get score from MyWorld
    public Final(int score)
    {    
        // 400* 800.
        super(400, 800, 1); 
        setBackground("images/space.jpg");
        
        Label gameOverLabel = new Label("Game Over", 80);
        addObject(gameOverLabel, 200, 700);
        
        
        GameOverFixedJet gameOverJet = new GameOverFixedJet();
        gameOverJet.resizeJet(100 , 200);
        addObject(gameOverJet , 200 , 400);
        //count of bugs
        Label mark = new Label("You defeat:" + score + "bugs!", 40);
        addObject(mark, 200, 770);
        for(int i = 0 ; i < 10 ; i++)
        {
            Explosion explo = new Explosion();
            int x = 150 + Greenfoot.getRandomNumber(100);
            int y = 300 + Greenfoot.getRandomNumber(300);
            addObject(explo , x , y);
        }
        //sound
        Greenfoot.playSound("explosion.mp3");
        
    }
}
