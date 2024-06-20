package org.example.problems;

public class Stack {
    private int[] array;
    private int stackTop;

    public Stack(int size) {
        array = new int[size];
        stackTop = -1;
    }
    public boolean push(int value) {
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

    public int pop(){
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

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }
}
