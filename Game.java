package tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import tilegame.gfx.ImageLoader;
import tilegame.gfx.SpriteSheets;

public class Game implements Runnable{

    private Display display;
    private int width,height;
    private String title;
    private boolean running=false;
    
    private Thread thread;
    
    private Graphics g;

    private BufferStrategy bs;
    
    /*buffer is a hidden screen in your computer that you cannot see. In other words its a hidden memeory which
    contains the same data as the actual screen does*/
    
    /*buffer strategy helps the pc to understand how to draw elements ot the screen*/
    
private BufferedImage test;
private SpriteSheets sheet;
    
    public Game(String title,int width,int height)
    {
        this.title=title;
        this.width=width;
        this.height=height;
    }
    
    public void update()//keeps in updating the game
    {
        
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
        
            g.drawImage(sheet.crop(0, 0, 113, 84),0,0,null);
            

        
        //drawing ends here
        bs.show();
        g.dispose();
    }
    
    
    public void run()
    {
        init();
        while(running)
        {
            update();
            render();
        }
        stop();
        
    }
    
    public void init()//initialize
    {
         display=new Display(title,width,height);
         test=ImageLoader.loadImage("/images/spriteSheet1.png");
         sheet=new SpriteSheets(test);
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
