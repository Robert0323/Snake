package com.zetcode;

import Decorator.Body.Body;
import Decorator.Body.BodyClassic;
import Decorator.Color.Green;
import Decorator.Color.Orange;
import Decorator.Color.Purple;
import Manzanas.Prototipo.ManzanaAmarrilla;
import Manzanas.Prototipo.ManzanaAzul;
import Manzanas.Prototipo.ManzanaRoja;
import Manzanas.iPrototipo.Manzana;
import Memento.Memento;
import javafx.scene.control.Labeled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;

    //class color the prototype
    private Manzana Roja;
    private Manzana Amarrilla;
    private Manzana Azul;

    //class color the decorator
    private Purple purple;
    private Orange orange;
    private Green green;

    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    //For memento

    private int dots;
    private int apple_x;
    private int apple_y;

    private Timer timer;
    private Image ball;
    private Manzana apple;
    private Image head;

    //class body the decorator
    private Body corps;

    private int points;
    private int lives = 3;
    private int DELAY = 140;

    private int chek=0;
    private Memento memento;

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        /* ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();
        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage(); */

        //Create snake body classic or initial( green and red) with the decorator pattern

        corps = new BodyClassic();
        ball = corps.setcolor();
        head = corps.head;

        //Create Manzana objects, for later use in game change points
        ImageIcon irj = new ImageIcon("src/resources/applered.png");
        Roja = new ManzanaRoja(irj.getImage());
        ImageIcon iaz = new ImageIcon("src/resources/appleyellow.png");
        Amarrilla = new ManzanaAmarrilla(iaz.getImage());
        ImageIcon iam = new ImageIcon("src/resources/appleblue.png");
        Azul = new ManzanaAzul(iam.getImage());

    }

    private void chagecolor(){

        //Use random number for change apple color
        Random generadorAleatorios = new Random();
        int numeroAleatorio = generadorAleatorios.nextInt(3);
        if (numeroAleatorio == 0){
            apple = Azul;
        }else if(numeroAleatorio == 1){
            apple = Roja;
        }else{
            apple = Amarrilla;
        }

    }
    private void changeBodyColor(){
        if (apple.getColor().getNombre() == "red"){
            corps = new Purple(corps);
        }else if (apple.getColor().getNombre() == "blue"){
            corps = new Orange(corps);
        }else{
            corps = new Green(corps);
        }
        ball = corps.setcolor();
    }
    private void initGame() {

        dots = 3;
        points = 0;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        locateApple();
        chagecolor();

        memento = new Memento(dots,apple_x,apple_y,timer,ball,apple,head ,corps,points,lives,DELAY,x,y);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+points,(B_WIDTH-50- metrics.stringWidth("Score: "+points))/2,g.getFont().getSize());
            g.drawString("Lives: "+lives,(B_WIDTH+50 - metrics.stringWidth("Lives: "+lives))/2,g.getFont().getSize());
            g.drawString(String.valueOf(points),0,0);
            g.drawImage(apple.getImagen(), apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = String.valueOf("Final score:  "+points+"\n"+".  Game Over");
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    void restore(){
        dots = memento.get_Snapshoot().getDots();
        apple_x = memento.get_Snapshoot().getApple_x();
        apple_y = memento.get_Snapshoot().getApple_y();
        timer = memento.get_Snapshoot().getTimer();
        ball = memento.get_Snapshoot().getBall();
        apple = memento.get_Snapshoot().getApple();
        head = memento.get_Snapshoot().getHead();
        corps = memento.get_Snapshoot().getCorps();
        points = memento.get_Snapshoot().getPoints();
        DELAY = memento.get_Snapshoot().getDELAY();
        x = memento.get_Snapshoot().getX();
        y = memento.get_Snapshoot().getY();
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;/*
            if (chek >= 5){
                memento.restore();
            }*/
            points += apple.getColor().getPuntos();
            //Stay here for where the snake eat the apple change velocity
            if(DELAY > 100){
                DELAY = DELAY-4;
                timer.setDelay(DELAY);
            }
            changeBodyColor();
            chagecolor();
            locateApple();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                if (lives !=0 ){
                    lives--;
                    restore();
                }else {
                    inGame = false;
                }
            }
        }

        if (y[0] >= B_HEIGHT) {
            if (lives !=0 ){
                lives--;
                restore();
            }else {
                inGame = false;
            }
        }

        if (y[0] < 0) {
            if (lives !=0 ){
                lives--;
                restore();
            }else {
                inGame = false;
            }
        }

        if (x[0] >= B_WIDTH) {
            if (lives !=0 ){
                lives--;
                restore();
            }else {
                inGame = false;
            }
        }

        if (x[0] < 0) {
            if (lives !=0 ){
                lives--;
                restore();
            }else {
                inGame = false;
            }
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
