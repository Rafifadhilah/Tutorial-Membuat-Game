import greenfoot.*;
public class TroopAllyGhostSkeleton extends TroopAllyGhost
{
    public TroopAllyGhostSkeleton()
    {
        super(1, "troop", "Skeleton");
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
                getWorld().addObject(new TroopAllySkeleton(), getX(), getY() - 9);
                getWorld().addObject(new TroopAllySkeleton(), getX() - 9, getY() + 7);
                getWorld().addObject(new TroopAllySkeleton(), getX() + 9, getY() + 7);
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
