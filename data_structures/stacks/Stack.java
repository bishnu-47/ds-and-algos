public class Stack<T> {
    private Node<T> top;
    private Node<T> bottom;
    private int length = 0;
    private int stackLimit = 0;

    class Node<G> {
        G data;
        Node<G> next;

        public Node(G data) {
            this.data = data;
        }
    }

    public Stack(int limit) {
        this.stackLimit = limit;
    }

    public boolean push(T val) {
        // if stack is empty
        Node<T> newNode = new Node<>(val);

        if (this.top == null) {
            this.top = newNode;
            this.bottom = newNode;
        } else if (this.length == this.stackLimit) { // if stack is full
            throw new Error("StackOverflow: Stack limit reached: " + this.stackLimit);
        } else { // if not empty
            Node<T> prevTop = this.top;
            this.top = newNode;
            this.top.next = prevTop;
        }

        this.length++;
        return true;
    }

    public T pop() {
        // if empty
        if (this.top == null) {
            throw new Error("StackUnderflow: There is nothing in the Stack!");
        }
        if (this.length == 1) { // if only 1 node
            Node<T> removedNode = this.top;
            this.top = null;
            this.bottom = null;

            return removedNode.data;
        } else {
            Node<T> removedNode = this.top;
            this.top = removedNode.next;

            removedNode.next = null;
            return removedNode.data;
        }
    }

    public T peek() {
        return this.top.data;
    }

    public boolean isEmpty() {
        return (this.length == 0) ? true : false;
    }

    public String toString() {
        Node<T> currentNode = this.top;
        String str = "---TOP---\n";

        while (currentNode != null) {
            str += " " + currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        str += "---BOTTOM---";
        return str;
    }

    public static void main(String args[]) {
        Stack<String> myStack = new Stack<>(5);
        myStack.push("facebook");
        myStack.push("youtube");
        myStack.push("udemy");
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack);
    }
}
