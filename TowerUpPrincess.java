import greenfoot.*;
public class TowerUpPrincess extends TowerEnemyTower
{
    public TowerUpPrincess()
    {
        super(200, 45, 110);
    }
    
    public void act()
    {
        getWorld().showText("" + hp, getX(), getY() - 35);
        if(hp > 0)
            findEnemy();
        else
        {
            getWorld().addObject(new TowerDestroyed(), getX(), getY());
            getWorld().showText("", getX(), getY() - 35);
            ((ClashWorld)getWorld()).allyCrowns += 1;
            if(getX() == 95)
                getWorld().addObject(new ZoneTroopsPlaceLeft(), 115, 220);
            else
                getWorld().addObject(new ZoneTroopsPlaceRight(), 290, 220);
            getWorld().removeObject(this);
        }
    }
}
