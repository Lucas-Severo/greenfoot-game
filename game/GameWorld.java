import greenfoot.*;
import java.util.List;
import java.util.Arrays;

public class GameWorld extends World
{
    private int max;
    
    public GameWorld()
    {    
        super(600, 400, 1); 
    }
    
    public GameWorld(IPlayer player)
    {    
        super(600, 400, 1);
        addObject(player, getWidth()/2, 367);
        selectDifficulty(player);
    }
    
    public void act() {
        int[] pos = getRandomPosition(getWidth(), getHeight());
        if(getObjects(IEnemy.class).size() <= max) {
            addObject(createEnemy(), pos[0], pos[1]);
        }
    }
    
    private void selectDifficulty(IPlayer player) {
        if(player instanceof Easy) {
            showText("Easy", getWidth() - 100, 20);
            max = 5;
        } else if(player instanceof Medium) {
            showText("Medium", getWidth() - 100, 20);
            max = 10;
        } else {
            showText("Hard", getWidth() - 100, 20);
            max = 15;
        }
    }
    
    private IEnemy createEnemy() {
        List<IEnemy> enemies = 
            Arrays.asList(
                new Anchor(),
                new Barrel(),
                new Bomb()
            );
        return enemies.get(Greenfoot.getRandomNumber(enemies.size()));
    }
    
    private int[] getRandomPosition(int width, int height) {
        int[] pos = {Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height)*-10};
        return pos;
    }
}
