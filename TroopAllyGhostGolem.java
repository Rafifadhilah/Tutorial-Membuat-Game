import greenfoot.*;
public class TroopAllyGhostGolem extends TroopAllyGhost
{
    public TroopAllyGhostGolem()
    {
        super(8, "troop", "Golem");
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
                getWorld().addObject(new TroopAllyGolem(), getX(), getY());
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
