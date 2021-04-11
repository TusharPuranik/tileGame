package tilegame;

public class Game {

    private Display display;
    private int width,height;
    private String title;
    
    public Game(String title,int width,int height)
    {
        this.title=title;
        this.width=width;
        this.height=height;
        display=new Display(title,width,height);
    }
    
}
