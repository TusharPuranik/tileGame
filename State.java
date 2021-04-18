package tilegame.states;
import java.awt.Graphics;
import tilegame.Handler;

public abstract class State {
    //game state manager code starts here
    
    public static State currentState=null;
    public static void setState(State state)
    {
        currentState=state;
    }
    public static State getState()
    {
        return currentState;
    }
    //game loop manager ends here.    
    
    //abstract classes
    
    protected Handler handler;
    public State(Handler handler)
    {
        this.handler=handler;
    }
    
    public abstract void update();
    public abstract void render(Graphics g);
}
