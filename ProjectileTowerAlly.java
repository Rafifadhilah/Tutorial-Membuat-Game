import greenfoot.*;
public class ProjectileTowerAlly extends ProjectileAlly
{
    public ProjectileTowerAlly(Actor target)
    {
        super(18, 2, "single");
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
