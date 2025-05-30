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
    private int energyStore = 0;
    public int energy = 100;
    public int elec = 100;
    
    public int count = 0 ;
    
    public boolean isPhase1done = false;
    boolean[] isPhaseDone ={false , false , false , false};
    
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
        addObject(instruction , 200 , 500);
        
        jet = new Jet();
        addObject(jet , 200 , 670 );
        
        
        Label tabToShow = new Label("press Tab to show tutorial!" , 40);
        addObject(tabToShow , 200 , 100);
        
    }
    public void act()
    {
        
        if (bulletCooldown  > 0 ) 
        {
            bulletCooldown--;
        }
       if(energyStore > 0)
        {
            energyStore--;
        }
        creatBullets();
        
        
        instructionPhase1();
        instructionPhase2();
        instructionPhase3();
        if( getObjects(CopyMeteorite.class).isEmpty() && count < 1)
        { 
            instructionPhase4();
        }
        if(isPhaseDone[3] && getObjects(CopyMeteorite.class).isEmpty())
        {
            startGame();
        }
    }
    public void startGame()
    {
        InstructionLabel instruction = new InstructionLabel("Now press space to start the game!", 30);
        addObject(instruction , 200 , 500);
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
            Greenfoot.playSound("pressToStart.mp3");
        }
    }
    
    public void instructionPhase1()
    {
        if(isPhaseDone[0] == false )
            {
            if(Greenfoot.isKeyDown("Tab"))
            {
                InstructionLabel instruction = new InstructionLabel("Press left and right to move!", 30);
                addObject(instruction , 200 , 400);
            }
            if(count < 1)
            {
                TutorialStar star1 = new TutorialStar();
               
                addObject(star1 , 0 , 670);
                
                if( star1.hit() )
                {
                    count+=1 ;
                    Greenfoot.playSound("hit.mp3");
                }
            }
            else
            {
                isPhaseDone[0] = true ;
                count = 0 ;
            }
        }
    }
    public void instructionPhase2()
    {
        if(isPhaseDone[0] == true && isPhaseDone[1] == false)
        {
            if(Greenfoot.isKeyDown("Tab"))
            {
                InstructionLabel instruction = new InstructionLabel("Press space to Fire!", 30);
                addObject(instruction , 200 , 400);
            }
            TutorialStar star2 = new TutorialStar();
            addObject(star2 , 200 , 300);
            if( star2.hit() )
            {
                count+=1 ;
                Greenfoot.playSound("hit.mp3");
                isPhaseDone[1] = true ;
                count = 0 ;
            }
        }
    }
    public void instructionPhase3()
    {
        if(isPhaseDone[0] == true && isPhaseDone[1] == true && isPhaseDone[2] == false )
        {
            if(Greenfoot.isKeyDown("Tab"))
            {
                InstructionLabel instruction1 = new InstructionLabel("Here's a Meteorite", 30);
                InstructionLabel instruction2 = new InstructionLabel("fire to slow it down!", 30);
                addObject(instruction1 , 200 , 400);
                addObject(instruction2 , 200 , 500);
                CopyMeteorite tutorialMeteorite = new CopyMeteorite();
                addObject( tutorialMeteorite , 200 , 100);
                if( getObjects(CopyMeteorite.class).isEmpty() && count < 1)
                {
                    count = 1 ;
                }
                else
                {
                    isPhaseDone[2] = true ;
                    count = 0 ;
                }
            }
        }
        
    }
    
    public void instructionPhase4()
    {
        if(isPhaseDone[2] == true && isPhaseDone[3] == false )
        {
            if(Greenfoot.isKeyDown("Tab"))
            {
                InstructionLabel instruction = new InstructionLabel("Or press down to destroy it!", 30);
                addObject(instruction , 200 , 400);
                CopyMeteorite tutorialMeteorite = new CopyMeteorite();
                addObject( tutorialMeteorite , 200 , 100);
            }
            if(getObjects(CopyMeteorite.class).isEmpty() && count < 1)
            {
                count = 1 ;
                
            }
            else
            {
                isPhaseDone[3] = true ;
            }
           
            count = 0 ;
        }
        
    }
    
    
    /// below code are th ecopy of the MyWorld , mainly the functions of the game
    public void creatBullets()
    {
        if (Greenfoot.isKeyDown("space") && bulletCooldown == 0)
        
        {
            
            CopyBullets bul = new CopyBullets();
            Greenfoot.playSound("fire.mp3");
            int x = jet.getX() ;
            int y = jet.getY() - 30;
            
            addObject(bul , x , y );
            
            bulletCooldown = 20 ;
            
        }
        
        
        if(Greenfoot.isKeyDown("down") && energy > 0 && energyStore == 0)
        {
            CopySkill bom = new CopySkill();
            Greenfoot.playSound("lazer.mp3");
            int x = jet.getX() ;
            int y = jet.getY() ;
            addObject(bom , x, y);
            energy--;
            elec--;
            energyStore = 60;
            
            
        }
    }
}
