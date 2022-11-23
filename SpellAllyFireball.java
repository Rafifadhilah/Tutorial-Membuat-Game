import greenfoot.*;
import java.util.List;
public class SpellAllyFireball extends SpellAllyAir
{
    public SpellAllyFireball(int x, int y)
    {
        super(40, 50, 38, 13, 9, "MoveToTarget");
        this.spellName = "Fireball";
        directionX = x;
        directionY = y;
    }
    
    public void act()
    {
        super.act();
    }
}
