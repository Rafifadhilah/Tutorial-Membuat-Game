import greenfoot.*;
public class TroopAllyGhostPoison extends TroopAllyGhost
{
    public TroopAllyGhostPoison()
    {
        super(4, "spell", "Poison");
    }
    
    public void act()
    {
        ElixirBar bar = getWorld().getObjects(ElixirBar.class).get(0);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(null != mouse)
        {
            setLocation(mouse.getX(),mouse.getY());
            if(Greenfoot.mouseClicked(this) && bar.elixir >= elixir)
            {
                getWorld().addObject(new SpellAllyPoison(), getX(), getY());
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
