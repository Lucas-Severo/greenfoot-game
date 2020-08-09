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
            if(player.getLifes() == 0) {
                showGameOverMessage();
                backToHome();
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
    
    private void showGameOverMessage() {
        Label lbGameOver = new Label("Game Over", 40);
                getWorld().addObject(
                    lbGameOver, 
                    getWorld().getWidth()/2,
                    getWorld().getHeight()/2
                );
        Greenfoot.delay(100);
    }
    
    private void backToHome() {
        Greenfoot.setWorld(new SelecaoJogador());
    }
}
