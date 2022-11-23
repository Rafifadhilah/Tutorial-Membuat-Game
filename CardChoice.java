import greenfoot.*;
public class CardChoice extends Actor
{
    String card;
    boolean isFixed = true;
    public CardChoice(String card)
    {
        this.card = card;
        GreenfootImage image = getImage();
        image = new GreenfootImage("Card" + card + ".png");
        image.scale(66, 79);
        setImage(image);
    }
    
    public void act()
    {
        CardDeck cardDeck = (CardDeck)getOneIntersectingObject(CardDeck.class);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(this) && 
            cardDeck != null && 
            !isFixed &&
            !cardDeck.isTouchingCardChoice)
        {
            setLocation(cardDeck.getX(), cardDeck.getY());
            isFixed = true;
        }
        else if(Greenfoot.mouseClicked(this) && !isFixed && !isTouching(CardChoice.class))
            isFixed = true;
        else if(Greenfoot.mouseClicked(this) && !isTouching(CardChoice.class))
            isFixed = false;
        else if(!isFixed && mouse != null)
            setLocation(mouse.getX(), mouse.getY());
    }
}
