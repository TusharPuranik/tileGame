package tilegame.states;
import java.awt.Graphics;
import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.worlds.World;

public class GameState extends State{
    
    private Player player;
    private World world;
            
    public GameState(Handler handler)
    {
        super(handler);
        world=new World(handler, "resources/worlds/world1.txt");
        handler.setWorld(world);
        player=new Player(handler,10,100);
        
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
