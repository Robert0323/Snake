package Manzanas.iPrototipo;

import Manzanas.Color.Amarillo;
import Manzanas.Color.Azul;
import Manzanas.Color.Rojo;
import Manzanas.Color.Color;

import javax.swing.*;
import java.awt.*;


public abstract class Manzana {
    private Color color;
    private Image imagen;

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract Manzana clone();
}
