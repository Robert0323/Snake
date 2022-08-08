package Manzanas.Color;

import javax.swing.*;


public class Amarillo extends Color{
    private String nombre;


    public Amarillo() {
        this.nombre = "yellow";
        this.setPuntos(3);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}