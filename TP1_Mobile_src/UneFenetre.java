package TP1_Mobile_src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class UneFenetre extends JFrame 
{

    UnMobile sonMobile;
    Thread thread;
    private final int LARG=800, HAUT=800;
    
    public UneFenetre(int nb)
    {
        super("Le Mobile");
        Container zone = getContentPane();
        zone.setLayout(new BoxLayout(zone, BoxLayout.Y_AXIS));
        for (int e=0;e<nb;e++) {
            sonMobile = new UnMobile(LARG, 25);
            zone.add(sonMobile);
            thread = new Thread(sonMobile);
            thread.start();
        }

        setSize(LARG, HAUT);
        setVisible(true);

    }
    public void Stop(){

    }
}
