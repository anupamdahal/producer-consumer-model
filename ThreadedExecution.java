import java.util.concurrent.*;

public class ThreadedExecution implements Runnable{

    BufferQueue myQueue;
    Generator randomSGenerator;
    Sorter sSorter;

    
    ExecutorService exeGenerator;
    ExecutorService exeSorter;

    public ThreadedExecution(int sizeQueue, int noGenerator, int noSorter, int noString){
        this.myQueue = new BufferQueue(sizeQueue);
        this.randomSGenerator = new Generator(myQueue, noString);
        this.sSorter = new Sorter(myQueue, noString);

        exeGenerator = Executors.newFixedThreadPool(noGenerator);
        exeSorter = Executors.newFixedThreadPool(noSorter);
    }


	public void run() {

        long starttime = System.nanoTime();

        exeGenerator.submit(randomSGenerator);
        exeSorter.submit(sSorter);
        exeGenerator.shutdown();
        exeSorter.shutdown();

        try {
            exeSorter.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (Exception e) {
            //TODO: handle exception
        }

        long endtime = System.nanoTime();
        System.out.print("Threaded Execution Completed in (nanoseconds) ");
        System.out.println(endtime - starttime);
        
	}
 
}