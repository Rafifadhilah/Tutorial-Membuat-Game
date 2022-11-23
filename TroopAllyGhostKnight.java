import greenfoot.*;
public class TroopAllyGhostKnight extends TroopAllyGhost
{
    public TroopAllyGhostKnight()
    {
        super(3, "troop", "Knight");
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
                getWorld().addObject(new TroopAllyKnight(), getX(), getY());
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
