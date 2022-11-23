import greenfoot.*;
public class ProjectileAlly extends Projectile
{
    TroopEnemy enemy;
    TowerEnemy tower;
    public ProjectileAlly(int damage, int speed, String type)
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
        if(enemy != null && enemy.getWorld() != null)
        {
            turnTowards(enemy.getX(), enemy.getY());
            if(intersects(enemy))
                enemy.hp -= damage;
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
        if((enemy != null && enemy.getWorld() != null))
        {
            turnTowards(enemy.getX(), enemy.getY());
            if(intersects(enemy))
            {
                for (TroopEnemy enemy : getObjectsInRange(40, TroopEnemy.class))
                    enemy.hp -= damage;
                for (TowerEnemy tower : getObjectsInRange(40, TowerEnemy.class))
                    tower.hp -= damage;
            }
        }
        else if(tower != null && tower.getWorld() != null)
        {
            turnTowards(tower.getX(), tower.getY());
            if(intersects(tower))
            {
                for (TroopEnemy enemy : getObjectsInRange(40, TroopEnemy.class))
                    enemy.hp -= damage;
                for (TowerEnemy tower : getObjectsInRange(40, TowerEnemy.class))
                    tower.hp -= damage;
            }
        }
    }
    
    public void vanish()
    {
        time--;
        if(time == 0 ||
            isAtEdge() || 
            (enemy != null && (enemy.getWorld() == null || intersects(enemy))) || 
            (tower != null && (tower.getWorld() == null || intersects(tower))))
            getWorld().removeObject(this);
    }
}
