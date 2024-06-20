package org.example.problems;


public class VisibiltyProblem {

    private static boolean running = true;

public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            long count = 0;
            while (isRunning()) {
                count++;
            }
            System.out.println("Worker thread stopped. Count: " + count);
        });

        worker.start();

        try {
            // Sleep for a while to let the worker thread run
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the worker thread
        setRunning(false);
        System.out.println("Main thread set running to false");

    }

    private static boolean isRunning() {
        return running;
    }

    private static void setRunning(boolean value) {
        running = value;
    }

}

