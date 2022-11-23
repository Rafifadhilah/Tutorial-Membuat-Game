import greenfoot.*;
public class ZoneTroopsOverlay extends Overlay
{
    GreenfootImage start = new GreenfootImage("ZoneUnitsStart.png");
    GreenfootImage left = new GreenfootImage("ZoneUnitsLeft.png");
    GreenfootImage right = new GreenfootImage("ZoneUnitsRight.png");
    GreenfootImage full = new GreenfootImage("ZoneUnitsFull.png");
    TowerDestroyed bruh;
    public ZoneTroopsOverlay()
    {
        setImage((GreenfootImage)null);
    }
    
    public void act()
    {
        checkTowers();
    }
    
    public void checkTowers()
    {
        if(getObjectsInRange(600, TroopAllyGhost.class).isEmpty())
            setImage((GreenfootImage)null);
        else if(!getObjectsInRange(600, TroopAllyGhost.class).isEmpty() &&
            (getObjectsInRange(600, TroopAllyGhost.class).get(0).type.equals("troop") ||
            getObjectsInRange(600, TroopAllyGhost.class).get(0).type.equals("tower")))
        {
            if(!getWorld().getObjectsAt(95, 130, TowerDestroyed.class).isEmpty() &&
                !getWorld().getObjectsAt(305, 130, TowerDestroyed.class).isEmpty())
            {
                setImage(full);
            }
            else if(!getWorld().getObjectsAt(95, 130, TowerDestroyed.class).isEmpty())
                setImage(left);
            else if(!getWorld().getObjectsAt(305, 130, TowerDestroyed.class).isEmpty())
                setImage(right);
            else
                setImage(start);
        }
        else
            setImage((GreenfootImage)null);
    }
}
