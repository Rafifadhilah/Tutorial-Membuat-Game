import greenfoot.*;
public class ProjectileEnemy extends Projectile
{
    TroopAlly ally;
    TowerAlly tower;
    public ProjectileEnemy(int damage, int speed, String type)
    {
        this.damage = damage;
        this.speed = speed;
        this.time = 50;
        this.type = type;
    }
    
    public void act()
    {
        move(speed);
        if(type.equals("single"))
            attackEnemy();
        else
            attackZoneEnemy();
        vanish();
    }
    
    public void attackEnemy()
    {
        if(ally != null && ally.getWorld() != null)
        {
            turnTowards(ally.getX(), ally.getY());
            if(intersects(ally))
                ally.hp -= damage;
        }
        else if(tower != null && tower.getWorld() != null)
        {
            turnTowards(tower.getX(), tower.getY());
            if(intersects(tower))
                tower.hp -= damage;
        }
    }
    
    public void attackZoneEnemy()
    {
        if((ally != null && ally.getWorld() != null))
        {
            turnTowards(ally.getX(), ally.getY());
            if(intersects(ally))
            {
                for (TroopAlly ally : getObjectsInRange(40, TroopAlly.class))
                    ally.hp -= damage;
                for (TowerAlly tower : getObjectsInRange(50, TowerAlly.class))
                    tower.hp -= damage;
            }
        }
        else if(tower != null && tower.getWorld() != null)
        {
            turnTowards(tower.getX(), tower.getY());
            if(intersects(tower))
            {
                for (TroopAlly ally : getObjectsInRange(40, TroopAlly.class))
                    ally.hp -= damage;
                for (TowerAlly tower : getObjectsInRange(50, TowerAlly.class))
                    tower.hp -= damage;
            }
        }
    }
    
    public void vanish()
    {
        time--;
        if(time == 0 ||
            isAtEdge() || 
            (ally != null && (ally.getWorld() == null || intersects(ally))) || 
            (tower != null && (tower.getWorld() == null || intersects(tower))))
            getWorld().removeObject(this);
    }
}
