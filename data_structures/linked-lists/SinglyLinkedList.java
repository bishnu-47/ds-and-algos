public class SinglyLinkedList {
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

    public SinglyLinkedList(int value) {
        if (this.length == 0)
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

    public void insert(int idx, int val) {
        if (idx < 0 || idx > this.length)
            throw new IndexOutOfBoundsException("Index " + idx + " is out of Bound!");
        if (this.length == 0) {
            prepend(val);
        } else if (idx == this.length - 1) {
            append(val);
        } else {
            Node newNode = new Node(val);
            Node currentNode = this.Head;
            int idxCounter = 0;

            while (currentNode != null) {
                if (idxCounter == idx - 1) {
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

    public int remove(int index) {
        // check for invalid index
        if (index < 0 || index > this.length)
            throw new IndexOutOfBoundsException("Index " + index + " is out of Bound!");

        // if length is 0
        if (this.length == 0)
            throw new Error("Can't remove from empty list");

        // if user wants to remove 1st node
        if (index == 0) {
            return removeHead();
        }

        // if user wants to remove last node
        if (index == this.length - 1) {
            return removeTail();
        }

        // remove from specific index
        Node currentNode = this.Head;
        int currentIndex = 0;
        while (currentIndex != index - 1) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        Node removedNode = currentNode.next;
        currentNode.next = removedNode.next;

        removedNode.next = null;
        return removedNode.data;
    }

    public int removeHead() {
        Node removedNode = this.Head;
        // if list length is only 1
        if (this.length == 1) {
            this.Head = null;
            this.Tail = null;
        } else {
            this.Head = removedNode.next;
        }
        removedNode.next = null;
        return removedNode.data;
    }

    public int removeTail() {
        Node removedNode = this.Tail;
        // if length is only 1
        if (this.length == 1) {
            this.Head = null;
            this.Tail = null;
        } else {
            Node currentNode = this.Head;
            // traverse before the tail
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            this.Tail = currentNode;
            currentNode.next = null;
        }

        return removedNode.data;
    }

    public String reverse() {
        Node prevNode = null;
        Node currentNode = this.Head;
        Node nextNode = null;
        this.Tail = this.Head;

        while (currentNode != null) {
            nextNode = currentNode.next; // save nextNode
            currentNode.next = prevNode; // reverse the currentNode reference to prevNode

            // advance prevNode and currentNode
            prevNode = currentNode;
            currentNode = nextNode;
        }

        this.Head = prevNode;
        return this.toString();
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
        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(5);
        list.insert(2, 3);
        list.insert(3, 4);
        list.prepend(0);
        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.reverse());
    }
}
