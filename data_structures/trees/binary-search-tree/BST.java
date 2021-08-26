import java.util.Queue;
import java.util.LinkedList;

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
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (data > currentNode.data) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
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

    // height finding
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

    // finding min and max
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

    // traversal algos:
    // BFS- breadth first search
    public void levelOrderTraversal(){
      if(this.root == null)
        return;

      Queue<Node> q =  new LinkedList<>();
      Node currentNode = this.root;
      q.add(currentNode);

      while(q.peek() != null){
        currentNode = q.peek();

        System.out.print(currentNode.data+" ");
        // if left Node add
        if(currentNode.left != null)
          q.add(currentNode.left);
        // if right Node add
        if(currentNode.right != null)
          q.add(currentNode.right);
        // remove current Node
        q.remove();
      }
    }

    // DFS: depth first search
    public void preOrderTraversal() { preOrderRec(this.root); }
    private void preOrderRec(Node root){
      if(root == null) return;

      System.out.print(root.data+" ");
      preOrderRec(root.left);
      preOrderRec(root.right);
    }

    public void inOrderTraversal() { inOrderRec(this.root); }
    private void inOrderRec(Node root){
      if(root == null) return;

      preOrderRec(root.left);
      System.out.print(root.data+" ");
      preOrderRec(root.right);
    }

    public void postOrderTraversal() { postOrderRec(this.root); }
    private void postOrderRec(Node root){
      if(root == null) return;

      preOrderRec(root.left);
      preOrderRec(root.right);
      System.out.print(root.data+" ");
    }

    // check if given binary tree is BST
    public static boolean isBinarySearchTree(Node root){
      return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBstUtil(Node root, int minVal, int maxVal){
      if(root == null) return true;

      if(root.data > minVal
        && root.data < maxVal
        && isBstUtil(root.left, minVal, root.data)
        && isBstUtil(root.right, root.data, maxVal))
        return true;
      else
        return false;
    }

    public static void main(String... args) {
        BST tree = new BST();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.println(tree.search(25));
        System.out.println("Min: "+tree.findMin());
        System.out.println("Max: "+tree.findMax());
        System.out.println("Height: "+tree.findHeight());
        System.out.println("Level Order Traversal:");
        tree.levelOrderTraversal();
        System.out.println("\nPreorder Traversal:");
        tree.preOrderTraversal();
        System.out.println("\nInorder Traversal:");
        tree.inOrderTraversal();
        System.out.println("\nPostorder Traversal:");
        tree.postOrderTraversal();
        System.out.println("\nis BST? -> " + isBinarySearchTree(tree.root));
    }
}
