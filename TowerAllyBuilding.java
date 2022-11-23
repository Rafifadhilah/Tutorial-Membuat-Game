import greenfoot.*;
public class TowerAllyBuilding extends TowerAlly
{
    int decayTime;
    int decaySpeed;
    HealthBar health;
    public TowerAllyBuilding(int hp, int attackTime, int range, int decayTime)
    {
        this.hp = hp;
        this.basehp = hp;
        this.range = range;
        this.attackTime = attackTime;
        this.attackSpeed = attackTime;
        this.decayTime = decayTime;
        this.decaySpeed = decayTime;
        health = new HealthBar(this, true);
    }
    
    public void decay()
    {
        decayTime--;
        if(decayTime == 0)
        {
            hp--;
            decayTime = decaySpeed;
        }
    }
}
