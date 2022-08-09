package Decorator.Color;

import Decorator.Body.Body;

import javax.swing.*;
import java.awt.*;

public class Green extends Colors {
    Body body;

    public Green(Body pbody)
    {
        this.body=pbody;
    }

    @Override
    public void setname(){

        this.color = "Green";
    }

    @Override
    public Image setcolor() {
        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        return iid.getImage();
    }
}
