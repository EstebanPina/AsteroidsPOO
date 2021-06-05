/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjets;

import asteroidspoo.Window;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import math.Vector2D;
import states.GameState;

/**
 *
 * @author andyl
 */
public class Laser extends movingObject{
    public Laser(Vector2D position, Vector2D velocity,double maxVel,double angle, BufferedImage texture, GameState gameState){
    super (position,velocity,maxVel,texture, gameState);
    this.angle = angle;
    this.velocity=velocity.scale(maxVel);
    }

    @Override
    public void update() {
        position = position.add(velocity);
        if(position.getX()>Constants.WIDTH)
         gameState.getmovingObjects().remove(this);
         if(position.getX()<0)
        gameState.getmovingObjects().remove(this);
          if(position.getY()>Constants.HEIGHT)
         gameState.getmovingObjects().remove(this);
         if(position.getY()<0)
         gameState.getmovingObjects().remove(this);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d=(Graphics2D)g;
        at=AffineTransform.getTranslateInstance(position.getX()-width/2, position.getY());
        at.rotate(angle,width/2,0);
        g2d.drawImage(texture, at, null);
    }
}
