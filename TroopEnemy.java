import greenfoot.*;
public class TroopEnemy extends Troop
{
    TroopAlly ally;
    TowerAlly tower;
    public void act()
    {
        getWorld().addObject(health, getX(), getY() - 20);
        findEnemy();
        movement();
        changeSprite();
        if(!specialDeath)
            checkHealth();
        if(oneDirection)
            setRotation(180);
        else
            turn(180);
    }
    
    public void findEnemy()
    {
        speed = baseSpeed;
        oneDirection = true;
        distance = 0;
        if(getObjectsInRange(range, TroopAlly.class).isEmpty())
            isBattlingTroop = false;
        if(getObjectsInRange(range, TroopAlly.class).isEmpty())
            isBattlingTower = false;
        
        if(!getObjectsInRange(120, TroopAlly.class).isEmpty() &&
            !isBattlingTower &&
            range > 30 &&
            target.equals("all"))
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
                    createProjectile(ally);
            }
        }
        else if(!getObjectsInRange(120, TroopAllyGround.class).isEmpty() &&
            !((getObjectsInRange(120, TroopAllyGround.class).get(0).getY() < 300) &&
            (getObjectsInRange(120, TroopAllyGround.class).get(0).getY() > 250) &&
            (getObjectsInRange(120, TroopAllyGround.class).get(0).getX() > 100) &&
            (getObjectsInRange(120, TroopAllyGround.class).get(0).getX() < 300) &&
            (getY() > 200) && (getY() < 250) && (getX() > 100) && (getX() < 300)) && 
            !isBattlingTower &&
            target.equals("ground"))
        {
            if(ally == null || ally.getWorld() == null)
                ally = (TroopAllyGround)getObjectsInRange(120, TroopAllyGround.class).get(0);
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
                {
                    attack(ally);
                    attackTime = attackSpeed;
                }
            }
        }
        else if(!getObjectsInRange(100, TowerAlly.class).isEmpty() && 
            !isBattlingTroop &&
            range > 30)
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
                    createProjectile(tower);
            }
        }
        else if(!getObjectsInRange(100, TowerAlly.class).isEmpty() && 
            !isBattlingTroop)
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
                    attackTower(tower);
            }
        }
        else if(getY() < 250 && getX() <= 200 && !(this instanceof TroopEnemyAir))
        {
            turnTowards(100 + random, 250);
        }
        else if(getY() < 250 && getX() > 200 && !(this instanceof TroopEnemyAir))
        {
            turnTowards(300 + random, 250);
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
    
    public void attack(TroopAlly ally)
    {
        ally.hp -= attack;
        attackTime = attackSpeed;
    }
    
    public void attackTower(TowerAlly tower)
    {
        tower.hp -= attack;
        attackTime = attackSpeed;
    }
    
    public void createProjectile(TroopAlly ally)
    {
        if(this.getClass() == TroopEnemyArcher.class)
            getWorld().addObject(new ProjectileArrowEnemy(ally), getX(), getY());
        else if(this.getClass() == TroopEnemyGoblinSpear.class)
            getWorld().addObject(new ProjectileSpearEnemy(ally), getX(), getY());
        else if(this.getClass() == TroopEnemyDragonBaby.class)
            getWorld().addObject(new ProjectileFireballEnemy(ally), getX(), getY());
        attackTime = attackSpeed;
    }
    
    public void createProjectile(TowerAlly tower)
    {
        if(this.getClass() == TroopEnemyArcher.class)
            getWorld().addObject(new ProjectileArrowEnemy(tower), getX(), getY());
        else if(this.getClass() == TroopEnemyGoblinSpear.class)
            getWorld().addObject(new ProjectileSpearEnemy(tower), getX(), getY());
        else if(this.getClass() == TroopEnemyDragonBaby.class)
            getWorld().addObject(new ProjectileFireballEnemy(tower), getX(), getY());
        attackTime = attackSpeed;
    }
}
