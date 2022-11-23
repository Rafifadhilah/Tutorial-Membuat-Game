import greenfoot.*;
public class MenuScreenMainText extends Actor
{
    int time = 10;
    int speed = 20;
    int speedTime = 3;
    boolean entryFinished;
    GreenfootImage image = getImage();
    public MenuScreenMainText()
    {
        image.scale(10, 10);
    }
    
    public void act()
    {
        time += speed;
        if(!entryFinished)
        {
            if(speed > 1)
            {
                speedTime--;
                if(speedTime == 0)
                {
                    speed--;
                    speedTime = 3;
                }
            }
            if(time < 600)
            {
                image.scale(time, time);
                GreenfootImage image1 = new GreenfootImage("ScreenText.png");
                image1.scale(image.getHeight() + 10, image.getWidth() + 10);
                setImage(image1);
            }
            else
            {
                time = 594;
                speed = 3;
                entryFinished = true;
            }
        }
        else
        {
            time += speed;
            if(time == 600)
                speed = -speed;
            if(time == 396)
                speed = -speed;
            image.scale(time, time);
            GreenfootImage image1 = new GreenfootImage("ScreenText.png");
            image1.scale(image.getHeight() + speed, image.getWidth() + speed);
            setImage(image1);
        }
    }
}
