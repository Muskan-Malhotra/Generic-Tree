import java.io.*;
import java.util.*;

/**
 * Time Complexity: O(n)
The time complexity for the function is linear as tree traversal is involved which is linear in terms of time complexity.

Space Complexity: O(h)
The space complexity for the function is proportional to the height of the generic tree due to the recursion stack.
 */

class DiameterGT {
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
  

  static int diam = 0;

  public static int dia(Node node){
      
      int dch = -1;   //deepest child height
      int sdch = -1; // second deepest child height 
      
      
      for(Node child:node.children){
          int ch = dia(child);    //child height
        //   level += cl;
          
          if(ch>dch){
              sdch = dch;
              dch = ch;
          }
          if(ch>sdch){
              sdch = ch;
          }
      }
      int candidate = dch + sdch +2;   //for every node calculating child height in post order
      if((candidate)>diam){
          diam = candidate;
      }
      dch+= 1;
      
      
      return dch;
      
      
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    dia(root);
    System.out.println(diam);
  }

}