package Mesure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class AutoPiFaible {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner saisie = new Scanner(System.in);
        System.out.println("Entre le nombre de Points :");
        int nT = saisie.nextInt();

        System.out.println("Entre le nombre de Processeur :");
        int nP = saisie.nextInt();

        System.out.println("Entre le nombre de Boucle :");
        int nB = saisie.nextInt();

        new MasterFaible().doRun(nT, nP,nB);
    }

}

class WorkerFaible implements Callable<Long>
{
    private int numIterations;
    public WorkerFaible(int num)
    {
        this.numIterations = num;
    }

    @Override
    public Long call()
    {
        long circleCount = 0;
        Random prng = new Random ();
        for (int j = 0; j < numIterations; j++)
        {
            double x = prng.nextDouble();
            double y = prng.nextDouble();
            if ((x * x + y * y) < 1)  ++circleCount;
        }
        return circleCount;
    }
}

class MasterFaible {
    public long doRun(int totalCount, int numWorkers,int numBoucle) throws InterruptedException, ExecutionException
    {
        ExecutorService exec = null;
        long total = 0;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/willi/IdeaProjects/All/Pro_Dev/src/Mesure/output_G26_4c.txt"));

            for(int j=1;j<=numWorkers;j++) {
                long startTime=0;
                long stopTime=0;
                double pi=0;
                long sumTime = 0;
                for(int k=0;k<numBoucle;k++) {
                    startTime = System.currentTimeMillis();

                    List<Callable<Long>> tasks = new ArrayList<Callable<Long>>();
                    for (int i = 0; i < j; ++i) {
                        tasks.add(new WorkerFaible(totalCount));
                    }

                    exec = Executors.newFixedThreadPool(j);
                    List<Future<Long>> results = exec.invokeAll(tasks);
                    total = 0;

                    for (Future<Long> f : results) {
                        total += f.get();
                    }
                    pi = pi+ (Math.abs(((4.0 * total / totalCount)- Math.PI)) / Math.PI);

                    stopTime = System.currentTimeMillis();
                    sumTime=sumTime + (stopTime - startTime);
                    exec.shutdown();
                }


                writer.println(pi/numBoucle + ";" + totalCount+ ";" + j + ";" + sumTime/numBoucle);

            }

            writer.close();

            System.out.println("Successfully wrote text to file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return total;
    }
}