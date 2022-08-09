package Manzanas.Color;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Color {
    private int puntos;
    private String nombre;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
