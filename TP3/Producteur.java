package TP3;

public class Producteur extends Thread {
    BAL bal;
    String Lettre;

    public Producteur(String lettre,BAL bals) throws InterruptedException {
        bal = bals;
        Lettre = lettre;
    }

    public void run(){
        while (!bal.Depot(Lettre)){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        bal.Depot(Lettre);
    }

}
