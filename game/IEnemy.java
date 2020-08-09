import greenfoot.*;

/**
 * @author Lucas
 */
public class IEnemy extends Actor implements Enemy
{
    private int speed;
    
    public IEnemy() {
        speed = getRandomSpeed();
    }
    
    public void act() 
    {
        move();
        if(hasPlayer()) {
            IPlayer player = getPlayer();
            if(intersects(player)) {            
                player.setLifes(player.getLifes()-1);
                removeObject();
                return;
            }
        }
        if(isAtEdge()) {
            removeObject();
        }
    }
    
    @Override
    public void move() {
        setLocation(getX(), getY() + speed);
    }
    
    @Override
    public void removeObject() {
        getWorld().removeObject(this);
    }
    
    private int getRandomSpeed(){
        return Greenfoot.getRandomNumber(8);
    }
    
    private boolean hasPlayer() {
        return getWorld().getObjects(Player.class).size() > 0;
    }
    
    private IPlayer getPlayer() {
        return (IPlayer) getWorld().getObjects(Player.class).get(0);
    }
}
