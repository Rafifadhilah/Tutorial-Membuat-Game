import greenfoot.*;
public class CardDeck extends Actor
{
    int position;
    boolean isTouchingCardChoice;
    CardChoice cardChoice;
    public CardDeck(int position)
    {
        this.position = position;
    }
    
    public void act()
    {
        checkTouching();
    }
    
    public void checkTouching()
    {
        cardChoice = (CardChoice)getOneIntersectingObject(CardChoice.class);
        if(cardChoice != null && 
            cardChoice.getX() == getX() && 
            cardChoice.getY() == getY())
        {
            switch(cardChoice.card)
            {
                case "Knight" : ClashWorld.cardStart[position] = new CardKnight();
                    break;
                case "Archer" : ClashWorld.cardStart[position] = new CardArcher();
                    break;
                case "Giant" : ClashWorld.cardStart[position] = new CardGiant();
                    break;
                case "Skeleton" : ClashWorld.cardStart[position] = new CardSkeleton();
                    break;
                case "DragonBaby" : ClashWorld.cardStart[position] = new CardDragonBaby();
                    break;
                case "GoblinSpear" : ClashWorld.cardStart[position] = new CardGoblinSpear();
                    break;
                case "Golem" : ClashWorld.cardStart[position] = new CardGolem();
                    break;
                case "Cannon" : ClashWorld.cardStart[position] = new CardCannon();
                    break;
                case "Fireball" : ClashWorld.cardStart[position] = new CardFireball();
                    break;
                case "PekkaMini" : ClashWorld.cardStart[position] = new CardPekkaMini();
                    break;
                case "Poison" : ClashWorld.cardStart[position] = new CardPoison();
                    break;
            }
        }
        else
            ClashWorld.cardStart[position] = null;
        
        if(cardChoice == null)
            isTouchingCardChoice = false;
        else if(cardChoice.getX() == getX() && cardChoice.getY() == getY())
            isTouchingCardChoice = true;
    }
}
