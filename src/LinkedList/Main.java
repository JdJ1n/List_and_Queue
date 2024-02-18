package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        list.removeFirst();
        System.out.println("First after removeFirst: " + list.first());
        list.removeLast();
        System.out.println("Last after removeLast: " + list.last());
        list.addLast(40);
        list.addLast(50);
        list.removeValue(40);
        System.out.println("Is 40 in the list? " + list.checkInList(40));
        System.out.println("3rd last element: " + list.returnNLast(3));
        System.out.println("Max value in the list: " + list.maxValue());

        // Afficher la liste avant le tri
        System.out.println("Liste avant le tri :");
        list.printList();

        // Trier la liste
        list.insertionSort();

        // Afficher la liste après le tri
        System.out.println("Liste après le tri :");
        list.printList();

        // Ajouter un élément dans l'ordre
        list.addInOrder(25);

        // Afficher la liste après l'ajout
        System.out.println("Liste après l'ajout de 25 :");
        list.printList();

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

        int[][] grid = {
                {1, 2, 0},
                {0, 0, 1}
        };
        SurvivalGame game = new SurvivalGame(grid);
        int iterations = game.play();
        System.out.println("Nombre d'itérations nécessaires pour infecter toutes les personnes non immunisées : " + iterations);
    }
}
