public class LinkedList {
    private Node Head;
    private Node Tail;
    private int length = 0;

    public class Node {
        Node next;
        int data;

        Node(int value) {
            this.data = value;
        }
    }

    public LinkedList(int value) {
        append(value);
    }

    public void append(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            prepend(val);
        } else {
            Node currentTail = this.Tail;
            currentTail.next = newNode;

            this.Tail = newNode;
        }
        this.length++;
    }

    public void prepend(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            newNode.next = null;

            this.Head = newNode;
            this.Tail = newNode;
        } else {
            Node tempNode = this.Head;
            this.Head = newNode;
            this.Head.next = tempNode;
        }
        this.length++;
    }

    public void insert(int val, int idx) {
        if (idx < 0 || idx > this.length)
            throw new IndexOutOfBoundsException("Index " + idx + " is out of Bound!");
        if (this.length == 0) {
            prepend(val);
        } else if (idx == this.length) {
            append(val);
        } else {
            Node newNode = new Node(val);
            Node currentNode = this.Head;
            int idxCounter = 0;

            while (currentNode != null) {
                if (idxCounter == idx) {
                    Node tempNode = currentNode.next;
                    currentNode.next = newNode;
                    newNode.next = tempNode;
                    break;
                }
                currentNode = currentNode.next;
                idxCounter++;
            }
            this.length++;
        }
    }

    public String toString() {
        String str = "[";
        Node currentNode = this.Head;

        while (currentNode != null) {
            str += (currentNode.next != null) ? currentNode.data + " -> " : currentNode.data;
            currentNode = currentNode.next;
        }

        str += "]";
        return str;
    }

    public static void main(String... args) {
        LinkedList list = new LinkedList(3);
        list.append(4);
        list.append(5);
        list.append(7);
        list.insert(6, 2);
        list.insert(8, 5);
        list.prepend(2);
        System.out.println(list);
    }
}
