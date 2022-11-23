import greenfoot.*;
public class ProjectileTowerEnemy extends ProjectileEnemy
{
    public ProjectileTowerEnemy(Actor target)
    {
        super(18, 2, "single");
        if(target instanceof Tower)
            this.tower = (TowerAlly)target;
        else
            this.ally = (TroopAlly)target;
    }
    
    public void act()
    {
        super.act();
    }
}
