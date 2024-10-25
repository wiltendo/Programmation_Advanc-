package TP3_VBlockingQueue;

public class main{
    public  static  void main(String[] args) {
        final Boulangerie boulangerie =  new Boulangerie() ;

        Boulanger boulanger =  new Boulanger(boulangerie) ;

        Mangeur mangeur =  new Mangeur(boulangerie) ;

        Thread [] boulangers =  new Thread[5] ;
        Thread [] mangeurs =  new Thread[2] ;

        for (int i =  0 ; i < boulangers.length ; i++) {
            boulangers[i] =  new Thread(boulanger) ;
        }

        for (int i =  0 ; i < mangeurs.length ; i++) {
            mangeurs[i] =  new Thread(mangeur) ;
        }

        for (int i =  0 ; i < boulangers.length ; i++) {
            boulangers[i].start() ;
        }

        for (int i =  0 ; i < mangeurs.length ; i++) {
            mangeurs[i].start() ;
        }
        try {
            Thread.sleep(20000) ;
        }  catch (InterruptedException e) {
        }

        for (int i =  0 ; i < boulangers.length ; i++) {
            // interruption des producteurs
            boulangers[i].interrupt() ;
        }

        // dépôt des pilules empoisonnées
        for (int i =  0 ; i < mangeurs.length ; i++) {
            boulangerie.deposePainEmpoisonne() ;
        }
    }

}