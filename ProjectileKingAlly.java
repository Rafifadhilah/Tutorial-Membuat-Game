import greenfoot.*;
public class ProjectileKingAlly extends ProjectileAlly
{
    public ProjectileKingAlly(Actor target)
    {
        super(25, 4, "single");
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
