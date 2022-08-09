package Decorator.Color;

import Decorator.Body.Body;

import javax.swing.*;
import java.awt.*;

public class Orange extends Colors{
    Body body;

    public Orange(Body pbody)
    {
        this.body=pbody;
    }

    @Override
    public void setname(){

        this.color = "Orange";
    }

    @Override
    public Image setcolor() {
        ImageIcon iid = new ImageIcon("src/resources/dotNaranja.png");
        return iid.getImage();
    }
}
