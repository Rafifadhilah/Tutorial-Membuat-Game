import greenfoot.*;
public class TowerUpKing extends TowerEnemyTower
{
    public TowerUpKing()
    {
        super(300, 40, 120);
    }
    
    public void act()
    {
        getWorld().showText("" + hp, getX(), getY() - 35);
        if(hp > 0 && (hp < basehp || !getObjectsInRange(200, TowerDestroyed.class).isEmpty()))
            findEnemy();
        else if(hp <= 0)
        {
            getWorld().addObject(new TowerDestroyed(), getX(), getY());
            getWorld().showText("", getX(), getY() - 35);
            ((ClashWorld)getWorld()).allyCrowns = 3;
            getWorld().removeObject(this);
        }
    }
}
