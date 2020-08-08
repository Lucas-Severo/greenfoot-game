import greenfoot.*;

public class SelecaoJogador extends World
{
    public SelecaoJogador()
    {    
        super(600, 200, 1);
        GreenfootImage background = new GreenfootImage("", 20, Color.BLACK, Color.BLACK);
        setBackground(background);
        
        Label lbSelecao = new Label("Selecione um personagem", 50);
        addObject(lbSelecao, getWidth()/2, 43);
        
        //Adicionando players para seleção
        addObject(new Boy(), 145, 109);
        addObject(new Man(), 299, 109);
        addObject(new Snake(), 458, 109);
    }
}
