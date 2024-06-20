package org.example.problems;

public class Stack2 {
    private int[] array;
    private int stackTop;
    final Object lock;

    public Stack2(int size) {
        array = new int[size];
        stackTop = -1;
        lock= new Object();
    }
    public boolean push(int value) {
        
        synchronized (lock){
            if (isFull()) {
                return false;
            }
            ++stackTop;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            array[stackTop] = value;
            return true;
        }
        
    }

    public int pop(){

        synchronized (lock){
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int value = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            --stackTop;
            return value;
        }
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }
}
