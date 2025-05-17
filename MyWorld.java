import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() 
    {
        super(250, 500, 1);
        
        Jet jetA = new Jet();
        addObject(jetA , 125 , 400 );
        /*
        if(Greenfoot.isKeyDown("space"))
        {
            Bullets Bul = new Bullets();
            int x = jetA.getX();
            int y = jetA.getY();
            addObject(Bul , x , y);
        }
        */
        spawn();
        
       
    }    
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
