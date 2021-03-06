package com.maartenmusic;

public class CircularQueue {
    private int head;
    private int tail;
    private final int[] array;

    public CircularQueue(int k) {
        array = new int[k];
        reset();
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
            tail = 0;
        }
        array[tail] = value;
        tail++;
        if (tail == array.length) {
            tail = 0;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        if (head == array.length) {
            head = 0;
        }
        if (head == tail) {
            reset();
        }
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : array[head];
    }

    public int Rear() {
        int rear = tail - 1;
        if (rear < 0) {
            rear = array.length - 1;
        }
        return isEmpty() ? -1 : array[rear];
    }

    public boolean isEmpty() {
        return (head == -1);
    }

    public boolean isFull() {
        return (!isEmpty() && head == tail);
    }

    private void reset() {
        head = -1;
        tail = -1;
    }
}