import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * How to play the game, press "tab" to start
 * 
 * @Moses and Lionson
 * @v1.0
 */
public class Instruction extends World
{
    private int bulletCooldown = 0 ;
    private Jet jet ;    
    private int energyStore = 0;
    public int energy = 100;
    public int elec = 100;
    public boolean upgrades = false;
    
    public int count = 0 ;
    
    public boolean isPhase1done = false;
    boolean[] isPhaseDone ={false , false , false , false};
    public Instruction()
    {    
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
        //four instrction line appear
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
        InstructionLabel instruction = new InstructionLabel("Now press space to start the game!", 28);
        InstructionLabel instruction2 = new InstructionLabel("Don't let the bugs touch your jet or escape!", 23);
        addObject(instruction , 200 , 500);
        addObject(instruction2 , 200, 370);
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
                addObject( tutorialMeteorite , 200 , 20);
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
                InstructionLabel instructionup = new InstructionLabel("press up to upgrade your jet!", 30);
                InstructionLabel instruction = new InstructionLabel("Or press down to destroy it!", 30);
                addObject(instruction , 200 , 400);
                addObject(instructionup , 200 , 300);
                CopyMeteorite tutorialMeteorite = new CopyMeteorite();
                addObject( tutorialMeteorite , 200 , 20);
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
            int x1 = jet.getX() ;
            int y = jet.getY() - 30;
            int x2 = jet.getX();
            
            bulletCooldown = 20 ;
            if(upgrades == true)
            {
                CopyBullets bul2 = new CopyBullets();
                addObject(bul2 , x2 + 10 , y );
                x1 -= 10 ;
            }
            addObject(bul , x1 , y );
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
        
        if(Greenfoot.isKeyDown("up") && upgrades == false)
        {
            upgrades = true;
        }
    }
}
