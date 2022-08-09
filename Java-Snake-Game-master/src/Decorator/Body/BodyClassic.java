package Decorator.Body;

import javax.swing.*;
import java.awt.*;

public class BodyClassic extends Body{
    public BodyClassic(){
        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        this.body = iid.getImage();
        ImageIcon iih = new ImageIcon("src/resources/head.png");
        this.head = iih.getImage();
        this.color = "Green";
    }

    @Override
    public Image setcolor() {
        return body;
    }
}
