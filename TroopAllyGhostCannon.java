import greenfoot.*;
public class TroopAllyGhostCannon extends TroopAllyGhost
{
    public TroopAllyGhostCannon()
    {
        super(3, "tower", "Cannon");
    }
    
    public void act()
    {
        ElixirBar bar = getWorld().getObjects(ElixirBar.class).get(0);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(null != mouse)
        {
            setLocation(mouse.getX(),mouse.getY());
            if(Greenfoot.mouseClicked(this) && isTouching(ZoneTroopsPlace.class)
                && bar.elixir >= elixir && !isTouching(TowerAlly.class))
            {
                TowerBaseCannon base = new TowerBaseCannon();
                getWorld().addObject(base, getX(), getY() + 4);
                getWorld().addObject(new TowerDownCannon(base), getX(), getY() - 5);
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
