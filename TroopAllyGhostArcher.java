import greenfoot.*;
public class TroopAllyGhostArcher extends TroopAllyGhost
{
    public TroopAllyGhostArcher()
    {
        super(3, "troop", "Archer");
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
                getWorld().addObject(new TroopAllyArcher(), getX() - 7, getY());
                getWorld().addObject(new TroopAllyArcher(), getX() + 7, getY());
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
