package tilegame.states;
import java.awt.Graphics;
import tilegame.gfx.Assets;


public class GameState extends State{
    
    public GameState()
    {
        
    }

    @Override
    public void update() {
        
        
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(Assets.dirt, 0, 0, null);
    }
    
    
    
}
