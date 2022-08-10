package Memento;

import Decorator.Body.Body;
import Manzanas.iPrototipo.Manzana;
import Memento.Snapshoot.Snapshoot;

import javax.swing.*;
import java.awt.*;

public class Origin {
    public Snapshoot _Estado;

    public Origin() {
        _Estado = new Snapshoot();
    }

    public void nuevoEstado(int dots, int apple_x, int apple_y, Timer timer, Image ball, Manzana apple, Image head, Body corps, int points, int lives, int DELAY,int[] x, int[] y) {
        this._Estado.nuevaInstantanea(dots, apple_x, apple_y, timer, ball, apple, head, corps, points, lives, DELAY,x,y);
    }

    /*public String obtenerEstado() {
        return "Originador> estado actual [" +
                this._Estado.obtenerInstantanea().get(0) + " " +
                this._Estado.obtenerInstantanea().get(1) + "]" ;
    }*/


/*==========================================================================
 *						 Seccion donde usamos el memento.
 ==========================================================================*/

    public void restaurarMemento(Memento m) {
        this._Estado.nuevaInstantanea(m.get_Snapshoot().getDots(), m.get_Snapshoot().getApple_x(), m.get_Snapshoot().getApple_y(), m.get_Snapshoot().getTimer(), m.get_Snapshoot().getBall(), m.get_Snapshoot().getApple(), m.get_Snapshoot().getHead(), m.get_Snapshoot().getCorps(), m.get_Snapshoot().getPoints(), m.get_Snapshoot().getLives(), m.get_Snapshoot().getDELAY(),m.get_Snapshoot().getX(),m.get_Snapshoot().getY());
    }

    public Memento crearMemento() {
        return new Memento(this._Estado.getDots(),this._Estado.getApple_x(),this._Estado.getApple_y(),this._Estado.getTimer(),this._Estado.getBall(),this._Estado.getApple(),this._Estado.getHead(),this._Estado.getCorps(),this._Estado.getPoints(),this._Estado.getLives(),this._Estado.getDELAY(),this._Estado.getX(),this._Estado.getY());
    }
}
