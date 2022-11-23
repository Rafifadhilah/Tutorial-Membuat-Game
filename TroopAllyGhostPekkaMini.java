import greenfoot.*;
public class TroopAllyGhostPekkaMini extends TroopAllyGhost
{
    public TroopAllyGhostPekkaMini()
    {
        super(4, "troop", "PekkaMini");
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
                getWorld().addObject(new TroopAllyPekkaMini(), getX(), getY());
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
