import greenfoot.*;
public class TroopAllyGolemite extends TroopAllyGround
{
    public TroopAllyGolemite()
    {
        super(50, 4, 25, 1, 2, 77);
        imageNumber = 26;
        troopName = "Golemite";
        target = "tower";
        specialDeath = true;
    }
    
    public void act()
    {
        super.act();
        checkHealth();
    }
    
    public void checkHealth()
    {
        if(hp <= 0)
        {
            for (TroopEnemy enemy : getObjectsInRange(35, TroopEnemy.class))
                enemy.hp -= 10;
            for (TowerEnemy tower : getObjectsInRange(35, TowerEnemy.class))
                tower.hp -= 10 * 2 / 3;
            getWorld().removeObject(this);
        }
    }
}
