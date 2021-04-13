//Assets basically store images,music and other data which do no contain code 
package tilegame.gfx;

import java.awt.image.BufferedImage;


public class Assets {     //this class will load everything and will only be called once
    
    public static BufferedImage player,dirt,grass,stone,tree;
    private static final int width=96,height=96; 
    
    public static void init()
    {
        SpriteSheets sheet=new SpriteSheets(ImageLoader.loadImage("/images/spritesheet2.png"));
        player=sheet.crop(0,0,width,height);
        grass=sheet.crop(width,0,width,height);
        dirt=sheet.crop(0,height,width,height);
        stone=sheet.crop(width,height,width,height);
        tree=sheet.crop(0,height+height,width,height);
    }
}
