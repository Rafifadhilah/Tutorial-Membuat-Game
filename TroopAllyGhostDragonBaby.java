import greenfoot.*;
public class TroopAllyGhostDragonBaby extends TroopAllyGhost
{
    public TroopAllyGhostDragonBaby()
    {
        super(4, "troop", "DragonBaby");
    }
    
    public void act()
    {
        ElixirBar bar = getWorld().getObjects(ElixirBar.class).get(0);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(null != mouse)
        {
            setLocation(mouse.getX(),mouse.getY());
            if(Greenfoot.mouseClicked(this) && isTouching(ZoneTroopsPlace.class)
                && bar.elixir >= elixir)
            {
                getWorld().addObject(new TroopAllyDragonBaby(), getX(), getY());
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
