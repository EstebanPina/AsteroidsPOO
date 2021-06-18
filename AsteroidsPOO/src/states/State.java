/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.Graphics;

/**
 *
 * @author andyl
 */
public abstract class State {
    private static State currentState= null;
    public static State getCurrentState() {
    return currentState;
    }
    public static void changeState(State newState){
        currentState=newState;
    }
    public abstract void update();
    public abstract void draw(Graphics g);
}
