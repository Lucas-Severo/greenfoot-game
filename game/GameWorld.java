import greenfoot.*;
import java.util.List;
import java.util.Arrays;

public class GameWorld extends World
{
    private int maxEnemies;
    private int maxCandies;
    
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
        if(getObjects(Enemy.class).size() < maxEnemies) {
            addObject(createEnemy(), pos[0], pos[1]);
        }
        if(getObjects(Candy.class).size() < maxCandies) {
            addObject(createCandy(), pos[0], pos[1]);
        }
    }
    
    private void selectDifficulty(IPlayer player) {
        if(player instanceof Easy) {
            showText("Easy", getWidth() - 40, 50);
            maxEnemies = 5;
            maxCandies = 2;
        } else if(player instanceof Medium) {
            showText("Medium", getWidth() - 40, 50);
            maxEnemies = 10;
            maxCandies = 1;
        } else {
            showText("Hard", getWidth() - 40, 50);
            maxEnemies = 15;
            maxCandies = 1;
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
    
    private ICandy createCandy() {
        List<ICandy> candies = 
            Arrays.asList(
                new Cake()
            );
        return candies.get(Greenfoot.getRandomNumber(candies.size()));
    }
    
    private int[] getRandomPosition(int width, int height) {
        int[] pos = {Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height)*-10};
        return pos;
    }
}
