package org.example.producerConsumer;

import java.util.LinkedList;

public class ProducerConsumerSample {

    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 5;

    // Function called by producer thread
    public void produce() throws InterruptedException
    {
        int value = 0;
        while (true) {
            synchronized (list)
            {
                while(list.size() == capacity){
                    list.wait();
                }
                    //do something

                System.out.println("Producer produced-"
                        + value);

                list.add(value++);
                list.notifyAll();
                //do something
                Thread.sleep(1000);
       ;
            }
        }
    }

    public void consume() throws InterruptedException
    {
        while (true) {
            synchronized (list)
            {
                while(list.size() == 0){
                    list.wait();
                }

                int val = list.removeFirst();
                list.notifyAll();

                System.out.println("Consumer consumed-"
                        + val);

                //do Something
                Thread.sleep(1000);

            }
        }
    }
}
