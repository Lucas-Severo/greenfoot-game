import greenfoot.*;

public class IPlayer extends Actor implements Player
{
    private int speed = 3;
    private int lifes = 1;
    
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
            showLifes();
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
    
    public void setLifes(int lifes) {
        this.lifes = lifes;
        deleteLifes();
    }
    
    public int getLifes() {
        return lifes;
    }
    
    private void showLifes() {
        var world = getWorld();
        for(int i = 1; i <= getLifes(); i++) {
            world.addObject(
                new Heart(), 
                world.getWidth()-(i*30), 
                20
            );
        }
    }
    
    private void deleteLifes() {
        var world = getWorld();
        if(world != null) {
            for(Heart heart: getWorld().getObjects(Heart.class)) {
                getWorld().removeObject(heart);
            }
        }
    }
}
