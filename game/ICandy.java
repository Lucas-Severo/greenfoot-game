import greenfoot.*;

public class ICandy extends Actor implements Candy
{
    private int speed;
    
    public ICandy() {
        speed = getRandomSpeed();
    }
    
    public void act() 
    {
        move();
        if(hasPlayer()) {
            IPlayer player = getPlayer();
            if(intersects(player)) {
                removeObject();
                return;
            }
        }
        checkIfIsAtEdge();
    }    
    
    public void move() {
        setLocation(getX(), getY() + speed);
    }
    
    public void removeObject() {
        getWorld().removeObject(this);
    }
    
    private boolean hasPlayer() {
        return getWorld().getObjects(Player.class).size() > 0;
    }
    
    private IPlayer getPlayer() {
        return (IPlayer) getWorld().getObjects(Player.class).get(0);
    }
    
    private int getRandomSpeed(){
        return Greenfoot.getRandomNumber(8);
    }
    
    private void checkIfIsAtEdge() {
        if(isAtEdge()) {
            removeObject();
        }
    }
}
