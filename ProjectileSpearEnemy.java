import greenfoot.*;
public class ProjectileSpearEnemy extends ProjectileEnemy
{
    public ProjectileSpearEnemy(Actor target)
    {
        super(3, 2, "single");
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
