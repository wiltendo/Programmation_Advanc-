package TP1_2;

import javax.swing.*;
import java.awt.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin,sonTemps;
    final int sonPas = 10,sonCote=40;
	CemaphoreGeneral CB;
    
    UnMobile(int telleLargeur, int telleHauteur,CemaphoreGeneral CB)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	sonTemps = (int)(Math.random() * (200-50));
	setSize(telleLargeur, telleHauteur);
	this.CB = CB;

    }

    public void run() {
		while (true) {
			for (sonDebDessin = 0; sonDebDessin < saLargeur/3; sonDebDessin += sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException telleExcp) {
					telleExcp.printStackTrace();
				}
			}
			CB.syncWait();

			for (sonDebDessin =  saLargeur/3; sonDebDessin < (saLargeur/3)*2; sonDebDessin += sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException telleExcp) {
					telleExcp.printStackTrace();
				}
			}
			CB.syncSignal();
			for (sonDebDessin = (saLargeur/3)*2; sonDebDessin < saLargeur - sonPas; sonDebDessin += sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException telleExcp) {
					telleExcp.printStackTrace();
				}
			}
			for (sonDebDessin = saLargeur - sonPas; sonDebDessin > (saLargeur/3)*2; sonDebDessin -= sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException telleExcp) {
					telleExcp.printStackTrace();
				}
			}
			CB.syncWait();
			for (sonDebDessin = (saLargeur/3)*2; sonDebDessin > saLargeur/3; sonDebDessin -= sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException telleExcp) {
					telleExcp.printStackTrace();
				}
			}
			CB.syncSignal();
			for (sonDebDessin = saLargeur/3; sonDebDessin > 0; sonDebDessin -= sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException telleExcp) {
					telleExcp.printStackTrace();
				}
			}

		}
    }

    public void paintComponent(Graphics telCG)
    {
		if(sonDebDessin > saLargeur/3 && sonDebDessin < (saLargeur/3)*2) {
			telCG.setColor(Color.RED);
		}
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}