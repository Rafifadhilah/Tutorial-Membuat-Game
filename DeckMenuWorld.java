import greenfoot.*;
public class DeckMenuWorld extends World
{
    String[] cards = 
    {
        "Knight",
        "Archer",
        "Giant",
        "Skeleton",
        "DragonBaby",
        "GoblinSpear",
        "Golem",
        "Cannon",
        "Fireball",
        "PekkaMini",
        "Poison",
    };
    public DeckMenuWorld()
    {
        super(1000, 600, 1);
        addObject(new Music(), 0, 0);
        addObject(new MenuDeckText(), 500, 50);
        addObject(new MenuButtonStart(), 500, 520);
        for(int i = 0; i < 8; i++)
            addObject(new CardDeck(i), i * 115 + 100, 350);
        for(int i = 0; i < cards.length; i++)
            addObject(new CardChoice(cards[i]), i * 85 + 75, 150);
    }
}
