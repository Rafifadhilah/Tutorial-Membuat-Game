import greenfoot.*;
public class TowerEnemyTower extends TowerEnemy
{
    public TowerEnemyTower(int hp, int attackTime, int range)
    {
        this.hp = hp;
        this.basehp = hp;
        this.range = range;
        this.attackTime = attackTime;
        this.attackSpeed = attackTime;
    }
}
