import greenfoot.*;
public class ProjectileArrowEnemy extends ProjectileEnemy
{
    public ProjectileArrowEnemy(Actor target)
    {
        super(5, 2, "single");
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
