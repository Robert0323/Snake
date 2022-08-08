package Manzanas.Prototipo;

import Manzanas.Color.Amarillo;
import Manzanas.Color.Azul;
import Manzanas.iPrototipo.Manzana;

import java.awt.*;

public class ManzanaAzul extends Manzana {
    public ManzanaAzul( Image papple){
        this.setColor(new Azul());
        this.setImagen(papple);
    }

    @Override
    public Manzana clone() {
        return new ManzanaAmarrilla(this.getImagen());
    }

}