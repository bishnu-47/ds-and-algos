public class DoublyLinkedList {
    private Node Head;
    private Node Tail;
    private int length = 0;

    public class Node {
        Node next;
        Node prev;
        int data;

        Node(int value) {
            this.data = value;
        }
    }

    public DoublyLinkedList(int value) {
        if (this.length == 0)
            append(value);
    }

    public void append(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            prepend(val);
        } else {
            Node currentTail = this.Tail;
            newNode.prev = currentTail;
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
            tempNode.prev = newNode;
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
            Node currentNode;
            int idxCounter;
            boolean traverseForward = false;

            if (idx < (this.length / 2)) {
                currentNode = this.Head;
                idxCounter = 0;
                traverseForward = true;
            } else {
                currentNode = this.Tail;
                idxCounter = this.length - 1;
            }

            while (currentNode != null) {
                // if idx less than half of total length, then traverse forward
                if (traverseForward) {
                    if (idxCounter == idx - 1) {
                        Node tempNode = currentNode.next;
                        currentNode.next = newNode;
                        newNode.next = tempNode;

                        newNode.prev = currentNode;
                        tempNode.prev = newNode;
                        break;
                    }
                    currentNode = currentNode.next;
                    idxCounter++;
                } else { // else traverse backwards from the tail
                    if (idxCounter - 1 == idx) {
                        Node tempNode = currentNode.prev;
                        tempNode.next = newNode;
                        newNode.next = currentNode;

                        currentNode.prev = newNode;
                        newNode.prev = tempNode;
                        break;
                    }
                    currentNode = currentNode.prev;
                    idxCounter--;
                }
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
        Node removedNode = this.Head;
        Node currentNode;
        int idxCounter;
        boolean traverseForward = false;

        if (index < (this.length / 2)) {
            currentNode = this.Head;
            idxCounter = 0;
            traverseForward = true;
        } else {
            currentNode = this.Tail;
            idxCounter = this.length - 1;
        }

        while (currentNode != null) {
            // if idx less than half of total length, then traverse forward
            if (traverseForward) {
                if (idxCounter == index - 1) {
                    removedNode = currentNode;
                    Node nextNode = removedNode.next;
                    Node prevNode = removedNode.prev;

                    // create new ties
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    break;
                }
                currentNode = currentNode.next;
                idxCounter++;
            } else { // else traverse backwards from the tail
                if (idxCounter - 1 == index) {
                    removedNode = currentNode;
                    Node prevNode = currentNode.prev;
                    Node nextNode = currentNode.next;

                    // create new ties
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    break;
                }
                currentNode = currentNode.prev;
                idxCounter--;
            }
        }
        // break old ties
        removedNode.next = null;
        removedNode.prev = null;

        return removedNode.data;
    }

    public int removeHead() {
        Node removedNode = this.Head;
        // if list length is only 1
        if (this.length == 1) {
            this.Head = null;
            this.Tail = null;
        } else {
            Node newHead = removedNode.next;
            newHead.prev = null;
            this.Head = newHead;
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
            Node newTail = removedNode.prev;
            newTail.next = null;
            removedNode.prev = null;
            this.Tail = newTail;
        }

        return removedNode.data;
    }

    public String toString() {
        String str = "[";
        Node currentNode = this.Head;

        while (currentNode != null) {
            str += (currentNode.next != null) ? currentNode.data + " <-> " : currentNode.data;
            currentNode = currentNode.next;
        }

        str += "]";
        return str;
    }

    public static void main(String... args) {
        DoublyLinkedList list = new DoublyLinkedList(1);
        list.append(2);
        list.append(5);
        list.insert(2, 3);
        list.insert(3, 4);
        list.prepend(0);
        System.out.println(list.remove(4));
        System.out.println(list);
    }
}
