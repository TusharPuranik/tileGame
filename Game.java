package tilegame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import tilegame.gfx.Assets;
import tilegame.gfx.GameCamera;
import tilegame.input.KeyManager;
import tilegame.states.GameState;
import tilegame.states.MenuState;
import tilegame.states.SettingState;
import tilegame.states.State;

public class Game implements Runnable{

    private Display display;
    private int width,height;
    public String title;
    private boolean running=false;
    
    private Thread thread;
    
    private Graphics g;
    private BufferStrategy bs;
    
    /*buffer is a hidden screen in your computer that you cannot see. In other words its a hidden memeory which
    contains the same data as the actual screen does*/
    /*buffer strategy helps the pc to understand how to draw elements ot the screen*/
    
    //States
    private State gameState;
    private State menuState;
    private State settingState;
    
    private KeyManager keyManager;
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    public Game (String title,int width,int height)
    {
        this.title=title;
        this.width=width;
        this.height=height;
        keyManager=new KeyManager();
    }
    public void init()//initialize
    {
         display=new Display(title,width,height);
         display.getframe().addKeyListener(keyManager);
         Assets.init();
         
         gameCamera=new GameCamera(this , 0, 0);
         
         handler=new Handler(this);
         
         gameState=new GameState(handler);
         menuState=new MenuState(handler);
         settingState=new SettingState(handler);
         State.setState(gameState);
    }
    public void update()//keeps in updating the game
    {
        keyManager.update();
      if(State.getState()!=null)
          State.getState().update();
    }
    public void render()//keeps on repainting after updating of the game 
    {
        bs=display.getCanvas().getBufferStrategy();// this will set buffer strategy of the canvas equal to the current buffer strategy
        if(bs==null)//if the code is running for the first time then the pc wont know how many buffers tos use.
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        //drawing starts from here        
       
        if(State.getState()!=null)
          State.getState().render(g);

        //drawing ends here
        bs.show();
        g.dispose();
    }
    public void run()
    {
        init();
        /*game loop timer is used so that the movements of all the elements in the 
        panel move equally in all computers and do not fluctuate
        */
        //game loop timer start here
        int fps=60;
        double timePerUpdate=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();//System.nanoTime() returns the time that the computer is running at in nanao seconds.
        long timer=0;
        int ticks=0;
        while(running)
        {
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerUpdate;//delta will store the time remaining for the computer call update() and render() methods.
            //delta tells the computer when and when not to call update() and render().
            timer+=now-lastTime;
            lastTime=now;            
            if(delta>=1)
            {
                update();
                render();
                ticks++;
                delta--;
            }
            if(timer>=1000000000)
            {
                System.out.println("ticks:60");
                timer=0;
                ticks=0;
            }
            //game loop timer ends here
        }
        stop();   
    }
    
    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public synchronized void start()
    {
        if(running)
            return;
        
        running = true;
       thread=new Thread(this);
       thread.start();
       
    }
    public synchronized void stop()
    {
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
