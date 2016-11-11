package threads.interthread_communication;

// An incorrect implementation of a producer and consumer.
class Queue {
    int n;
    
    synchronized int get() {
        System.out.println("Got: " + n);
        return n;
    }
    
    synchronized void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}

class Producer implements Runnable {
    Queue queue;

    public Producer(Queue queue) {
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

class Consumer implements Runnable {
    
    Queue queue;

    public Consumer(Queue queue) {
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

public class ProducerAndConsumer {
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);
        
        System.out.println("Press Control-C to stop.");
    }
    
}
