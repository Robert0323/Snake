package Manzanas.Color;

import javax.swing.*;

public class Azul extends Color{
    private String nombre;

    public Azul( ){
        this.nombre = "blue";
        this.setPuntos(1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
