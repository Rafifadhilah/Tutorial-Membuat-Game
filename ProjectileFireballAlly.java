import greenfoot.*;
public class ProjectileFireballAlly extends ProjectileAlly
{
    public ProjectileFireballAlly(Actor target)
    {
        super(10, 2, "zone");
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
