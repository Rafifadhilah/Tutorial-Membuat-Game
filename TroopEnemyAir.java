import greenfoot.*;
public class TroopEnemyAir extends TroopEnemy
{
    public TroopEnemyAir(int hp, int attack, int range, int speed, int timeSpeed, int attackTime)
    {
        this.hp = hp;
        this.attack = attack;
        this.range = range;
        this.speed = speed;
        this.baseSpeed = speed;
        this.timeSpeed = timeSpeed;
        this.speedSpeed = timeSpeed;
        this.spriteTime = attackTime;
        this.attackTime = attackTime;
        this.attackSpeed = attackTime;
        health = new HealthBar(this, false);
    }
}
