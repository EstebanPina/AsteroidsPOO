package gameObjets;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import math.Vector2D;

public abstract class movingObject extends GameObject{
	
	protected Vector2D velocity;
	protected AffineTransform at;
	protected double angle;
        protected double maxVel;
	protected int width;
        protected int height;
	public movingObject(Vector2D position, Vector2D velocity,double maxVel, BufferedImage texture) {
		super(position, texture);
		this.velocity = velocity;
                this.maxVel=maxVel;
                width = texture.getWidth();
                height = texture.getHeight();
		angle = 0;
		
	}

}
