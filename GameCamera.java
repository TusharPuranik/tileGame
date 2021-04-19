/*this class allows us to move the position of the screen throughout the screen
so that our player is not lost.
*/

package tilegame.gfx;
import tilegame.Game;
import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tile.Tile;

public class GameCamera {

    private Handler handler;
    private float xOffset,yOffset;
    //offsets are used to render the position of the screen that need to be moved.

    public GameCamera(Handler handler,float xOffset,float yOffset)
    {
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.handler=handler;
    }

    public void checkBlankSpace()// Camera limit code . This is to remove the blank space outside the map.
    {
        if(xOffset<0)
        {
            xOffset=0;
        }
        else if(xOffset>handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth())
        {
            xOffset=handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth();
        }
        if(yOffset<0)
        {
            yOffset=0;
        }
        else if(yOffset>handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight())
        {
            yOffset=handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight();
        }
    }
    
    public void centerOnEntity(Entity e)
    {
        xOffset= e.getX()- handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset= e.getY()- handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }
    
    public void move(float xAmt,float yAmt)
    {
        xOffset+=xAmt;
        yOffset+=yAmt;
        checkBlankSpace();
    }
    
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
