package TP2;

public final class CemaphoreBinaire extends Cemaphore {
	public CemaphoreBinaire(int valeurInitiale){
		super((valeurInitiale != 0) ? 1:0);
		//System.out.print(valeurInitiale);
	}
	public final synchronized void syncSignal(){
		super.syncSignal();
		//System.out.print(valeur);
		if (valeur>1) valeur = 1;
	}
}

