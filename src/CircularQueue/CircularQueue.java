package CircularQueue;


public class CircularQueue {
    private final int[] queue; // Le tableau pour stocker les éléments de la file d'attente
    private int front; // L'indice du premier élément de la file d'attente
    private int rear; // L'indice où le prochain élément sera inséré
    private int size; // Le nombre d'éléments dans la file d'attente

    // Constructeur pour initialiser la file d'attente.
    public CircularQueue() {
        queue = new int[100];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Retourne la taille de la file d'attente.
    public int size() {
        return size;
    }

    // Vérifie si la file d'attente est vide.
    public boolean isEmpty() {
        return size == 0;
    }

    // Ajoute un élément à la fin de la file d'attente.
    public void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("La file d'attente est pleine, taille actuelle: " + size);
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    // Supprime et retourne l'élément en tête de la file d'attente.
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La file d'attente est vide, taille actuelle: " + size);
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    // Retourne l'élément en tête de la file d'attente sans le supprimer.
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("La file d'attente est vide, taille actuelle: " + size);
        }
        return queue[front];
    }

    // Retourne le dernier élément de la file d'attente sans le supprimer.
    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("La file d'attente est vide, taille actuelle: " + size);
        }
        return queue[(front + size - 1) % queue.length];
    }

    // Imprime tous les éléments de la file d'attente.
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    // Inverse l'ordre des éléments de la file d'attente.
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = queue[(front + i) % queue.length];
            queue[(front + i) % queue.length] = queue[(front + size - 1 - i) % queue.length];
            queue[(front + size - 1 - i) % queue.length] = temp;
        }
    }

    // Vérifie si une valeur est présente dans la file d'attente.
    public boolean checkInQueue(int value) {
        for (int i = 0; i < size; i++) {
            if (queue[(front + i) % queue.length] == value) {
                return true;
            }
        }
        return false;
    }

    // Supprime la première occurrence d'une valeur dans la file d'attente.
    public void remove(int value) {
        if (isEmpty()) {
            return;
        }
        int frontElement = dequeue();
        if (frontElement != value) {
            remove(value);
            enqueue(frontElement);
        } else {
            remove(value);
        }
    }
}
