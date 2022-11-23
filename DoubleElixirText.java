import greenfoot.*;
public class DoubleElixirText extends Overlay
{
    int time = 10;
    int speed = 14;
    int speedTime = 3;
    GreenfootImage image = getImage();
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
            GreenfootImage image1 = new GreenfootImage("TextDoubleElixir.png");
            image1.scale(image.getHeight() + speed, image.getWidth() + speed);
            setImage(image1);
        }
        
        if(time == 400)
            getWorld().removeObject(this);
    }
}
