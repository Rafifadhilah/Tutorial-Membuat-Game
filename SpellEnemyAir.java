import greenfoot.*;
public class SpellEnemyAir extends SpellEnemy
{
    public SpellEnemyAir(int damage, int radius, int spriteTime, int moveImageNumber, int attackImageNumber, String type)
    {
        this.damage = damage;
        this.radius = radius;
        this.spriteTime = spriteTime;
        this.spriteSpeed = spriteTime;
        this.moveImageNumber = moveImageNumber;
        this.attackImageNumber = attackImageNumber;
        this.type = type;
    }
}
