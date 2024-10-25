package TP3_VBlockingQueue;

import java.util.Random;

public  class Mangeur  implements Runnable {
    Boulangerie boulangerie;
    Random rand = new Random();

    public Mangeur(Boulangerie boulangerie){
        this.boulangerie = boulangerie;
    }

    public  void run() {
            try {
                while (true) {
                    Thread.sleep(rand.nextInt(1000)) ;
                    Pain pain = boulangerie.achete() ;
                    if (pain != null) {

                        if (pain == Pain.PAIN_EMPOISONNE) {
                            System.out.println("Je meurs !") ;
                            Thread.currentThread().interrupt() ;
                        }  else {
                            System.out.println("[" + Thread.currentThread().getName() +  "]" +
                                    "[" + boulangerie.getStock() +  "] miam miam") ;
                        }

                    }  else {
                        System.out.println("[" + Thread.currentThread().getName() +  "]" +
                                "[" + boulangerie.getStock() +  "] j'ai faim") ;
                    }
                }

            }  catch (InterruptedException e) {
            }
    }

}
