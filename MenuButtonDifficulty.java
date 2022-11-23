import greenfoot.*;
public class MenuButtonDifficulty extends Actor
{
    GreenfootImage diffImage;
    String difficulty;
    int speed = 10;
    int time = 100;
    int endTime;
    public MenuButtonDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
        diffImage = new GreenfootImage("Button" + difficulty + ".png");
        setImage(diffImage);
    }
    
    public void act()
    {
        arrival();
        checkClick();
    }
    
    public void arrival()
    {
        if(getY() < 310 && endTime < 20)
            setLocation(getX(), getY() + speed);
        else if(endTime < 20)
        {
            endTime++;
            if(time % 20 == 0)
            {
                speed--;
                setLocation(getX(), getY() + speed);
            }
        }
    }
    
    public void checkClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            switch(difficulty)
            {
                case "Hard" : ClashWorld.diff = 1.5;
                    break;
                case "Medium" : ClashWorld.diff = 1;
                    break;
                case "Easy" : ClashWorld.diff = 0.5;
                    break;
            }
            Greenfoot.setWorld(new DeckMenuWorld());
        }
    }
}
