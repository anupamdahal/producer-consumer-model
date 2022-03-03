import java.util.Random;

public class Generator implements Runnable{
  
  private BufferQueue myQueue; 
  private RandomString randomStr = new RandomString();
  
  private Random random = new Random();
  private int noString;

  public Generator(BufferQueue myQueue, int noString){
    this.noString = noString;
    this.myQueue = myQueue;
  }

  public void run(){
    int count = 0;
    String word;
    while( count <= noString){
      word = randomStr.getRandomString(1 + random.nextInt(19));
      myQueue.push(word);
      count += 1;
    }
  }

}