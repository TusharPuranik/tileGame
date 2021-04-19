package tilegame.entities.creatures;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;

public class Player extends Creature
{
    private Animation animDown,animUp,animLeft,animRight,animIdle;
    public Player(Handler handler,float x,float y)
    {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=16;
        bounds.y=16;
        bounds.width=32;
        bounds.height=45;
        
        //Animations
        animDown=new Animation(150,Assets.player_down);
        animUp=new Animation(150,Assets.player_up);
        animLeft=new Animation(150,Assets.player_left);
        animRight=new Animation(150,Assets.player_right);
        animIdle=new Animation(150,Assets.player_idle);
    }

    @Override
    public void update() {
        //Animations
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();
        animIdle.update();
        
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    private void getInput()
    {
        xMove=0;
        yMove=0;
        
        if(handler.getKeyManager().up)
            yMove=-speed;
        if(handler.getKeyManager().left)
            xMove=-speed;
        if(handler.getKeyManager().down)
            yMove=speed;
        if(handler.getKeyManager().right)
            xMove=speed;
    }
    

    @Override
    public void render(Graphics g) {
        
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), 
                                    (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove<0)
        {
            return animLeft.getFrames();
        }
        else if(xMove>0)
        {
            return animRight.getFrames();
        }
        else if(yMove>0)
        {
            return animDown.getFrames();
        }
        else if(yMove<0)
        {
            return animUp.getFrames();
        }
        else
        {
            return animIdle.getFrames();
        }
    }
    
}
