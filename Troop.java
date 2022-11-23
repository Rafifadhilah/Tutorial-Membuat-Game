import greenfoot.*;
class Troop extends Actor
{
    int hp;
    int attack;
    int range;
    int speed;
    int baseSpeed;
    int timeSpeed;
    int speedSpeed;
    int moveAtMaxSpeed;
    int spriteTime;
    int attackTime;
    int attackSpeed;
    int imageNumber;
    String troopName;
    String target;      
    boolean specialDeath;
    HealthBar health;
    int random = Greenfoot.getRandomNumber(20) - 10;
    boolean oneDirection;
    boolean isBattlingTroop;
    boolean isBattlingTower;
    int distance;
    public void changeSprite()
    {   
        int sprite = (spriteTime - 2) / 3;
        spriteTime++;
        if(!isBattlingTroop && !isBattlingTower)
            setImage(moveImages()[sprite]);
        else
            setImage(attackImages()[sprite]);
        if(spriteTime == attackSpeed + 1)
            spriteTime = 0;
    }
    
    public GreenfootImage[] moveImages()
    {
        GreenfootImage[] images = new GreenfootImage[imageNumber];
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("Troop/" + troopName + "/" + troopName +"Move" + i + ".png");
        }
        return images;
    }
    
    public GreenfootImage[] attackImages()
    {
        GreenfootImage[] images = new GreenfootImage[imageNumber];
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("Troop/" + troopName + "/" + troopName +"Attack" + i + ".png");
        }
        return images;
    }
    
    public void movement()
    {
        timeSpeed--;
        if(speed < 2)
        {
            if(timeSpeed == 0)
            {
                move(speed);
                timeSpeed = speedSpeed;
            }
        }
        else
        {
            if(timeSpeed == 0 && moveAtMaxSpeed > 0)
            {
                move(1);
                timeSpeed = speedSpeed;
                moveAtMaxSpeed--;
            }
            else if(timeSpeed == 0 && moveAtMaxSpeed == 0)
            {
                move(speed);
                timeSpeed = speedSpeed;
                moveAtMaxSpeed = 2;
            }
        }
    }
    
    public void checkHealth()
    {
        if(hp <= 0)
                getWorld().removeObject(this);
    }
}
