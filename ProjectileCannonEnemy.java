import greenfoot.*;
public class ProjectileCannonEnemy extends ProjectileEnemy
{
    public ProjectileCannonEnemy(Actor target)
    {
        super(8, 4, "single");
        if(target instanceof Tower)
            this.tower = (TowerAlly)target;
        else
            this.ally = (TroopAllyGround)target;
    }
    
    public void act()
    {
        super.act();
    }
}
