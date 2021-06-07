package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player;
	// efectos
        public static BufferedImage speed;
    //lasers
        public static BufferedImage blueLaser;
        public static BufferedImage greenLaser;
        public static BufferedImage redLaser;
    //meteoros
        public static BufferedImage[] big = new BufferedImage[4];
        public static BufferedImage[] meds = new BufferedImage[2];
        public static BufferedImage[] smalls = new BufferedImage[2];
        public static BufferedImage[] tinies = new BufferedImage[2];
    //explosiones
        public static BufferedImage[] exp = new BufferedImage[9];
    //UFO
    public static BufferedImage ufo;

	public static void init()
	{
		player = Loader.ImageLoader("../res/player.png");
                speed = Loader.ImageLoader("../res/effects/fire08.png");
                blueLaser=Loader.ImageLoader("../res/lasers/laserBlue01.png");
                greenLaser=Loader.ImageLoader("../res/lasers/laserGreen11.png");
                redLaser=Loader.ImageLoader("../res/lasers/laserRed01.png");
                for (int i = 0; i<big.length;i++)
                    big[i]=Loader.ImageLoader("../res/meteors/big"+(i+1)+".png");
                for (int i = 0; i<meds.length;i++)
                    meds[i]=Loader.ImageLoader("../res/meteors/med"+(i+1)+".png");
                for (int i = 0; i<smalls.length;i++)
                    smalls[i]=Loader.ImageLoader("../res/meteors/small"+(i+1)+".png");
                for (int i = 0; i<tinies.length;i++)
                    tinies[i]=Loader.ImageLoader("../res/meteors/tiny"+(i+1)+".png");
                for (int i = 0; i<exp.length; i++)
                    exp[i] = Loader.ImageLoader("../res/explosion/"+i+".png");
                
                ufo = Loader.ImageLoader("../res/ufo.png");
                
	}
	
}