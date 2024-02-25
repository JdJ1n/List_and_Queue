//IFT2015_TP2
//Jiadong Jin 20150692
package LinkedList;

public class LinkedList {
    private Node head;
    private int size;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer first() {
        if (isEmpty()) return null;
        return head.value;
    }

    public Integer last() {
        if (isEmpty()) return null;
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    // Ajoute un nœud au début de la liste
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Ajoute un nœud à la fin de la liste
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        size++;
    }

    // Supprime le premier nœud de la liste
    public void removeFirst() {
        if (isEmpty()) return;
        head = head.next;
        size--;
    }

    // Supprime le dernier nœud de la liste
    public void removeLast() {
        if (isEmpty()) return;
        if (head.next == null) {
            head = null;
        } else {
            Node tmp = head;
            while (tmp.next.next != null) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
        size--;
    }

    public void removeValue(int value) {
        head = removeValueRecursive(head, value);
    }

    // Fonction récursive pour supprimer les nœuds avec une certaine valeur
    private Node removeValueRecursive(Node node, int value) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            size--;
            return removeValueRecursive(node.next, value);
        } else {
            if (node.next != null) {
                node.next = removeValueRecursive(node.next, value);
            }
            return node;
        }
    }

    // Retourne le n-ième élément à partir de la fin
    public int returnNLast(int nLast) {
        if (nLast < 0 || nLast >= size) {
            System.out.println("Le " + nLast + "-ième dernier élément n'existe pas.");
            return -1;
        }
        Node tmp = head;
        int index = size - nLast;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public boolean checkInList(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.value == value) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int maxValue() {
        if (isEmpty()) return -1;
        return maxValue(head);
    }

    // Fonction récursive pour trouver la valeur maximale
    private int maxValue(Node node) {
        if (node.next == null) {
            return node.value;
        } else {
            return Math.max(node.value, maxValue(node.next));
        }
    }


    // Trie la liste en utilisant le tri par insertion
    public void insertionSort() {
        if (head == null || head.next == null) {
            return;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            Node temp = sorted;

            // Insérer le nœud actuel dans la partie triée
            if (temp == null || sorted.value >= current.value) {
                current.next = sorted;
                sorted = current;
            } else {
                // Trouver la bonne position dans la partie triée
                while (temp.next != null && temp.next.value < current.value) {
                    temp = temp.next;
                }
                // Insérer le nœud courant
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;
    }

    // Ajoute un élément dans un liste ordonnée
    public void addInOrder(int value) {
        head = addInOrderRecursive(head, value);
        size++;
    }

    // Fonction récursive pour ajouter un élément dans un liste ordonnée
    private Node addInOrderRecursive(Node node, int value) {
        if (node == null || value <= node.value) {
            Node newNode = new Node(value);
            newNode.next = node;
            return newNode;
        } else {
            node.next = addInOrderRecursive(node.next, value);
            return node;
        }
    }


    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
