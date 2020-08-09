import greenfoot.*;

/**
 * @author lucas
 */
public class Counter extends Actor
{
    private int score;
    private String prefix;
    
    public Counter() {
        score = 0;
        prefix = "";
    }
    
    public Counter(String prefix) {
        this();
        this.prefix = prefix;
    }
    
    public void act() 
    {
        var image = new GreenfootImage(prefix + "" + score, 30, Color.BLACK, Color.YELLOW);
        setImage(image);
    }
    
    public int getWidth() {
        return getImage().getWidth();
    }
    
    public int getHeight() {
        return getImage().getHeight();
    }
    
    public void add() {
        this.score++;
    }
    
    public int getScore() {
        return score;
    }
}
