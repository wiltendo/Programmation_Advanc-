package TP2;

import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CemaphoreBinaire CB = new CemaphoreBinaire(1);

		Affichage TA = new Affichage("AAA",CB);
		Affichage TB = new Affichage("BB",CB);
		Affichage TC = new Affichage("CCC",CB);
		Affichage TD = new Affichage("DD",CB);
		Affichage TE = new Affichage("EEEE",CB);
		Affichage TF = new Affichage("FFF",CB);
		Affichage TG = new Affichage("GGG",CB);

		TB.start();
		TA.start();
		TC.start();
		TD.start();
		TE.start();
		TF.start();
		TG.start();
	}

}
