// Estimate the value of Pi using Monte-Carlo Method, using parallel program
package Mesure;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
class PiMonteCarloFaible {
	AtomicInteger nAtomSuccess;
	int nThrows;
	double value;
	class MonteCarlo implements Runnable {
		@Override
		public void run() {
			double x = Math.random();
			double y = Math.random();
			if (x * x + y * y <= 1)
				nAtomSuccess.incrementAndGet();
		}
	}
	public PiMonteCarloFaible(int i) {
		this.nAtomSuccess = new AtomicInteger(0);
		this.nThrows = i;
		this.value = 0;
	}
	public double getPi() throws IOException {
		int nProcessors = Runtime.getRuntime().availableProcessors();
		PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/willi/IdeaProjects/All/Pro_Dev/src/Mesure/output.txt"));
		for (int e = 1; e <= nProcessors; e++) {
			nAtomSuccess = new AtomicInteger(0);
			long startTime = System.currentTimeMillis();
			ExecutorService executor = Executors.newWorkStealingPool(nProcessors); //nombre de Processeur detecter
			for (int i = 1; i <= nThrows * e; i++) {
				Runnable worker = new MonteCarlo();
				executor.execute(worker); // start runnable
			}
			executor.shutdown(); // arreter l'execution paraléle
			while (!executor.isTerminated()) { // tant que executor n'on terminer
			}
			value = 4.0 * nAtomSuccess.get() / nThrows; //Montre la valeur
			long stopTime = System.currentTimeMillis();
			writer.println(value + ";" + nThrows *e + ";" + e + ";" + (stopTime - startTime));
		}
		writer.close();
		return value;  //valeur retourner
	}
}
public class Assignment102Faible {
	public static void main(String[] args) throws IOException {
		PiMonteCarloFaible PiVal = new PiMonteCarloFaible(10000000);
		PiVal.getPi();
	}
}