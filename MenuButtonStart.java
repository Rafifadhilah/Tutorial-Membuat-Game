import greenfoot.*;
public class MenuButtonStart extends Actor
{
    public MenuButtonStart()
    {
        getImage().scale(145, 91);
        getImage().setTransparency(50);
    }
    
    public void act()
    {
        boolean isComplete = true;
        for(int i = 0; i < ClashWorld.cardStart.length; i++)
        {
            if(ClashWorld.cardStart[i] == null)
                isComplete = false;
        }
        
        if(isComplete)
            getImage().setTransparency(250);
        else
            getImage().setTransparency(50);
        
        if(Greenfoot.mouseClicked(this) && isComplete)
            Greenfoot.setWorld(new ClashWorld());
    }
}
