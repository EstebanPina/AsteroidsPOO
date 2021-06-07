package states;

import gameObjets.Constants;
import static gameObjets.Constants.PLAYER_MAX_VEL;
import gameObjets.Meteor;
import java.awt.Graphics;

import gameObjets.Ufo;
import gameObjets.Player;
import gameObjets.Size;
import gameObjets.movingObject;
import graphics.Animation;
import graphics.Assets;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import math.Vector2D;





public class GameState {
    private Player player;
    private ArrayList<movingObject> movingObjects = new ArrayList<movingObject>();
    private ArrayList<Animation> explosions = new ArrayList<Animation>();

    private int meteors;
    
    public GameState(){
       player = new Player(new Vector2D(100, 500), new Vector2D(),PLAYER_MAX_VEL, Assets.player,this);
        movingObjects.add(player);
        meteors=1;
        startWave();
    }
    public void divideMeteor(Meteor meteor){
        Size size = meteor.getSize();
		
		BufferedImage[] textures = size.textures;
		
		Size newSize = null;
		
		switch(size){
		case BIG:
			newSize =  Size.MED;
			break;
		case MED:
			newSize = Size.SMALL;
			break;
		case SMALL:
			newSize = Size.TINY;
			break;
		default:
			return;
		}
		
		for(int i = 0; i < size.quantity; i++){
			movingObjects.add(new Meteor(
					meteor.getPosition(),
					new Vector2D(0, 1).setDirection(Math.random()*Math.PI*2),
					Constants.METEOR_VEL*Math.random() + 1,
					textures[(int)(Math.random()*textures.length)],
					this,
					newSize
					));
		}	

    }
    private void startWave(){
        double x,y;
        for(int i=0; i<meteors; i++){
            x=i%2==0 ? Math.random()*Constants.WIDTH : 0;
            y=i%2==0 ? 0 : Math.random()*Constants.WIDTH;
            BufferedImage texture=Assets.big[(int)(Math.random()*Assets.big.length)];
            movingObjects.add(new Meteor(
                    new Vector2D(x,y),
                    new Vector2D(0,1).setDirection(Math.random()*Math.PI*2),
                    Constants.METEOR_VEL*Math.random()+1,
                    texture,
                    this,
                    Size.BIG
            ));
        }
        meteors ++;
        spawnUfo();
    }
    public void playExplosion(Vector2D position){
        explosions.add(new Animation(
            Assets.exp, 
            50, 
            position.subtract(new Vector2D(Assets.exp[0].getWidth()/2, Assets.exp[0].getHeight()/2))
            ));

    }
    private void spawnUfo(){
		
		int rand = (int) (Math.random()*2);
		
		double x = rand == 0 ? (Math.random()*Constants.WIDTH): 0;
		double y = rand == 0 ? 0 : (Math.random()*Constants.HEIGHT);
		
		ArrayList<Vector2D> path = new ArrayList<Vector2D>();
		
		double posX, posY;
		
		posX = Math.random()*Constants.WIDTH/2;
		posY = Math.random()*Constants.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));

		posX = Math.random()*(Constants.WIDTH/2) + Constants.WIDTH/2;
		posY = Math.random()*Constants.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));
		
		posX = Math.random()*Constants.WIDTH/2;
		posY = Math.random()*(Constants.HEIGHT/2) + Constants.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));
		
		posX = Math.random()*(Constants.WIDTH/2) + Constants.WIDTH/2;
		posY = Math.random()*(Constants.HEIGHT/2) + Constants.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));
		
		movingObjects.add(new Ufo(
				new Vector2D(x, y),
				new Vector2D(),
				Constants.UFO_MAX_VEL,
				Assets.ufo,
				path,
				this
				));
		
	}
    public void update(){
        for(int i = 0; i < movingObjects.size();i++)
            movingObjects.get(i).update();

        for(int i = 0; i < explosions.size(); i++){
            Animation anim = explosions.get(i);
            anim.update();
            if(!anim.isRunning()){
                explosions.remove(i);
            }
        }
            
         for(int i = 0; i < movingObjects.size();i++)
             if(movingObjects.get(i) instanceof Meteor)
                 return;
        
        startWave();
    }
    public void draw(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      for(int i = 0; i < movingObjects.size();i++){
            movingObjects.get(i).draw(g);
        }
      for(int i = 0; i < explosions.size(); i++){
            Animation anim = explosions.get(i);
            g2d.drawImage(anim.getCurrentFrame(), (int)anim.getPosition().getX(), (int)anim.getPosition().getY(), null);
      }
    }
    public ArrayList<movingObject> getmovingObjects(){
        return movingObjects;
    }
    public Player getPlayer() {
		return player;
	}
}