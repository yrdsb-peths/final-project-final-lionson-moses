import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Label in Instruction
 * 
 * @Moses and Lionon 
 * @v1.0
 */
public class InstructionLabel extends Actor
{
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.PINK;
    
    private static final Color transparent = new Color(0,0,0,0);
    
    public int coolDown = 90 ;
    
    public double fade = 255 ;
    /**
     * Act - do whatever the InstructionLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Fade();
    }
    //this method makes the label show up for some time and disappear.
    
    public void Fade() 
     {
        if (fade > 0) 
        {
            if (fade >  200)
            {
                fade -= 0.5; 
                getImage().setTransparency( (int)fade ); 
            }
            else
            {
                fade -= 4 ;
                getImage().setTransparency( (int)fade ); 
            }
        } 
        
        else 
        {
            getImage().setTransparency(0); 
        }
        }
    public InstructionLabel(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }
    
    /**
     * Create a new label, initialise it with the needed text and the font size 
     */
    public InstructionLabel(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }

    /**
     * Sets the value  as text
     * 
     * @param value the text to be show
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    
    /**
     * Sets the value as integer
     * 
     * @param value the value to be show
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    
    /**
     * Sets the line color of the text
     * 
     * @param lineColor the line color of the text
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    
    /**
     * Sets the fill color of the text
     * 
     * @param fillColor the fill color of the text
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
}
