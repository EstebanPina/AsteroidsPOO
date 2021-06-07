/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjets;

import graphics.Assets;
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
public class Meteor extends movingObject{
    
    private Size size;

    public Meteor(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState, Size size) {
        super(position, velocity, maxVel, texture, gameState);
        this.size= size;
    }
    

    @Override
    public void update() {
        position = position.add(velocity);
        if(position.getX()>Constants.WIDTH)
         position.setX(0);
         if(position.getX()<0)
         position.setX(Constants.WIDTH);
          if(position.getY()>Constants.HEIGHT)
         position.setY(0);
         if(position.getY()<0)
         position.setY(Constants.HEIGHT);
         
         angle += Constants.DELTAANGLE;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
	at.rotate(angle, width/2, height/2);
	g2d.drawImage(texture, at, null);
    }
    public Size getSize(){
        return size;
    }
    
}
