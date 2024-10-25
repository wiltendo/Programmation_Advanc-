package TP2; /**
 * 
 */
import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Affichage extends Thread{
	String texte;
	CemaphoreBinaire cemaphore;


	public Affichage (String txt,CemaphoreBinaire CB){
		texte=txt;
		cemaphore=CB;
	}
	
	public void run(){

		/* synchronized (System.out) { */
		cemaphore.syncWait();
		for (int i = 0; i < texte.length(); i++) {

			System.out.print(texte.charAt(i));
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
		cemaphore.syncSignal();




	}
}
