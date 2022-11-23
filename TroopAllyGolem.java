import greenfoot.*;
public class TroopAllyGolem extends TroopAllyGround
{
    public TroopAllyGolem()
    {
        super(420, 18, 30, 1, 2, 77);
        imageNumber = 26;
        troopName = "Golem";
        target = "tower";
        specialDeath = true;
    }
    
    public void act()
    {
        super.act();
        checkHealth();
    }
    
    @Override
    public void checkHealth()
    {
        if(hp <= 0)
        {
            for (TroopEnemy enemy : getObjectsInRange(35, TroopEnemy.class))
                enemy.hp -= 20;
            for (TowerEnemy tower : getObjectsInRange(35, TowerEnemy.class))
                tower.hp -= 20 * 2 / 3;
            getWorld().addObject(new TroopAllyGolemite(), getX() - 5, getY());
            getWorld().addObject(new TroopAllyGolemite(), getX() + 5, getY());
            getWorld().removeObject(this);
        }
    }
}
