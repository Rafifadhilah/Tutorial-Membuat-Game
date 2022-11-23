import greenfoot.*;
public class SpellEnemyGround extends SpellEnemy
{
    public SpellEnemyGround(int damage, int radius, int spriteTime, int time, int attackImageNumber, String type)
    {
        this.damage = damage;
        this.radius = radius;
        this.spriteTime = spriteTime;
        this.spriteSpeed = spriteTime;
        this.time = time;
        this.attackImageNumber = attackImageNumber;
        this.type = type;
    }
}
