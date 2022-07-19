import java.io.*;
import java.util.*;

/**
 * Time Complexity:
We are visiting each node exactly once, hence the total time complexity will be O(n) where n = number of nodes in the tree.

Space Complexity:
We are just taking two integer variables mSum and mSumNode to find the maximum subtree sum. Hence, we are taking O(1) auxiliary space.
However, again, due to recursion, the recursion call stack will take up O(d) space where d = maximum depth of the tree.
 */

class MaxSTSumandNode {
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
  static int treeMax = Integer.MIN_VALUE;
  static int data = 0;
  public static int nodeMaxST(Node node){
      
      int sum = 0;
      
      for(Node child:node.children){
        
        sum += nodeMaxST(child);
          
      }
      
      sum += node.data;
      
      if(sum>treeMax){
          treeMax = sum;
          data = node.data;
      }
      
      
      return sum ;
      
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
    
    nodeMaxST(root);
    // System.out.println(ans);
    System.out.print(data + "@"+treeMax);
  }

}