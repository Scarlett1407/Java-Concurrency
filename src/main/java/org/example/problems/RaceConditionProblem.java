package org.example.problems;

public class RaceConditionProblem {

    public static void main(String[] args) {
        Stack2 stack2 = new Stack2(5);
        Thread thread1 = new Thread(()->{
            int counter = 0;
            while (++counter < 10) {
                System.out.println("Pushed: " + stack2.push(100));
            }
        }, "Pusher");
        Thread thread2 = new Thread(()->{
            int counter = 0;
            while (counter < 10) {
                System.out.println("Popped: " + stack2.pop());
                counter++;
            }
        }, "Popper");

        thread1.start();
        thread2.start();

    }


}
