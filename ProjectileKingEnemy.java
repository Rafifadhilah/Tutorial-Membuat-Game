import greenfoot.*;
public class ProjectileKingEnemy extends ProjectileEnemy
{
    public ProjectileKingEnemy(Actor target)
    {
        super(25, 4, "single");
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
