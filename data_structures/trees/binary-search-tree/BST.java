import java.util.Queue;

public class BST {

    class Node {
        int data;
        Node left , right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;

    public BST() {
        this.root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node currentNode = this.root;

        while (true) {
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (data > currentNode.data) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                break;
            }
        }
    }

    public boolean search(int data) {
        Node currentNode = this.root;

        while (true) {
            if (currentNode == null) {
                return false;
            }

            if (data == currentNode.data) {
                return true;
            } else if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
    }

    public int findHeight(){
        return findHeightRec(this.root);
    }

    private int findHeightRec(Node root){
        if(root == null)
            return -1;

        int left = findHeightRec(root.left);
        int right = findHeightRec(root.right);

        return Math.max(left, right) + 1;
    }

    public int findMin(){
        if(this.root == null)
            return -1;

        Node currentNode = this.root;
        while(currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode.data;
    }

    public int findMax(){
        if(this.root == null)
            return -1;

        Node currentNode = this.root;
        while(currentNode.right != null)
            currentNode = currentNode.right;

        return currentNode.data;
    }

    public String toString(){
        String str= "";

        Node currentNode = this.root;
        // traverse the left sub tree
        // return to root
        // traverse the right sub tree
        // while(currentNode != null){
        //     str+=currentNode.data;
        //     if(currentNode.left != null){

        //     }
        // }

        return str;
    }

    public static void main(String... args) {
        BST tree = new BST();

        tree.insert(15);
        tree.insert(7);
        tree.insert(25);
        tree.insert(34);
        tree.insert(8);
        tree.insert(9);

        System.out.println(tree.search(25));
        System.out.println(tree.findMin());
        System.out.println(tree.findMax());
        System.out.println(tree.findHeight());
    }
}

