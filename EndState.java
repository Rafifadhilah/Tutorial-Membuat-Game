import greenfoot.*;
public class EndState extends Overlay
{
    int time = 10;
    int speed = 14;
    int speedTime = 3;
    String img;
    GreenfootImage image;
    public EndState(int state)
    {
        switch(state)
        {
            case 0 : img = "EndDraw.png";
                break;
            case 1 : img = "EndVictory.png";
                break;
            case 2 : img = "EndDefeat.png";
                break;
        }
        image = new GreenfootImage(img);
    }
    
    public void act()
    {
        time += speed;
        if(speed > 1)
        {
            speedTime--;
            if(speedTime == 0)
            {
                speed--;
                speedTime = 3;
            }
        }
        if(time < 300)
        {
            image.scale(time, time);
            GreenfootImage image1 = new GreenfootImage(img);
            image1.scale(image.getHeight() + speed, image.getWidth() + speed);
            setImage(image1);
        }
        
        if(time == 450)
            Greenfoot.setWorld(new ScreenMainWorld());
    }
}
