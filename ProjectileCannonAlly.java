import greenfoot.*;
public class ProjectileCannonAlly extends ProjectileAlly
{
    public ProjectileCannonAlly(Actor target)
    {
        super(8, 4, "single");
        if(target instanceof Tower)
            this.tower = (TowerEnemy)target;
        else
            this.enemy = (TroopEnemyGround)target;
    }
    
    public void act()
    {
        super.act();
    }
}
