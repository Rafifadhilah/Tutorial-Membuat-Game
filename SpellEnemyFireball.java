import greenfoot.*;
import java.util.List;
public class SpellEnemyFireball extends SpellEnemyAir
{
    public SpellEnemyFireball(int x, int y)
    {
        super(40, 60, 38, 13, 9, "MoveToTarget");
        this.spellName = "Fireball";
        directionX = x;
        directionY = y;
    }
    
    public void act()
    {
        super.act();
    }
}
