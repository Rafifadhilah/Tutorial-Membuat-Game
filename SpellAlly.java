import greenfoot.*;
public class SpellAlly extends Spell
{
    public void act()
    {
        if(type.equals("MoveToTarget"))
        {
            turnTowards(directionX, directionY);
            move(5);
            if(Math.abs(getY() - directionY) < 5 && 
                Math.abs(getX() - directionX) < 5 &&
                !isUsed)
            {
                spriteTime = 0;
                isBattling = true;
                isUsed = true;
            }
            changeSprite();
            setRotation(0);
        }
        else if(type.equals("ZoneDuration"))
        {
            time--;
            changeSprite();
            if(time % 20 == 0)
                doZoneDamage();
            if(time == 0)
                getWorld().removeObject(this);
        }
    }
    
    public void findEnemy()
    {
        for (TroopEnemy enemy : getObjectsInRange(radius, TroopEnemy.class))
            enemy.hp -= damage;
        for (TowerEnemy tower : getObjectsInRange(radius, TowerEnemy.class))
            tower.hp -= damage * 2 / 3;
    }
    
    public void doZoneDamage()
    {
        for(TroopEnemy enemy : getObjectsInRange(radius, TroopEnemy.class))
            enemy.hp -= damage * 2;
        for(TowerEnemy tower : getObjectsInRange(radius, TowerEnemy.class))
            tower.hp -= damage;
    }
    
    public void changeSprite()
    {
        if(type.equals("MoveToTarget"))
        {
            int sprite = (spriteTime - 2) / 3;
            spriteTime++;
            if(!isBattling)
                setImage(moveImages()[sprite]);
            else
                setImage(attackImages()[sprite]);
            if(spriteTime == spriteSpeed + 1)
                spriteTime = 0;
            if(isBattling && spriteTime == 1)
                findEnemy();
            if(isBattling && sprite == attackImageNumber - 1)
                getWorld().removeObject(this);
        }
        else if(type.equals("ZoneDuration"))
        {
            int sprite = (spriteTime - 2) / 3;
            spriteTime++;
            setImage(attackImages()[sprite]);
            if(spriteTime == spriteSpeed + 1)
                spriteTime = 0;
        }
    }
    
    public GreenfootImage[] moveImages()
    {
        GreenfootImage[] images = new GreenfootImage[moveImageNumber];
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("Spell/" + spellName + "/" + spellName + "Move" + i + ".png");
        }
        return images;
    }
    
    public GreenfootImage[] attackImages()
    {
        GreenfootImage[] images = new GreenfootImage[attackImageNumber];
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("Spell/" + spellName + "/" + spellName + "Attack" + i + ".png");
        }
        return images;
    }
}
