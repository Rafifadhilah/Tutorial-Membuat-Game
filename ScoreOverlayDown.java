import greenfoot.*;
public class ScoreOverlayDown extends Overlay
{
    GreenfootImage one = new GreenfootImage("Score1.png");
    GreenfootImage two = new GreenfootImage("Score2.png");
    GreenfootImage three = new GreenfootImage("Score3.png");
    public void act()
    {
        int score = ((ClashWorld)getWorld()).allyCrowns;
        if(score == 1)
            setImage(one);
        if(score == 2)
            setImage(two);
        if(score == 3)
            setImage(three);
    }
}
