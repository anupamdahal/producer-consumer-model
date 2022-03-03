import java.util.Arrays;

public class Sorter implements Runnable{

  private BufferQueue myQueue;

  private int noString;

  public Sorter(BufferQueue myQueue, int noString){
    this.myQueue = myQueue;
    this.noString = noString;
  }

  public void run(){

    String word;
    char[] tempArray;
    int itr = noString;
    
    while(itr > 0 ){
      word = myQueue.pop();
      tempArray = word.toCharArray();
      Arrays.sort(tempArray);
      itr--;
    }

  }

}
