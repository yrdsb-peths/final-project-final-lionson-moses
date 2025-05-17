import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() 
    {
        super(250, 500, 1);
        
        
        Jet jetA = new Jet();
        addObject(jetA , 125 , 400 );
        
        creatBullets();
        spawn();
        
       
    }    
    ///this creats bullets, 
    ///they spawn with the same location as the jet class.
    public void creatBullets()
    {
        Bullets bul = new Bullets();
        if(Greenfoot.isKeyDown("space")) 
        /*
         * it seems there's some problems with this if statement, 
         * it couldn't run properly.
         * there's also difficulty in terms if getting the location of the jet
         * my suggestion is set the origional location of creat bullet 
         * as the same as the jet. 
         * and then copy the code of the jet class "fly()". 
         * so the bullet moves as same as jet.
         */
        {
            
            addObject(bul , 200 , 200);
        }
       
    }
    
    ///this spawns bugs
    public void spawn()
    {
        
        if (getObjects(Bugs.class).isEmpty()) //(buged, need to be fixed)

        {
            /// below part works fine, only the "if statement " is bugged
            for(int i = 0 ; i < 5 ; i++)
            {  
               creatBugs();
            }
        }
    }
    public void creatBugs()
    {
        Bugs bug = new Bugs();
        int x = Greenfoot.getRandomNumber(250);
        int y = 100 ;
        addObject(bug , x, y );
        
    }
}
