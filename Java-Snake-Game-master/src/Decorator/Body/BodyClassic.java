package Decorator.Body;

import javax.swing.*;
import java.awt.*;

public class BodyClassic extends Body{
    public BodyClassic(){
        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        body = iid.getImage();
        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }

    @Override
    public Image setcolor() {
        return body;
    }
}
