package states;

import gameObjets.Constants;
import static gameObjets.Constants.PLAYER_MAX_VEL;
import gameObjets.Meteor;
import java.awt.Graphics;

import gameObjets.Player;
import gameObjets.Size;
import gameObjets.movingObject;
import graphics.Assets;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import math.Vector2D;



public class GameState {
    private Player player;
    private ArrayList<movingObject> movingObjects = new ArrayList<movingObject>();
    private int meteors;
    
    public GameState(){
       player = new Player(new Vector2D(100, 500), new Vector2D(),PLAYER_MAX_VEL, Assets.player,this);
        movingObjects.add(player);
        meteors=1;
        startWave();
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
    }
    public void update(){
        for(int i = 0; i < movingObjects.size();i++)
            movingObjects.get(i).update();
            
         for(int i = 0; i < movingObjects.size();i++)
             if(movingObjects.get(i) instanceof Meteor)
                 return;
        
    }
    public void draw(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      for(int i = 0; i < movingObjects.size();i++){
            movingObjects.get(i).draw(g);
        }
    }
    public ArrayList<movingObject> getmovingObjects(){
        return movingObjects;
    }
}