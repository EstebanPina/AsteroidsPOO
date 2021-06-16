package gameObjets;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graphics.Assets;
import graphics.Sound;
import math.Vector2D;
import states.GameState;

public abstract class movingObject extends GameObject{
	
	protected Vector2D velocity;
	protected AffineTransform at;
	protected double angle;
    protected double maxVel;
	protected int width;
    protected int height;
	protected GameState gameState;

	private Sound explosion;

	public movingObject(Vector2D position, Vector2D velocity,double maxVel, BufferedImage texture,GameState gameState) {
		super(position, texture);
		this.velocity = velocity;
        this.maxVel=maxVel;
        this.gameState=gameState;
        width = texture.getWidth();
        height = texture.getHeight();
		angle = 0;
		explosion = new Sound(Assets.explosion);
		
	}
	protected void collidesWith(){
		ArrayList<movingObject> movingObjects = gameState.getmovingObjects(); 
		
		for(int i = 0; i < movingObjects.size(); i++){
			movingObject m  = movingObjects.get(i);
			
			if(m.equals(this))
				continue;
			
			double distance = m.getCenter().subtract(getCenter()).getMagnitude();
			
			if(distance < m.width/2 + width/2 && movingObjects.contains(this)){
				objectCollision(m, this);
			}
		}
	}
	private void objectCollision(movingObject a, movingObject b){
		if(a instanceof Player && ((Player)a).isSpawning()){
                    return;
                }
                if(b instanceof Player && ((Player)b).isSpawning()){
                    return;
                }
		if(!(a instanceof Meteor && b instanceof Meteor)){
			gameState.playExplosion(getCenter());
			a.Destroy();
			b.Destroy();
		}
		
	}
	protected void Destroy(){
		gameState.getmovingObjects().remove(this);
		if(!(this instanceof Laser))
			explosion.play();
	}
	protected Vector2D getCenter(){
		return new Vector2D(position.getX() + width/2, position.getY() + height/2);
	}
}
