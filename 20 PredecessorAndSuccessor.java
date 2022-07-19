import java.io.*;
import java.util.*;

/**
 * Time Complexity:
O(n)

The time complexity of the above solution is O(n) as we are traversing all the nodes of the tree.

Space Complexity:
O(1)

The space complexity of the above solution is O(1) as we have not used any extra memory. But, if we consider the recursion space then it is O(logn) as the max height of the recursion stack will be equal to height of the tree i.e. O(logn).
 * 
 */


///////// NEW GROUP TAVEL AND CHANGE ////////////////////////////
class PredecessorAndSuccessor {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  static Node predecessor;
  static Node successor;
  static int state = 0;
  public static void predecessorAndSuccessor(Node node, int data) {
    // write your code here
    if(node.data == data){
        state++;
    }
    
    if(state < 1){
        predecessor = node;    
    }
    
    else if(state == 1){
        state++;
    }
    else if(state == 2){
        successor = node;
        state++;
    }
    
    for(Node child : node.children){
        predecessorAndSuccessor(child,data);
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    predecessor = null;
    successor = null;
    predecessorAndSuccessor(root, data);
    if(predecessor == null){
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if(successor == null){
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
    System.out.println(state);
  }

}