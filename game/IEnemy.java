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
        excluirObjeto();
    }
    
    public void move() {
        setLocation(getX(), getY() + speed);
    }
    
    private int getRandomSpeed(){
        return Greenfoot.getRandomNumber(10);
    }
    
    private void excluirObjeto() {
        if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
