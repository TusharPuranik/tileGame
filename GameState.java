package tilegame.states;
import java.awt.Graphics;
import tilegame.Game;
import tilegame.entities.creatures.Player;
import tilegame.worlds.World;

public class GameState extends State{
    
    private Player player;
    private World world;
            
    public GameState(Game game)
    {
        super(game);
        player=new Player(game,10,100);
        world=new World("");
    }

    @Override
    public void update() {
        world.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
       
    }
}
