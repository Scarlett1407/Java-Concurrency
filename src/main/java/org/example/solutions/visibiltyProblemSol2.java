package org.example.solutions;

public class visibiltyProblemSol2 {
    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 0;
                while (isRunning()) {
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
        setRunning(false);
        System.out.println("Main thread set running to false");

    }

    private static synchronized boolean isRunning() {
        return running;
    }

    private static synchronized void setRunning(boolean value) {
        running = value;
    }
}
