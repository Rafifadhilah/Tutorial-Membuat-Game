import greenfoot.*;
public class TroopEnemyDragonBaby extends TroopEnemyAir
{
    public TroopEnemyDragonBaby()
    {
        super(100, 10, 60, 1, 1, 47);
        imageNumber = 16;
        troopName = "DragonBaby";
        target = "all";
    }
    
    public void act()
    {
        getWorld().addObject(health, getX(), getY() - 20);
        findEnemy();
        movement();
        changeSprite();
        checkHealth();
        setRotation(180);
    }
    
    public void findEnemy()
    {
        speed = 1;
        distance = 0;
        if(getObjectsInRange(range, TroopAlly.class).isEmpty())
            isBattlingTroop = false;
        if(getObjectsInRange(range, TowerAlly.class).isEmpty())
            isBattlingTower = false;
        
        if(!getObjectsInRange(120, TroopAlly.class).isEmpty() && !isBattlingTower)
        {
            if(ally == null || ally.getWorld() == null)
                ally = (TroopAlly)getObjectsInRange(120, TroopAlly.class).get(0);
            turnTowards(ally.getX(), ally.getY());
            
            distance += Math.pow(Math.abs(ally.getY() - getY()), 2);
            distance += Math.pow(Math.abs(ally.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                isBattlingTroop = true;
                speed = 0;
                attackTime--;
                if(attackTime == 0)
                    createArrow(ally);
            }
        }
        else if(!getObjectsInRange(100, TowerAlly.class).isEmpty() && !isBattlingTroop)
        {
            if(tower == null || tower.getWorld() == null)
                tower = (TowerAlly)getObjectsInRange(100, TowerAlly.class).get(0);
            turnTowards(tower.getX(), tower.getY());
            
            distance += Math.pow(Math.abs(tower.getY() - getY()), 2);
            distance += Math.pow(Math.abs(tower.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                isBattlingTower = true;
                speed = 0;
                attackTime--;
                if(attackTime == 0)
                    createArrow(tower);
            }
        }
        else if(!getObjectsInRange(50, TowerDestroyed.class).isEmpty() &&
            !getObjectsInRange(500, TowerDownKing.class).isEmpty())
        {
            TowerDownKing king = getWorld().getObjects(TowerDownKing.class).get(0);
            turnTowards(king.getX(), king.getY());
        }
        else
            setRotation(90);
    }
    
    public void createArrow(TroopAlly ally)
    {
        getWorld().addObject(new ProjectileFireballEnemy(ally), getX(), getY());
        attackTime = attackSpeed;
    }
    
    public void createArrow(TowerAlly tower)
    {
        getWorld().addObject(new ProjectileFireballEnemy(tower), getX(), getY());
        attackTime = attackSpeed;
    }
}
