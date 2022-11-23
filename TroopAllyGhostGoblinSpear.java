import greenfoot.*;
public class TroopAllyGhostGoblinSpear extends TroopAllyGhost
{
    public TroopAllyGhostGoblinSpear()
    {
        super(2, "troop", "GoblinSpear");
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
                getWorld().addObject(new TroopAllyGoblinSpear(), getX(), getY() - 9);
                getWorld().addObject(new TroopAllyGoblinSpear(), getX() - 9, getY() + 7);
                getWorld().addObject(new TroopAllyGoblinSpear(), getX() + 9, getY() + 7);
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
