import greenfoot.*;
public class ScreenMainWorld extends World
{
    public ScreenMainWorld()
    {
        super(1000, 600, 1);
        addObject(new Music(), 0, 0);
        addObject(new MenuScreenMainText(), 500, 500);
        addObject(new MenuScreenMainLogo(), 500, 350);
        Greenfoot.start();
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
            Greenfoot.setWorld(new DifficultyMenuWorld());
    }
}
