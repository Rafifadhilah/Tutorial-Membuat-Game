import greenfoot.*;
public class TowerEnemy extends Tower
{
    TroopAlly ally;
    TroopAllyGround allyGround;
    public void findEnemy()
    {
        distance = 0;
        if(!getObjectsInRange(range, TroopAlly.class).isEmpty())
        {
            if(ally == null || ally.getWorld() == null)
                ally = (TroopAlly)getObjectsInRange(range, TroopAlly.class).get(0);
            
            distance += Math.pow(Math.abs(ally.getY() - getY()), 2);
            distance += Math.pow(Math.abs(ally.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                if(this.getClass() == TowerUpPrincess.class)
                    projectile = new ProjectileTowerEnemy(ally);
                else if(this.getClass() == TowerUpKing.class)
                    projectile = new ProjectileKingEnemy(ally);
                createProjectile(projectile, ally);
            }
            else
                ally = (TroopAlly)getObjectsInRange(range, TroopAlly.class).get(0);
        }
    }
    
    public void findEnemyGround()
    {
        distance = 0;
        if(!getObjectsInRange(range, TroopAllyGround.class).isEmpty())
        {
            if(allyGround == null || allyGround.getWorld() == null)
                allyGround = (TroopAllyGround)getObjectsInRange(range, TroopAllyGround.class).get(0);
            turnTowards(allyGround.getX(), allyGround.getY());
            
            distance += Math.pow(Math.abs(allyGround.getY() - getY()), 2);
            distance += Math.pow(Math.abs(allyGround.getX() - getX()), 2);
            distance = (int)(Math.sqrt(distance));
            
            if(distance <= range)
            {
                if(this.getClass() == TowerUpCannon.class)
                    projectile = new ProjectileCannonEnemy(allyGround);
                createProjectile(projectile, ally);
            }
            else
                allyGround = (TroopAllyGround)getObjectsInRange(range, TroopAllyGround.class).get(0);
            
            if(this.getClass() == TowerUpCannon.class)
                turn(90);
        }
    }
    
    public void createProjectile(Projectile Projectile, TroopAlly ally)
    {
        attackTime--;
        if(attackTime == 0)
        {
            getWorld().addObject(projectile, getX(), getY());
            attackTime = attackSpeed;
        }
    }
}
