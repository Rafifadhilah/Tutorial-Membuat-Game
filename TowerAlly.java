import greenfoot.*;
public class TowerAlly extends Tower
{
    TroopEnemy enemy;
    TroopEnemyGround enemyGround;
    public void findEnemy()
    {
        distance = 0;
        if(!getObjectsInRange(range, TroopEnemy.class).isEmpty())
        {
            if(enemy == null || enemy.getWorld() == null)
                enemy = (TroopEnemy)getObjectsInRange(range, TroopEnemy.class).get(0);
            
            distance += Math.pow(Math.abs(enemy.getY() - getY()), 2);
            distance += Math.pow(Math.abs(enemy.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                if(this.getClass() == TowerDownPrincess.class)
                    projectile = new ProjectileTowerAlly(enemy);
                else if(this.getClass() == TowerDownKing.class)
                    projectile = new ProjectileKingAlly(enemy);
                createProjectile(projectile, enemy);
            }
            else
                enemy = (TroopEnemy)getObjectsInRange(range, TroopEnemy.class).get(0);
        }
    }
    
    public void findEnemyGround()
    {
        distance = 0;
        if(!getObjectsInRange(range, TroopEnemyGround.class).isEmpty())
        {
            if(enemyGround == null || enemyGround.getWorld() == null)
                enemyGround = (TroopEnemyGround)getObjectsInRange(range, TroopEnemyGround.class).get(0);
            turnTowards(enemyGround.getX(), enemyGround.getY());
            
            distance += Math.pow(Math.abs(enemyGround.getY() - getY()), 2);
            distance += Math.pow(Math.abs(enemyGround.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                if(this.getClass() == TowerDownCannon.class)
                    projectile = new ProjectileCannonAlly(enemyGround);
                createProjectile(projectile, enemy);
            }
            else
                enemyGround = (TroopEnemyGround)getObjectsInRange(range, TroopEnemyGround.class).get(0);
            
            if(this.getClass() == TowerDownCannon.class)
                turn(90);
        }
    }
    
    public void createProjectile(Projectile Projectile, TroopEnemy enemy)
    {
        attackTime--;
        if(attackTime == 0)
        {
            getWorld().addObject(projectile, getX(), getY());
            attackTime = attackSpeed;
        }
    }
}
