package TP1_2;

import javax.swing.*;
import java.awt.*;

class UneFenetre extends JFrame 
{

    UnMobile sonMobile;
    Thread thread;
    int vitesse = 50;
    private final int LARG=800, HAUT=800;
    CemaphoreGeneral CB;
    
    public UneFenetre(int nb)
    {
        super("Le Mobile");
        CB = new CemaphoreGeneral(5);
        Container zone = getContentPane();
        zone.setLayout(new BoxLayout(zone, BoxLayout.Y_AXIS));
        for (int e=0;e<nb;e++) {
            sonMobile = new UnMobile(LARG, 20,CB);
            zone.add(sonMobile);
            thread = new Thread(sonMobile);
            thread.start();
            vitesse += 25;
        }

        setSize(LARG, HAUT);
        setVisible(true);

    }
    public void Stop(){

    }
}
