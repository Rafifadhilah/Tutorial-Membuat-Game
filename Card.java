import greenfoot.*;
public class Card extends Actor
{
    TroopAllyGhost troop;
    TroopAllyGhost cardTroop;
    boolean hasBeenUsed;
    public Card(TroopAllyGhost cardTroop)
    {
        this.cardTroop = cardTroop;
    }
    
    public void act()
    {
        boolean keyPressed = false;
        if(Greenfoot.mouseClicked(this) && 
            !keyPressed &&
            getObjectsInRange(50, TroopAllyGhost.class).isEmpty())
        {
            troop = cardTroop;
            keyPressed = true;
            hasBeenUsed = true;
            getWorld().addObject(troop, getX(), getY());
        }
        else if(Greenfoot.mouseClicked(this) && troop != null && intersects(troop))
        {
            getWorld().removeObject(troop);
            troop = null;
        }
        else if(Greenfoot.mouseClicked(this) && 
            !keyPressed && 
            isTouching(TroopAllyGhost.class))
        {
            TroopAllyGhost ghost = (TroopAllyGhost)getOneIntersectingObject(TroopAllyGhost.class);
            checkCard(ghost);
            removeTouching(TroopAllyGhost.class);
            troop = cardTroop;
            keyPressed = true;
            hasBeenUsed = true;
            getWorld().addObject(troop, getX(), getY());
        }
        
        if(troop != null && troop.getWorld() == null && hasBeenUsed)
        {
            troop = null;
            ClashWorld world = (ClashWorld)getWorld();
            world.changeCard(getX(), getY());
            world.removeObject(this);
        }
    }
    
    public void checkCard(TroopAllyGhost ghost)
    {
        switch(ghost.name)
        {
            case "Archer" : getWorld().getObjects(CardArcher.class).get(0).hasBeenUsed = false; 
                break;
            case "Knight" : getWorld().getObjects(CardKnight.class).get(0).hasBeenUsed = false; 
                break;
            case "Giant" : getWorld().getObjects(CardGiant.class).get(0).hasBeenUsed = false; 
                break;
            case "GoblinSpear" : getWorld().getObjects(CardGoblinSpear.class).get(0).hasBeenUsed = false; 
                break;
            case "DragonBaby" : getWorld().getObjects(CardDragonBaby.class).get(0).hasBeenUsed = false; 
                break;
            case "Golem" : getWorld().getObjects(CardGolem.class).get(0).hasBeenUsed = false; 
                break;
            case "Skeleton" : getWorld().getObjects(CardSkeleton.class).get(0).hasBeenUsed = false; 
                break;
            case "Cannon" : getWorld().getObjects(CardCannon.class).get(0).hasBeenUsed = false; 
                break;
            case "Fireball" : getWorld().getObjects(CardFireball.class).get(0).hasBeenUsed = false; 
                break;
            case "PekkaMini" : getWorld().getObjects(CardPekkaMini.class).get(0).hasBeenUsed = false; 
                break;
            case "Poison" : getWorld().getObjects(CardPoison.class).get(0).hasBeenUsed = false; 
                break;
        }
    }
}
