package graphics;

import java.awt.image.BufferedImage;
import java.awt.Font;

import javax.sound.sampled.Clip;

public class Assets {
    
        public static boolean loaded=false;
        public static float count=0;
        public static float MAX_COUNT=46;
	
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
    //Numeros
    public static BufferedImage[] numbers=new BufferedImage[11];
    //Vidas
    public static BufferedImage life;
    //Botones
     public static BufferedImage greyBtn;
      public static BufferedImage blueBtn;
    //Fonts -- Fuentes
    public static Font fontBig;
	public static Font fontMed;
    //Sonidos
    public static Clip backgroundMusic, explosion, playerLose, playerShoot, ufoShoot;

	public static void init()
	{
		player = loadImage("../res/player.png");
                speed = loadImage("../res/effects/fire08.png");
                blueLaser=loadImage("../res/lasers/laserBlue01.png");
                greenLaser=loadImage("../res/lasers/laserGreen11.png");
                redLaser=loadImage("../res/lasers/laserRed01.png");
                for (int i = 0; i<big.length;i++)
                    big[i]=loadImage("../res/meteors/big"+(i+1)+".png");
                for (int i = 0; i<meds.length;i++)
                    meds[i]=loadImage("../res/meteors/med"+(i+1)+".png");
                for (int i = 0; i<smalls.length;i++)
                    smalls[i]=loadImage("../res/meteors/small"+(i+1)+".png");
                for (int i = 0; i<tinies.length;i++)
                    tinies[i]=loadImage("../res/meteors/tiny"+(i+1)+".png");
                for (int i = 0; i<exp.length; i++)
                    exp[i] = loadImage("../res/explosion/"+i+".png");
                 for (int i = 0; i<numbers.length; i++)
                    numbers[i] = loadImage("../res/numbers/numeral"+i+".png");
                
                ufo = loadImage("../res/ufo.png");
                life=loadImage("../res/life/life.png");
                greyBtn=loadImage("../res/ui/grey_button01.png");
                blueBtn=loadImage("../res/ui/blue_button00.png");
                fontBig=loadFont("../res/fonts/futureFont.ttf", 42);
                fontMed=loadFont("../res/fonts/futureFont.ttf", 20);

                backgroundMusic = loadSound("../res/sounds/backgroundMusic.wav");
		        explosion = loadSound("../res/sounds/explosion.wav");
		        playerLose = loadSound("../res/sounds/playerLose.wav");
		        playerShoot = loadSound("../res/sounds/playerShoot.wav");
		        ufoShoot = loadSound("../res/sounds/ufoShoot.wav");
                        loaded=true;
	}
        public static BufferedImage loadImage(String path){
            count++;
            return Loader.ImageLoader(path);
        }
        public static Font loadFont(String path,int size){
            count++;
            return Loader.loadFont(path, size);
        }
        public static Clip loadSound(String path){
            count++;
            return Loader.loadSound(path);
        }
	
}