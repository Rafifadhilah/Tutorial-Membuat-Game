import greenfoot.*;
public class ProjectileFireballEnemy extends ProjectileEnemy
{
    public ProjectileFireballEnemy(Actor target)
    {
        super(10, 2, "zone");
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
