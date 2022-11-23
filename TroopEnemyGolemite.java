import greenfoot.*;
public class TroopEnemyGolemite extends TroopEnemyGround
{
    public TroopEnemyGolemite()
    {
        super(50, 4, 25, 1, 2, 77);
        imageNumber = 26;
        troopName = "Golemite";
        target = "all";
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
            for (TroopAlly ally : getObjectsInRange(35, TroopAlly.class))
                ally.hp -= 10;
            for (TowerAlly tower : getObjectsInRange(35, TowerAlly.class))
                tower.hp -= 10 * 2 / 3;
            getWorld().removeObject(this);
        }
    }
}
