import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instruction extends World
{
    
    public boolean isPhase1done = false;
    boolean[] isPhaseDone ={false , false , false};
    
    /**
     * Constructor for objects of class Instruction.
     * 
     */
    public Instruction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/space.jpg");
        
        InstructionLabel instruction = new InstructionLabel("Welcome!", 50);
        addObject(instruction , 300 , 200);
        
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
        
    }
    public void instructionPhase2()
    {
        
    }
}
