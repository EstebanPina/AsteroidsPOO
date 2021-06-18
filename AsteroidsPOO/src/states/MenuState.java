/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gameObjets.Constants;
import graphics.Assets;
import java.awt.Graphics;
import java.util.ArrayList;
import ui.Action;
import ui.Button;

/**
 *
 * @author andyl
 */
public class MenuState extends State {

    private ArrayList<Button> buttons;
    public MenuState(){
        buttons = new ArrayList <Button>();
        buttons.add(new Button(Assets.greyBtn,
                Assets.blueBtn,
                Constants.WIDTH/2-Assets.greyBtn.getWidth()/2,
                Constants.HEIGHT/2-Assets.greyBtn.getHeight(),
                Constants.PLAY,
                new Action(){
                    @Override
                    public void doAction(){
                        State.changeState(new GameState());
                    }
                }));
         buttons.add(new Button(Assets.greyBtn,
                Assets.blueBtn,
                Constants.WIDTH/2-Assets.greyBtn.getWidth()/2,
                Constants.HEIGHT/2+Assets.greyBtn.getHeight(),
                Constants.Exit,
                new Action(){
                    @Override
                    public void doAction(){
                        System.exit(0);
                    }
                }));
        
    }
    @Override
    public void update() {
        for (Button b: buttons){
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
      for (Button b: buttons){
            b.draw(g);
        }
    }
    
}
