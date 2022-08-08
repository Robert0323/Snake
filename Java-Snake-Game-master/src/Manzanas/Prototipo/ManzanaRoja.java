package Manzanas.Prototipo;

import Manzanas.Color.Azul;
import Manzanas.iPrototipo.Manzana;

import java.awt.*;

public class ManzanaRoja extends Manzana {
    public ManzanaRoja( Image papple){
        this.setColor(new Azul());
        this.setImagen(papple);
    }

    @Override
    public Manzana clone() {
        return new ManzanaAmarrilla(this.getImagen());
    }

}

