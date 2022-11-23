import greenfoot.*;
public class TroopEnemyGolem extends TroopEnemyGround
{
    public TroopEnemyGolem()
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
            for (TroopAlly ally : getObjectsInRange(35, TroopAlly.class))
                ally.hp -= 20;
            for (TowerAlly tower : getObjectsInRange(35, TowerAlly.class))
                tower.hp -= 20 * 2 / 3;
            getWorld().addObject(new TroopEnemyGolemite(), getX() - 5, getY());
            getWorld().addObject(new TroopEnemyGolemite(), getX() + 5, getY());
            getWorld().removeObject(this);
        }
    }
}
