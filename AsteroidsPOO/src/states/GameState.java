package states;

import java.awt.Graphics;

import gameObjets.Player;
import gameObjets.movingObject;
import graphics.Assets;
import java.util.ArrayList;
import math.Vector2D;



public class GameState {
    private Player player;
    private ArrayList<movingObject> movingObjects = new ArrayList<movingObject>();

    public GameState(){
        player = new Player(new Vector2D(100, 500), new Vector2D(),7, Assets.player,this);
        movingObjects.add(player);
    }
    public void update(){
        for(int i = 0; i < movingObjects.size();i++){
            movingObjects.get(i).update();
        }
    }
    public void draw(Graphics g){
      for(int i = 0; i < movingObjects.size();i++){
            movingObjects.get(i).draw(g);
        }
    }
    public ArrayList<movingObject> getmovingObjects(){
        return movingObjects;
    }
}