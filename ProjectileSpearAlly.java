import greenfoot.*;
public class ProjectileSpearAlly extends ProjectileAlly
{
    public ProjectileSpearAlly(Actor target)
    {
        super(3, 2, "single");
        if(target instanceof Tower)
            this.tower = (TowerEnemy)target;
        else
            this.enemy = (TroopEnemy)target;
    }
    
    public void act()
    {
        super.act();
    }
}
