package Manzanas.Prototipo;

import Manzanas.Color.Amarillo;
import Manzanas.Color.Azul;
import Manzanas.Color.Rojo;
import Manzanas.iPrototipo.Manzana;
import java.awt.Image;

import javax.swing.*;

public class ManzanaAmarrilla extends Manzana {
    public ManzanaAmarrilla( Image papple){
        this.setColor(new Amarillo());
        this.setImagen(papple);
    }

    @Override
    public Manzana clone() {
        return new ManzanaAmarrilla(this.getImagen());
    }

}

    /*ManzanaAmarrilla(String pcolor,ImageIcon papple){
        if (pcolor == "Azul"){
            color = new Azul( papple);
        }else if (pcolor == "Amarrillo"){
            color = new Amarillo(papple);
        }else {
            color = new Rojo(papple);
        }

    }*/