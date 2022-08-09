package Decorator.Color;

import Decorator.Body.Body;

import javax.swing.*;
import java.awt.*;

public class Purple extends Colors{
    Body body;

    public Purple(Body pbody)
    {
        this.body=pbody;
    }

    @Override
    public void setname(){

        this.color = "Purple";
    }

    @Override
    public Image setcolor() {
        ImageIcon iid = new ImageIcon("src/resources/dotMorado.png");
        return iid.getImage();
    }
}
