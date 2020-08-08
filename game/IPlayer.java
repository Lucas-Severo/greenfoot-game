import greenfoot.*;

public class IPlayer extends Actor implements Player
{
    private int speed = 3;
    
    public IPlayer() {
    }
    
    public IPlayer(String image) {
        GreenfootImage imagem = new GreenfootImage(image);
        setImage(imagem);
    }
    
    public void act() 
    {
        if(isSelected()) {
            Greenfoot.setWorld(new GameWorld(this));
        }
        if(!(getWorld() instanceof SelecaoJogador)) {
            moves();
        }
    }
    
    public void moves() {
        if(Greenfoot.isKeyDown("d") ||
           Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
        }
        else if(Greenfoot.isKeyDown("s") ||
                Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
        else if(Greenfoot.isKeyDown("a") ||
                Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        }
        else if(Greenfoot.isKeyDown("w") ||
                Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        }
    }
    
    public boolean isSelected() {
        return getWorld() instanceof SelecaoJogador && 
               Greenfoot.mouseClicked(this);
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getSpeed() {
        return speed;
    }
}
