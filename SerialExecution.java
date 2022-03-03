import java.util.Random;
import java.util.Arrays;

public class SerialExecution implements Runnable {

    private RandomString randomStr = new RandomString();
    private Random random = new Random();
    private int noString;

    public SerialExecution(int noString){
        this.noString = noString;
    }

    public void run(){
         
        long starttime = System.nanoTime();
        
        String word;
        char tempArray[];
        // System.out.println("Running Serial Execution");
        for (int i = 0; i<noString; i++){
            word = randomStr.getRandomString(1 + random.nextInt(19));
            tempArray = word.toCharArray();
            Arrays.sort(tempArray);
        }
        
        long endtime = System.nanoTime();
        System.out.print("Seiral Execution completed in (nanoseconds) ");
        System.out.println((endtime - starttime));

    }

}