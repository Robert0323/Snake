package Memento.Snapshoot;

import Decorator.Body.Body;
import Manzanas.iPrototipo.Manzana;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snapshoot {

    private int x[] = new int[900];
    private int y[] = new int[900];

    private int dots;
    private int apple_x;
    private int apple_y;

    private Timer timer;
    private Image ball;
    private Manzana apple;
    private Image head;

    //class body the decorator
    private Body corps;

    private int points;
    private int lives = 3;
    private int DELAY = 140;

    public void nuevaInstantanea(int dots, int apple_x, int apple_y, Timer timer, Image ball, Manzana apple, Image head, Body corps, int points, int lives, int DELAY,int[] x, int[] y) {
        this.dots = dots;
        this.apple_x = apple_x;
        this.apple_y = apple_y;
        this.timer = timer;
        this.ball = ball;
        this.apple = apple;
        this.head = head;
        this.corps = corps;
        this.points = points;
        this.lives = lives;
        this.DELAY = DELAY;
        this.x = x;
        this.y = y;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public int getDots() {
        return dots;
    }

    public int getApple_x() {
        return apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public Timer getTimer() {
        return timer;
    }

    public Image getBall() {
        return ball;
    }

    public Manzana getApple() {
        return apple;
    }

    public Image getHead() {
        return head;
    }

    public Body getCorps() {
        return corps;
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    public int getDELAY() {
        return DELAY;
    }
}

