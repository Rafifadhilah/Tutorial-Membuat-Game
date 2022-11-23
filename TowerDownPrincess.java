import greenfoot.*;
public class TowerDownPrincess extends TowerAllyTower
{
    public TowerDownPrincess()
    {
        super(200, 45, 110);
    }
    
    public void act()
    {
        getWorld().showText("" + hp, getX(), getY() + 35);
        if(hp > 0)
            findEnemy();
        else
        {
            getWorld().addObject(new TowerDestroyed(), getX(), getY());
            getWorld().showText("", getX(), getY() + 35);
            ((ClashWorld)getWorld()).enemyCrowns += 1;
            getWorld().removeObject(this);
        }
    }
}
