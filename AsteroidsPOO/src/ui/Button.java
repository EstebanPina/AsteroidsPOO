/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import graphics.Assets;
import graphics.Text;
import input.MouseInput;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import math.Vector2D;

/**
 *
 * @author andyl
 */
public class Button {
    
    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private Action action;
    private String text;
    public Button( BufferedImage mouseOutImg,BufferedImage mouseInImg, int x , int y, String text,Action action){
        this.mouseInImg=mouseInImg;
        this.mouseOutImg=mouseOutImg;
        this.text=text;
        boundingBox=new Rectangle(x,y,mouseInImg.getWidth(),mouseInImg.getHeight());
        this.action=action;
        
    }
    public void update(){
        if(boundingBox.contains(MouseInput.X,MouseInput.Y)){
            mouseIn=true;
        }
        else{
            mouseIn=false;
        }
        if(mouseIn && MouseInput.MLB){
            action.doAction();
        }
    }
    public void draw(Graphics g){
        if(mouseIn){
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        }
        else{
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }
        Text.drawText(g,
                text,
                new Vector2D(boundingBox.getX()+boundingBox.getWidth()/2,
                        boundingBox.getY()+boundingBox.getHeight()/2)
                , true
                , Color.BLACK
                , Assets.fontMed);
    }
    
}
