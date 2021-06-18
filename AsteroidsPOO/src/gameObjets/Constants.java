/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjets;

public class Constants {
    //Constantes Window
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    //Constantes Player
    public static final int FIRERATE =300;
    public static final double ACC=0.2;
    public static final double DELTAANGLE=0.1;
    public static final double PLAYER_MAX_VEL = 7.0;
    public static final long FLICKER_TIME = 200;
    public static final long SPAWNING_TIME = 3000;
    public static final long GAME_OVER_TIME=3000;
     //Constantes Laser
    public static final double LASER_VEL=15.0;
     //Constantes meteoro
    public static final double METEOR_VEL=2.0;
     //Constantes Ufo
    public static final double NODE_RADIUS = 160;
    public static final double UFO_MASS = 60;
    public static final double UFO_MAX_VEL = 3;
    public static long UFO_FIRE_RATE = 1000;
    public static long UFO_SPAWN_RATE = 10000;
    public static double UFO_ANGLE_RANGE=Math.PI/2;
    //Constantes Puntos(SCORE)
    public static int UFO_SCORE=40;
    public static int METEOR_SCORE=20;
    public static final String PLAY= "PLAY";
    public static final String Exit= "EXIT";
    //Constantes barras de carga
    public static final int LOADING_BAR_WIDTH=500;
    public static final int LOADING_BAR_HEIGHT=50;
}
