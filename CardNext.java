import greenfoot.*;
public class CardNext extends Overlay
{
    public Card cardNext;
    GreenfootImage[] cards =
    {
        new GreenfootImage("CardKnight.png"),
        new GreenfootImage("CardArcher.png"),
        new GreenfootImage("CardGiant.png"),
        new GreenfootImage("CardFireball.png"),
        new GreenfootImage("CardGoblinSpear.png"),
        new GreenfootImage("CardDragonBaby.png"),
        new GreenfootImage("CardSkeleton.png"),
        new GreenfootImage("CardCannon.png"),
        new GreenfootImage("CardGolem.png"),
        new GreenfootImage("CardPekkaMini.png"),
        new GreenfootImage("CardPoison.png"),
    };
    public CardNext()
    {
        setImage((GreenfootImage)null);
        for(int i = 0; i < cards.length; i++)
            cards[i].scale(42, 50);
    }
    
    public void act()
    {
        checkCard();
    }
    
    public void checkCard()
    {
        ClashWorld world = (ClashWorld)getWorld();
        cardNext = world.cardNext;
        if(cardNext.getClass() == CardKnight.class)
            setImage(cards[0]);
        else if(cardNext.getClass() == CardArcher.class)
            setImage(cards[1]);
        else if(cardNext.getClass() == CardGiant.class)
            setImage(cards[2]);
        else if(cardNext.getClass() == CardFireball.class)
            setImage(cards[3]);
        else if(cardNext.getClass() == CardGoblinSpear.class)
            setImage(cards[4]);
        else if(cardNext.getClass() == CardDragonBaby.class)
            setImage(cards[5]);
        else if(cardNext.getClass() == CardSkeleton.class)
            setImage(cards[6]);
        else if(cardNext.getClass() == CardCannon.class)
            setImage(cards[7]);
        else if(cardNext.getClass() == CardGolem.class)
            setImage(cards[8]);
        else if(cardNext.getClass() == CardPekkaMini.class)
            setImage(cards[9]);
        else if(cardNext.getClass() == CardPoison.class)
            setImage(cards[10]);
    }
}
