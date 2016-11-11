package threads.interthread_communication;

/**
 * A correct implementation of producer and consumer.
 * 
 */
class Queue2 {
    int n;
    boolean valueSet = false;
    
    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }
    
    synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer2 implements Runnable {
    
    Queue2 queue;

    public Producer2(Queue2 queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        
        while(true) {
            queue.put(i++);
        }
    }
}

class Consumer2 implements Runnable {
    Queue2 queue;

    public Consumer2(Queue2 queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while(true) {
            queue.get();
        }
    }
}

public class ProducerAndConsumer2 {
    public static void main(String[] args) {
        Queue2 queue = new Queue2();
        new Producer2(queue);
        new Consumer2(queue);
        
        System.out.println("Press Control-c to stop");
    }
    
}
