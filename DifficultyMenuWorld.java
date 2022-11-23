import greenfoot.*;
public class DifficultyMenuWorld extends World
{
    int time;
    public DifficultyMenuWorld()
    {
        super(1000, 600, 1);
        addObject(new Music(), 0, 0);
    }
    
    public void act()
    {
        time++;
        if(time == 1)
            addObject(new MenuButtonDifficulty("Easy"), 155, 00);
        else if(time == 21)
            addObject(new MenuButtonDifficulty("Medium"), 500, 00);
        else if(time == 41)
            addObject(new MenuButtonDifficulty("Hard"), 845, 00);
    }
}
