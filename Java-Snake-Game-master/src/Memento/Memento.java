package Memento;

import Decorator.Body.Body;
import Manzanas.iPrototipo.Manzana;
import Memento.Snapshoot.Snapshoot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Memento {
    private Snapshoot _Snapshoot;

    public Snapshoot get_Snapshoot() {
        return _Snapshoot;
    }

    public Memento(int dots, int apple_x, int apple_y, Timer timer, Image ball, Manzana apple, Image head, Body corps, int points, int lives, int DELAY,int[] x, int[] y) {
        this._Snapshoot = new Snapshoot();
        this.get_Snapshoot().nuevaInstantanea(dots,apple_x,apple_y,timer,ball,apple,head ,corps,points,lives,DELAY,x,y);
    }

}
