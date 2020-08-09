import greenfoot.*;

public class SelecaoJogador extends World
{
    public SelecaoJogador()
    {    
        super(600, 200, 1);
        GreenfootImage background = new GreenfootImage("", 20, Color.BLACK, Color.BLACK);
        setBackground(background);
        
        criarLabels();
        
        //Adicionando players para seleçăo
        addObject(new Easy(), 145, 109);
        addObject(new Medium(), 299, 109);
        addObject(new Hard(), 458, 109);
    }
    
    private void criarLabels() {
        Label lbSelecao = new Label("Selecione a dificuldade", 50);
        addObject(lbSelecao, getWidth()/2, 43);
        
        Label lbEasy = new Label("Easy", 30);
        addObject(lbEasy, 145, 150);
        
        Label lbMedium = new Label("Medium", 30);
        addObject(lbMedium, 299, 150);
        
        Label lbHard = new Label("Hard", 30);
        addObject(lbHard, 458, 150);
    }
}
