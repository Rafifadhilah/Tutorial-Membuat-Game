import greenfoot.*;
public class TowerDownKing extends TowerAllyTower
{
    public TowerDownKing()
    {
        super(300, 40, 120);
    }
    
    public void act()
    {
        getWorld().showText("" + hp, getX(), getY() + 40);
        if(hp > 0 && (hp < basehp || !getObjectsInRange(200, TowerDestroyed.class).isEmpty()))
            findEnemy();
        else if(hp <= 0)
        {
            getWorld().addObject(new TowerDestroyed(), getX(), getY());
            getWorld().showText("", getX(), getY() + 40);
            ((ClashWorld)getWorld()).enemyCrowns = 3;
            getWorld().removeObject(this);
        }
    }
}
