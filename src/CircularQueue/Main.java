package CircularQueue;

public class Main {
    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Queue after enqueuing 10, 20, 30, 40, 50:");
        queue.print();
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Queue after dequeuing:");
        queue.print();
        System.out.println("Front: " + queue.front());
        System.out.println("Rear: " + queue.rear());
        System.out.println("Is 30 in the queue? " + queue.checkInQueue(30));
        queue.remove(30);
        System.out.println("Queue after removing 30:");
        queue.print();
        queue.reverse();
        System.out.println("Queue after reversing:");
        queue.print();
    }
}

