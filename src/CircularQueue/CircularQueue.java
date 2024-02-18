package CircularQueue;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue() {
        queue = new int[100];
        front = 0;
        rear = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[(front + size - 1) % queue.length];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    // Fonctions personnalisées
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = queue[(front + i) % queue.length];
            queue[(front + i) % queue.length] = queue[(front + size - 1 - i) % queue.length];
            queue[(front + size - 1 - i) % queue.length] = temp;
        }
    }

    public boolean checkInQueue(int value) {
        for (int i = 0; i < size; i++) {
            if (queue[(front + i) % queue.length] == value) {
                return true;
            }
        }
        return false;
    }

    public void remove(int value) {
        int shift = 0;
        for (int i = 0; i < size; i++) {
            if (queue[(front + i) % queue.length] == value && shift == 0) {
                shift++;
            }
            if (shift > 0) {
                queue[(front + i) % queue.length] = queue[(front + i + shift) % queue.length];
            }
        }
        if (shift > 0) {
            rear = (rear - 1 + queue.length) % queue.length;
            size--;
        }
    }
}
