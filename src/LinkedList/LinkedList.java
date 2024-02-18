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

    public int first() {
        if (isEmpty()) return -1;
        return head.value;
    }

    public int last() {
        if (isEmpty()) return -1;
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

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

    public void removeFirst() {
        if (isEmpty()) return;
        head = head.next;
        size--;
    }

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

    // Fonctions personnalisées
    public void removeValue(int value) {
        Node tmp = head;
        Node prev = null;
        while (tmp != null) {
            if (tmp.value == value) {
                if (tmp == head) {
                    head = tmp.next;
                } else {
                    if (prev != null) {
                        prev.next = tmp.next;
                    }
                }
                size--;
            } else {
                prev = tmp;
            }
            tmp = tmp.next;
        }
    }

    public int returnNLast(int nLast) {
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
        return maxValue(head);
    }

    private int maxValue(Node node) {
        if (node.next == null) {
            return node.value;
        } else {
            return Math.max(node.value, maxValue(node.next));
        }
    }

    public void insertionSort() {
        if (head == null || head.next == null) {
            return;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.value >= current.value) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.value < current.value) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;
    }

    public void addInOrder(int value) {
        Node newNode = new Node(value);
        if (isEmpty() || head.value >= newNode.value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.value < newNode.value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
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
