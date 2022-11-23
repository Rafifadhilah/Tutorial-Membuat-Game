import greenfoot.*;
public class TowerDownCannon extends TowerAllyBuilding
{
    TroopEnemyGround enemy;
    TowerBaseCannon base;
    public TowerDownCannon(TowerBaseCannon base)
    {
        super(50, 40, 100, 50);
        this.base = base;
    }
    
    public void act()
    {
        getWorld().addObject(health, getX(), getY() - 20);
        decay();
        
        if(hp > 0)
            findEnemyGround();
        else
        {
            getWorld().removeObject(base);
            getWorld().removeObject(this);
        }
    }
}
