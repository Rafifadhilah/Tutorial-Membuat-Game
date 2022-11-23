import greenfoot.*;
public class Music extends Actor
{
    static GreenfootSound screenMusic = new GreenfootSound("Screen.mp3");
    static GreenfootSound battleMusic = new GreenfootSound("Battle.mp3");
    public Music()
    {
        setImage((GreenfootImage)null);
        screenMusic.setVolume(45);
        battleMusic.setVolume(55);
    }
    
    public void act()
    {
        if(this.getWorld().getClass() == ClashWorld.class && !battleMusic.isPlaying())
        {
            screenMusic.stop();
            battleMusic.play();
        }
        if(this.getWorld().getClass() == DifficultyMenuWorld.class && !screenMusic.isPlaying() ||
            this.getWorld().getClass() == DeckMenuWorld.class && !screenMusic.isPlaying() ||
            this.getWorld().getClass() == ScreenMainWorld.class && !screenMusic.isPlaying())
        {
            battleMusic.stop();
            screenMusic.play();
        }
    }
}
