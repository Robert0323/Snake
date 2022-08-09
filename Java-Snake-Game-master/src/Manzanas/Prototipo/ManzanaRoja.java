package Manzanas.Prototipo;

import Manzanas.Color.Azul;
import Manzanas.Color.Rojo;
import Manzanas.iPrototipo.Manzana;

import java.awt.*;

public class ManzanaRoja extends Manzana {
    public ManzanaRoja( Image papple){
        this.setColor(new Rojo());
        this.setImagen(papple);
    }

    @Override
    public Manzana clone() {
        return new ManzanaAmarrilla(this.getImagen());
    }

}

