/*this class allows us to move the position of the screen throughout the screen
so that our player is not lost.
*/

package tilegame.gfx;
import tilegame.Game;
import tilegame.entities.Entity;

public class GameCamera {

    private Game game;
    private float xOffset,yOffset;
    //offsets are used to render the position of the screen that need to be moved.

    public GameCamera(Game game,float xOffset,float yOffset)
    {
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.game=game;
    }

    public void centerOnEntity(Entity e)
    {
        xOffset= e.getX()- game.getWidth() / 2 + e.getWidth() / 2;
        yOffset= e.getY()- game.getHeight() / 2 + e.getHeight() / 2;
    }
    
    public void move(float xAmt,float yAmt)
    {
        xOffset+=xAmt;
        yOffset+=yAmt;
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