import greenfoot.*;
public class ClashWorld extends World
{
    TowerUpPrincess towerupleft = new TowerUpPrincess();
    TowerUpPrincess towerupright = new TowerUpPrincess();
    TowerDownPrincess towerdownleft = new TowerDownPrincess();
    TowerDownPrincess towerdownright = new TowerDownPrincess();
    static double diff;
    double elixir = 1;
    double elixirSpeed = 0.012 * diff;
    int allyCrowns;
    int enemyCrowns;
    int time = 5400;
    int enemies = 10;
    static Card[] cardStart = new Card[8];
    Card cardNext;
    EndState draw = new EndState(0);
    EndState victory = new EndState(1);
    EndState defeat = new EndState(2);
    public ClashWorld()
    {
        super(400, 600, 1);
        setPaintOrder
        (
            Overlay.class,
            Card.class,
            SpellEnemyAir.class,
            SpellAllyAir.class,
            HealthBar.class,
            Projectile.class,
            TowerAlly.class,
            Troop.class,
            TowerEnemy.class,
            SpellEnemyGround.class,
            SpellAllyGround.class,
            ZoneTroopsOverlay.class,
            ZoneTroopsPlace.class
        );
        addObject(new Music(), 0, 0);
        prepareOverlay();
        prepareTowers();
        Greenfoot.start();
    }
    
    public void act()
    {
        time--;
        if(time == 5399)
        {
            prepareOverlayCards();
            int random = Greenfoot.getRandomNumber(cardStart.length);
            while(cardStart[random].getWorld() != null)
                random = Greenfoot.getRandomNumber(cardStart.length);
            cardNext = cardStart[random];
        }
        
        if(time == 1800)
        {
            addObject(new DoubleElixirText(), 200, 300);
            elixirSpeed *= 2;
            ElixirBar bar = getObjects(ElixirBar.class).get(0);
            bar.elixirSpeed *= 2;
        }
        
        if(time < 1)
        {
            time++;
            if(allyCrowns == enemyCrowns)
                addObject(draw, 200, 300);
            else if(allyCrowns > enemyCrowns)
                addObject(victory, 200, 300);
            else if(allyCrowns < enemyCrowns)
                addObject(defeat, 200, 300);
            removeObjects(getObjects(HealthBar.class));
            removeObjects(getObjects(Troop.class));
        }
        showText("" + time / 30, 30, 20);
        
        addElixir();
        if(draw.getWorld() == null && victory.getWorld() == null && defeat.getWorld() == null)
            addEnemies();
        checkCrowns();
    }
    
    public void addElixir()
    {
        //Increase enemy elixir
        if(elixir < 10)
            elixir += elixirSpeed;
    }
    
    public void addEnemies()
    {
        //Knight
        if(Greenfoot.getRandomNumber((int)(70 * enemies / diff)) == 0 && elixir >= 3)
        {
            addObject(new TroopEnemyKnight(), 
            Greenfoot.getRandomNumber(300) + 50, 
            Greenfoot.getRandomNumber(150) + 50);
            elixir -= 3;
        }
        //Archer
        if(Greenfoot.getRandomNumber((int)(70 * enemies / diff)) == 0 && elixir >= 3)
        {
            int posX = Greenfoot.getRandomNumber(300) + 50;
            int posY = Greenfoot.getRandomNumber(150) + 50;
            addObject(new TroopEnemyArcher(), posX - 7, posY);
            addObject(new TroopEnemyArcher(), posX + 7, posY);
            elixir -= 3;
        }
        //Giant
        if(Greenfoot.getRandomNumber((int)(50 * enemies / diff)) == 0 && elixir >= 5)
        {
            addObject(new TroopEnemyGiant(),
            Greenfoot.getRandomNumber(300) + 50,
            Greenfoot.getRandomNumber(150) + 50);
            elixir -= 5;
        }
        //Mini Pekka
        if(Greenfoot.getRandomNumber((int)(60 * enemies / diff)) == 0 && elixir >= 2)
        {
            addObject(new TroopEnemyPekkaMini(), 
            Greenfoot.getRandomNumber(300) + 50, 
            Greenfoot.getRandomNumber(150) + 50);
            elixir -= 4;
        }
        //Baby dragon
        if(Greenfoot.getRandomNumber((int)(60 * enemies / diff)) == 0 && elixir >= 4)
        {
            addObject(new TroopEnemyDragonBaby(), 
            Greenfoot.getRandomNumber(300) + 50, 
            Greenfoot.getRandomNumber(150) + 50);
            elixir -= 4;
        }
        //Spear goblin
        if(Greenfoot.getRandomNumber((int)(80 * enemies / diff)) == 0 && elixir >= 2)
        {
            int posX = Greenfoot.getRandomNumber(300) + 50;
            int posY = Greenfoot.getRandomNumber(150) + 50;
            addObject(new TroopEnemyGoblinSpear(), posX, posY + 9);
            addObject(new TroopEnemyGoblinSpear(), posX - 9, posY - 7);
            addObject(new TroopEnemyGoblinSpear(), posX + 9, posY - 7);
            elixir -= 2;
        }
        //Skeleton
        if(Greenfoot.getRandomNumber((int)(90 * enemies / diff)) == 0 && elixir >= 1)
        {
            int posX = Greenfoot.getRandomNumber(300) + 50;
            int posY = Greenfoot.getRandomNumber(150) + 50;
            addObject(new TroopEnemySkeleton(), posX, posY + 9);
            addObject(new TroopEnemySkeleton(), posX - 9, posY - 7);
            addObject(new TroopEnemySkeleton(), posX + 9, posY - 7);
            elixir -= 1;
        }
        //Golem
        if(Greenfoot.getRandomNumber((int)(20 * enemies / diff)) == 0 && elixir >= 8)
        {
            addObject(new TroopEnemyGolem(),
            Greenfoot.getRandomNumber(300) + 50,
            Greenfoot.getRandomNumber(150) + 50);
            elixir -= 8;
        }
        //Cannon
        if(Greenfoot.getRandomNumber((int)(140 * enemies / diff)) == 0 && elixir >= 3)
        {
            int posX = Greenfoot.getRandomNumber(300) + 50;
            int posY = Greenfoot.getRandomNumber(50) + 150;
            TowerBaseCannon base = new TowerBaseCannon();
            addObject(base, posX, posY + 4);
            addObject(new TowerUpCannon(base), posX, posY - 5);
            elixir -= 3;
        }
        //Fireball
        if(Greenfoot.getRandomNumber((int)(60 * enemies / diff)) == 0 && elixir >= 4)
        {
            //choose if it will launch a fireball on a princess or king tower
            int i = Greenfoot.getRandomNumber(3);
            switch(i)
            {
                case 0 : addObject(new SpellEnemyFireball(200, 405), 200, 50);
                    break;
                case 1 : if(towerdownleft.getWorld() != null)
                            addObject(new SpellEnemyFireball(95, 370), 200, 50);
                    break;
                case 2 : if(towerdownright.getWorld() != null)
                            addObject(new SpellEnemyFireball(305, 370), 200, 50);
                    break;
            }
            elixir -= 4;
        }
        //Poison
        if(Greenfoot.getRandomNumber((int)(60 * enemies / diff)) == 0 && elixir >= 4)
        {
            //choose if it will launch a fireball on a princess or king tower
            int i = Greenfoot.getRandomNumber(3);
            switch(i)
            {
                case 0 : addObject(new SpellEnemyPoison(), 200, 405);
                    break;
                case 1 : if(towerdownleft.getWorld() != null)
                            addObject(new SpellEnemyPoison(), 95, 370);
                    break;
                case 2 : if(towerdownright.getWorld() != null)
                            addObject(new SpellEnemyPoison(), 305, 370);
                    break;
            }
            elixir -= 4;
        }
    }
    
    public void checkCrowns()
    {
        //Stop the game and kill all remaining enemy princess towers
        if(allyCrowns == 3)
        {
            if(towerupleft != null)
                towerupleft.hp = 0;
            if(towerupright != null)
                towerupright.hp = 0;
            addObject(victory, 200, 300);
            removeObjects(getObjects(HealthBar.class));
            removeObjects(getObjects(Troop.class));
        }
        //Stop the game and kill all remaining ally princess towers
        if(enemyCrowns == 3)
        {
            if(towerdownleft != null)
                towerdownleft.hp = 0;
            if(towerdownright != null)
                towerdownright.hp = 0;
            addObject(defeat, 200, 300);
            removeObjects(getObjects(HealthBar.class));
            removeObjects(getObjects(Troop.class));
        }
    }
    
    public void prepareOverlay()
    {
        //Add overlay elements
        addObject(new ElixirBar(), 63, 570);
        addObject(new ElixirBarOverlay(), 195, 570);
        addObject(new ScoreOverlayUp(), 380, 190);
        addObject(new ScoreOverlayDown(), 380, 315);
        addObject(new CardNextOverlay(), 345, 535);
        addObject(new CardNext(), 345, 500);
        addObject(new ZoneTroopsOverlay(), 200, 300);
        addObject(new ZoneTroopsPlaceStart(), 200, 360);
    }
    
    public void prepareOverlayCards()
    {
        //Add random starting cards
        for(int i = 0; i < 4; i++)
        {
            int random = Greenfoot.getRandomNumber(cardStart.length);
            while(cardStart[random].getWorld() != null)
                random = Greenfoot.getRandomNumber(cardStart.length);
            addObject(cardStart[random], i * 70 + 50, 500);
        }
    }
    
    public void prepareTowers()
    {
        //Add enemy and ally towers
        addObject(towerdownleft, 95, 370);
        addObject(towerdownright, 305, 370);
        addObject(new TowerDownKing(), 200, 405);
        addObject(towerupleft, 95, 130);
        addObject(towerupright, 305, 130);
        addObject(new TowerUpKing(), 200, 85);
    }
    
    public void changeCard(int x, int y)
    {
        //Change card into the next random card
        addObject(cardNext, x, y);
        int random = Greenfoot.getRandomNumber(cardStart.length);
        while(cardStart[random].getWorld() != null)
            random = Greenfoot.getRandomNumber(cardStart.length);
        cardNext = cardStart[random];
    }
}
