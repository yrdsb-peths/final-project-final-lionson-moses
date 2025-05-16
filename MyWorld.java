import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(250, 500, 1);
        
        Jet jetA = new Jet();
        addObject(jetA , 125 , 400 );
        
        if(Greenfoot.isKeyDown("space"))
        {
            Bullets Bul = new Bullets();
            int x = jetA.getX();
            int y = jetA.getY();
            addObject(Bul , x , y);
        }

        
        
    }
}
