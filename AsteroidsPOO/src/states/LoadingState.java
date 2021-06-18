/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gameObjets.Constants;
import graphics.Assets;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andyl
 */
public class LoadingState extends State {
    private Thread loadingThread;
    
    public LoadingState(Thread loadingThread){
        this.loadingThread=loadingThread;
        this.loadingThread.start();
    }

    @Override
    public void update() {
        if(Assets.loaded){
            State.changeState(new MenuState());
            try {
                loadingThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(LoadingState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        GradientPaint gp=new GradientPaint(
                Constants.WIDTH/2-Constants.LOADING_BAR_WIDTH/2,
                Constants.HEIGHT/2-Constants.LOADING_BAR_HEIGHT/2,
                Color.WHITE,
                Constants.WIDTH/2+Constants.LOADING_BAR_WIDTH/2,
                Constants.HEIGHT/2+Constants.LOADING_BAR_HEIGHT/2,
                Color.BLUE);
        Graphics2D g2d= (Graphics2D)g;
        g2d.setPaint(gp);
        float average = (Assets.count/Assets.MAX_COUNT);
        g2d.fillRect(Constants.WIDTH/2-Constants.LOADING_BAR_WIDTH/2,
                    Constants.HEIGHT/2-Constants.LOADING_BAR_HEIGHT/2,
                (int)(Constants.LOADING_BAR_WIDTH*average),
                Constants.LOADING_BAR_HEIGHT);
        g2d.drawRect(Constants.WIDTH/2-Constants.LOADING_BAR_WIDTH/2,
                    Constants.HEIGHT/2-Constants.LOADING_BAR_HEIGHT/2,
                    Constants.LOADING_BAR_WIDTH,
                    Constants.LOADING_BAR_HEIGHT);
    }
    
}
