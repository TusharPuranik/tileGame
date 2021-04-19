//Assets basically store images,music and other data which do no contain code 
package tilegame.gfx;

import java.awt.image.BufferedImage;


public class Assets {     //this class will load everything and will only be called once
    
    public static BufferedImage dirt,grass,stone,tree;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_idle;
    
    private static final int width=96,height=96; 
    private static final int widthPlayer=95,heightPlayer=144; 
    
    public static void init()
    {
        SpriteSheets sheet=new SpriteSheets(ImageLoader.loadImage("/images/spritesheet2.png"));
        SpriteSheets sheet1=new SpriteSheets(ImageLoader.loadImage("/images/spritesheet1.png"));

        player_down=new BufferedImage[4];
        player_up=new BufferedImage[4];
        player_left=new BufferedImage[4];
        player_right=new BufferedImage[4];
        player_idle=new BufferedImage[1];
        
        player_up[0]=sheet1.crop(0, heightPlayer*3, widthPlayer, heightPlayer);
        player_up[1]=sheet1.crop(widthPlayer, heightPlayer*3, widthPlayer, heightPlayer);
        player_up[2]=sheet1.crop(widthPlayer*2, heightPlayer*3, widthPlayer, heightPlayer);
        player_up[3]=sheet1.crop(widthPlayer*3, heightPlayer*3, widthPlayer, heightPlayer);
        
        player_down[0]=sheet1.crop(0, 0, widthPlayer, heightPlayer);
        player_down[1]=sheet1.crop(widthPlayer, 0, widthPlayer, heightPlayer);
        player_down[2]=sheet1.crop(widthPlayer*2, 0, widthPlayer, heightPlayer);
        player_down[3]=sheet1.crop(widthPlayer*3, 0, widthPlayer, heightPlayer);

        player_left[0]=sheet1.crop(0, heightPlayer*2, widthPlayer, heightPlayer);
        player_left[1]=sheet1.crop(widthPlayer, heightPlayer*2, widthPlayer, heightPlayer);
        player_left[2]=sheet1.crop(widthPlayer*2, heightPlayer*2, widthPlayer, heightPlayer);
        player_left[3]=sheet1.crop(widthPlayer*3, heightPlayer*2, widthPlayer, heightPlayer);

        player_right[0]=sheet1.crop(0, heightPlayer, widthPlayer, heightPlayer);
        player_right[1]=sheet1.crop(widthPlayer, heightPlayer, widthPlayer, heightPlayer);
        player_right[2]=sheet1.crop(widthPlayer*2, heightPlayer, widthPlayer, heightPlayer);
        player_right[3]=sheet1.crop(widthPlayer*3, heightPlayer, widthPlayer, heightPlayer);
        
        player_idle[0]=sheet1.crop(widthPlayer, 0, widthPlayer, heightPlayer);

        
        grass=sheet.crop(width,0,width,height);
        dirt=sheet.crop(0,height,width,height);
        stone=sheet.crop(width,height,width,height);
        tree=sheet.crop(0,height+height,width,height);
    }
}
