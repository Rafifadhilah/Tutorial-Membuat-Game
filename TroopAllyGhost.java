import greenfoot.*;
public class TroopAllyGhost extends Troop
{
    int elixir;
    String type;
    String name;
    public TroopAllyGhost(int elixir, String type, String name)
    {
        this.elixir = elixir;
        this.type = type;
        this.name = name;
        getImage().setTransparency(100);
    }
}
