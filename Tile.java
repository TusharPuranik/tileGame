package tilegame.tile;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
    
    public static Tile[] tiles =new Tile[256];//This Tile array will store every instance of every tile int our array.
    public static Tile grassTile=new GrassTile(0);
    public static Tile dirtTile=new DirtTile(1);
    public static Tile rockTile=new RockTile(2);
    public static Tile treeTile=new TreeTile(3);

    
    public static final int TILEWIDTH=64,TILEHEIGHT=64;
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture,int id)
    {
        this.texture=texture;
        this.id=id;
        
        tiles[id]=this;
    }
    
    public void update()
    {
        
    }
    
    public void render(Graphics g,int x,int y)
    {
        g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT, null);
    }
    
    public boolean isSolid()//This method is written to so that the player can walk on the tiles or not;
    {                       //If this method returns then the player can walk on the tile else if it is true then the player cant walk on the tile.
        return false;
    }
    
    public int getId()
    {
        return id;
    }
}
