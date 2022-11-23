import greenfoot.*;
public class ElixirBar extends Overlay
{
    double elixir = 1;
    double elixirSpeed = 0.012;
    int size;
    GreenfootImage image = getImage();
    public ElixirBar()
    {
        image.scale(35, 23);
    }
    
    public void act()
    {
        if(size < 350)
            changeSize();
        setLocation(46 + (size / 2), 570);
        getWorld().showText("" + (int)elixir, 32, 570);
    }
    
    public void changeSize()
    {
        size = ((int)(elixir * 34)) + 1;
        if(elixir < 10)
            elixir += elixirSpeed;
        image.scale(size, 23);
    }
    
    public void useElixir(int amount)
    {
        if(elixir >= amount)
            elixir -= amount;
    }
}
