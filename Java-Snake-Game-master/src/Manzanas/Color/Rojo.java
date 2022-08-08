package Manzanas.Color;

import javax.swing.*;

public class Rojo extends Color{
    private String nombre;
    public Rojo() {
        this.nombre = "red";
        this.setPuntos(2);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
