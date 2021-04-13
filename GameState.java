package tilegame.states;
import java.awt.Graphics;
import tilegame.entities.creatures.Player;
import tilegame.gfx.Assets;

public class GameState extends State{
    
    private Player player;
    public GameState()
    {
        player=new Player(10,100);
    }
    @Override
    public void update() {
        player.update();
        
    }
    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
