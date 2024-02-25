//IFT2015_TP2
//Jiadong Jin 20150692
package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(30);
        list.addLast(20);
        list.addLast(40);
        list.addLast(50);
        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        list.removeFirst();
        System.out.println("First after removeFirst: " + list.first());
        list.removeLast();
        System.out.println("Last after removeLast: " + list.last());
        list.addLast(80);
        list.addLast(90);
        list.removeValue(80);
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
    }
}
