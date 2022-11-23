import greenfoot.*;
public class MenuDeckText extends Actor
{
    int time = 10;
    int speed = 20;
    int speedTime = 3;
    GreenfootImage image = getImage();
    public MenuDeckText()
    {
        image.scale(10, 10);
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
        if(time < 600)
        {
            image.scale(time, time);
            GreenfootImage image1 = new GreenfootImage("MenuText.png");
            image1.scale(image.getHeight() + speed, image.getWidth() + speed);
            setImage(image1);
        }
    }
}
