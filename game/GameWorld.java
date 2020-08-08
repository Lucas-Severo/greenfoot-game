import greenfoot.*;

public class GameWorld extends World
{
    public GameWorld()
    {    
        super(600, 400, 1); 
    }
    
    public GameWorld(IPlayer player)
    {    
        super(600, 400, 1);
        addObject(player, 0, 0);
    }
}
