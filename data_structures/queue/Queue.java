public class Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int length;
    private int size;

    class Node<G> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public Queue(int size) {
        this.size = size;
        this.length = 0;
    }

    public boolean enqueue(T value) {
        // if queue is full
        if (this.length == this.size) {
            throw new Error("Queue is full! Size limit reached of " + this.size);
        }

        Node<T> newNode = new Node<>(value);
        // if empty
        if (this.length == 0) {
            this.front = newNode;
            this.back = newNode;
        } else {
            Node<T> prevEndNode = this.back;
            this.back = newNode;
            prevEndNode.next = this.back;
        }

        this.length++;
        return true;
    }

    public T dequeue() {
        // if empty
        if (this.length == 0) {
            throw new Error("Queue is Empty!");
        }

        Node<T> removedNode = this.front;
        // if single element
        if (this.length == 1) {
            this.front = null;
            this.back = null;
        } else {
            this.front = removedNode.next;
        }

        removedNode.next = null;
        this.length--;
        return removedNode.data;
    }

    public boolean isEmpty() {
        return (this.length == 0) ? true : false;
    }

    public String toString() {
        String str = "{ ";
        Node<T> currentNode = this.front;
        while (currentNode != null) {
            str += (currentNode.next == null) ? currentNode.data : currentNode.data + " -> ";
            currentNode = currentNode.next;
        }

        str += " }";
        return str;
    }

    public static void main(String args[]) {
        Queue<String> q = new Queue<>(5);
        q.enqueue("Sam");
        q.enqueue("Justin");
        q.enqueue("Elon");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q);
    }
}
