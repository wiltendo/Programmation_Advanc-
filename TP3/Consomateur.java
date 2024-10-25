package TP3;

public class Consomateur extends Thread{
    String Lettre;
    BAL bal;

    public Consomateur(BAL bals) throws InterruptedException {
        Lettre="";
        bal=bals;
    }

    public void run() {
        Lettre = bal.Retirer();
        while (Lettre==""){
            System.out.println(Lettre);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Lettre = bal.Retirer();
        }
        System.out.println("Contenue de la Lettre : " + Lettre);
    }
}
