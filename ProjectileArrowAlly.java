import greenfoot.*;
public class ProjectileArrowAlly extends ProjectileAlly
{
    public ProjectileArrowAlly(Actor target)
    {
        super(5, 2, "single");
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
