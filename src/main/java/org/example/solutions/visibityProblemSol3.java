package org.example.solutions;

import java.util.concurrent.atomic.AtomicBoolean;

public class visibityProblemSol3 {
    private static AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 0;
                while (running.get()) {
                    count++;
                }
                System.out.println("Worker thread stopped. Count: " + count);
            }
        });

        worker.start();

        try {
            // Sleep for a while to let the worker thread run
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the worker thread
        running.set(false);
        System.out.println("Main thread set running to false");

    }
}
