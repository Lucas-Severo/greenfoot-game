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
                excluirObjeto();
                return;
            }
            if(player.getLifes() == 0) {
                showGameOverMessage();
                backToHome();
            }
        }
        if(isAtEdge()) {
            excluirObjeto();
        }
    }
    
    public void move() {
        setLocation(getX(), getY() + speed);
    }
    
    private int getRandomSpeed(){
        return Greenfoot.getRandomNumber(10);
    }
        
    private void excluirObjeto() {
        getWorld().removeObject(this);
    }
    
    private boolean hasPlayer() {
        return getWorld().getObjects(IPlayer.class).size() > 0;
    }
    
    private IPlayer getPlayer() {
        return getWorld().getObjects(IPlayer.class).get(0);
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
