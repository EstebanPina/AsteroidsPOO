package gameObjets;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import math.Vector2D;

public abstract class movingObject extends GameObject{
	
	protected Vector2D velocity;
	protected AffineTransform at;
	protected double angle;
	
	public movingObject(Vector2D position, Vector2D velocity, BufferedImage texture) {
		super(position, texture);
		this.velocity = velocity;
		angle = 0;
		
	}

}
