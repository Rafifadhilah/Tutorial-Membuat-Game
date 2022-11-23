import greenfoot.*;
public class TroopAllyGhostFireball extends TroopAllyGhost
{
    public TroopAllyGhostFireball()
    {
        super(4, "spell", "Fireball");
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
                getWorld().addObject(new SpellAllyFireball(getX(), getY()), 200, 550);
                bar.useElixir(elixir);
                getWorld().removeObject(this);
            }
        }
    }
}
