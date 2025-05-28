import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instruction extends World
{
    private int bulletCooldown = 0 ;
    private Jet jet ;
    
    public int count = 0 ;
    
    public boolean isPhase1done = false;
    boolean[] isPhaseDone ={false , false , false};
    
    /**
     * Constructor for objects of class Instruction.
     * 
     */
    public Instruction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 800, 1 , false); 
        setBackground("images/space.jpg");
        
        InstructionLabel instruction = new InstructionLabel("Welcome!", 50);
        addObject(instruction , 200 , 400);
        
        jet = new Jet();
        addObject(jet , 200 , 670 );
        
        
    }
    public void act()
    {
        instructionPhase1();
        
    }
    public void startGame()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
            Greenfoot.playSound("pressToStart.mp3");
        }
    }
    
    public void instructionPhase1()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            InstructionLabel instruction = new InstructionLabel("Press left and right to move!", 30);
            addObject(instruction , 200 , 400);
        }
        if(count < 1)
        {
            TutorialStar star1 = new TutorialStar();
            TutorialStar star2 = new TutorialStar();
            addObject(star1 , 100 , 670);
            addObject(star2 , 300 , 670);
            count+=1 ;
        }
        else
        {
            isPhaseDone[0] = true ;
        }
    }
    public void instructionPhase2()
    {
        
    }
    public void creatBullets()
    {
        if (Greenfoot.isKeyDown("space") && bulletCooldown == 0)
        
        {
            
            Bullets bul = new Bullets();
            Greenfoot.playSound("fire.mp3");
            int x = jet.getX() ;
            int y = jet.getY() ;
            
            addObject(bul , x , y );
            
                bulletCooldown = 5 ;
            
        }
    }
}
