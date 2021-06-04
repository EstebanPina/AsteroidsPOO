package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player;
	// efectos
        public static BufferedImage speed;
        public static BufferedImage blueLaser;
        public static BufferedImage greenLaser;
        public static BufferedImage redLaser;
	public static void init()
	{
		player = Loader.ImageLoader("../res/player.png");
                speed = Loader.ImageLoader("../res/effects/fire08.png");
                blueLaser=Loader.ImageLoader("../res/lasers/laserBlue01.png");
                greenLaser=Loader.ImageLoader("../res/lasers/laserGreen11.png");
                redLaser=Loader.ImageLoader("../res/lasers/laserRed01.png");
                
	}
	
}