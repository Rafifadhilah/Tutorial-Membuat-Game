import greenfoot.*;
public class TroopAlly extends Troop
{
    TroopEnemy enemy;
    TowerEnemy tower;
    public void act()
    {
        getWorld().addObject(health, getX(), getY() - 20);
        findEnemy();
        movement();
        changeSprite();
        if(!specialDeath)
            checkHealth();
        if(oneDirection)
            setRotation(0);
        else
            turn(90);
    }
    
    public void findEnemy()
    {
        speed = baseSpeed;
        oneDirection = true;
        distance = 0;
        if(getObjectsInRange(range, TroopEnemy.class).isEmpty())
            isBattlingTroop = false;
        if(getObjectsInRange(range, TowerEnemy.class).isEmpty())
            isBattlingTower = false;
        
        if(!getObjectsInRange(120, TroopEnemy.class).isEmpty() &&
            !isBattlingTower &&
            range > 30 &&
            target.equals("all"))
        {
            if(enemy == null || enemy.getWorld() == null)
                enemy = (TroopEnemy)getObjectsInRange(120, TroopEnemy.class).get(0);
            turnTowards(enemy.getX(), enemy.getY());
            
            distance += Math.pow(Math.abs(enemy.getY() - getY()), 2);
            distance += Math.pow(Math.abs(enemy.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                isBattlingTroop = true;
                speed = 0;
                attackTime--;
                if(attackTime == 0)
                    createProjectile(enemy);
            }
        }
        else if(!getObjectsInRange(120, TroopEnemyGround.class).isEmpty() &&
            !((getObjectsInRange(120, TroopEnemyGround.class).get(0).getY() < 250) &&
            (getObjectsInRange(120, TroopEnemyGround.class).get(0).getY() > 200) &&
            (getObjectsInRange(120, TroopEnemyGround.class).get(0).getX() > 110) &&
            (getObjectsInRange(120, TroopEnemyGround.class).get(0).getX() < 290) &&
            (getY() > 250) && (getY() < 300) && (getX() > 100) && (getX() < 300)) &&
            !isBattlingTower &&
            target.equals("ground"))
        {
            if(enemy == null || enemy.getWorld() == null)
                enemy = (TroopEnemyGround)getObjectsInRange(120, TroopEnemyGround.class).get(0);
            turnTowards(enemy.getX(), enemy.getY());
            
            distance += Math.pow(Math.abs(enemy.getY() - getY()), 2);
            distance += Math.pow(Math.abs(enemy.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                isBattlingTroop = true;
                speed = 0;
                attackTime--;
                if(attackTime == 0)
                {
                    attack(enemy);
                    attackTime = attackSpeed;
                }
            }
        }
        else if(!getObjectsInRange(100, TowerEnemy.class).isEmpty() && 
            !isBattlingTroop &&
            range > 30)
        {
            if(tower == null || tower.getWorld() == null)
                tower = (TowerEnemy)getObjectsInRange(100, TowerEnemy.class).get(0);
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
        else if(!getObjectsInRange(100, TowerEnemy.class).isEmpty() && 
            !isBattlingTroop)
        {
            if(tower == null || tower.getWorld() == null)
                tower = (TowerEnemy)getObjectsInRange(100, TowerEnemy.class).get(0);
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
        else if(getY() > 250 && getX() <= 200 && !(this instanceof TroopAllyAir))
        {
            turnTowards(100 + random, 250);
        }
        else if(getY() > 250 && getX() > 200 && !(this instanceof TroopAllyAir))
        {
            turnTowards(300 + random, 250);
        }
        else if(!getObjectsInRange(50, TowerDestroyed.class).isEmpty() &&
            !getObjectsInRange(500, TowerUpKing.class).isEmpty())
        {
            TowerUpKing king = getWorld().getObjects(TowerUpKing.class).get(0);
            turnTowards(king.getX(), king.getY());
        }
        else
            setRotation(-90);
    }
    
    public void attack(TroopEnemy enemy)
    {
        enemy.hp -= attack;
        attackTime = attackSpeed;
    }
    
    public void attackTower(TowerEnemy tower)
    {
        tower.hp -= attack;
        attackTime = attackSpeed;
    }
    
    public void createProjectile(TroopEnemy enemy)
    {
        if(this.getClass() == TroopAllyArcher.class)
            getWorld().addObject(new ProjectileArrowAlly(enemy), getX(), getY());
        else if(this.getClass() == TroopAllyGoblinSpear.class)
            getWorld().addObject(new ProjectileSpearAlly(enemy), getX(), getY());
        else if(this.getClass() == TroopAllyDragonBaby.class)
            getWorld().addObject(new ProjectileFireballAlly(enemy), getX(), getY());
        attackTime = attackSpeed;
    }
    
    public void createProjectile(TowerEnemy tower)
    {
        if(this.getClass() == TroopAllyArcher.class)
            getWorld().addObject(new ProjectileArrowAlly(tower), getX(), getY());
        else if(this.getClass() == TroopAllyGoblinSpear.class)
            getWorld().addObject(new ProjectileSpearAlly(tower), getX(), getY());
        else if(this.getClass() == TroopAllyDragonBaby.class)
            getWorld().addObject(new ProjectileFireballAlly(tower), getX(), getY());
        attackTime = attackSpeed;
    }
}
