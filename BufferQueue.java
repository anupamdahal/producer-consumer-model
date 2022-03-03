import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class BufferQueue{
    private Queue<String> queue = new LinkedList<String>();
    public final Lock lock = new ReentrantLock();
    public Condition notFullCondition = lock.newCondition();
    public Condition notEmptyCondition = lock.newCondition();
    private int maxSize;

    public BufferQueue(int maxSize){
        this.maxSize = maxSize;
    }

    public void push(String word){
        lock.lock();

        try {
            while (queue.size() == maxSize){
                notFullCondition.await();
            }
            queue.add(word);
            notEmptyCondition.signalAll();
            assert(queue.size() >= maxSize); 
        } catch (Exception e) {
            System.out.println(e);
        }

        lock.unlock();

    }

    public String pop(){
        lock.lock();
        String rString = null;

        try {
            while (queue.size() == 0){
                notEmptyCondition.await();
            }
            rString = queue.remove();
            notFullCondition.signalAll();
        } catch (Exception e) {
            System.out.println(e);
        }

        lock.unlock();
        return rString;
    }
}