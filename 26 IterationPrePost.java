import java.io.*;
import java.util.*;

/**
 * Time Complexity:
O(n)

The time complexity for the function is linear as tree traversal is involved which is linear in terms of time complexity.

Space Complexity:
O(logn)

The space complexity for the function is proportional to the height of the stack.
 */

class IteratingPrePost{
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
  
  static class Pair{
      Node node;
      int state;
      
      Pair(Node node,int state){
          this.node = node;
          this.state = state;
      }
  }

  public static void IterativePreandPostOrder(Node node) {
    // write your code here
    
    String Pre = "";
    String Post = "";
    
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(node,-1));
    
    while(st.size()>0){
        
        Pair top = st.peek();
        
        if(top.state == -1){
            
            Pre += top.node.data+" ";
            top.state++;
            
        }
        else if(top.state == top.node.children.size()){
            Post += top.node.data+" ";
            st.pop();
        }
        else{  //when state lies between 0 to n.c.size()-1
            
            Pair cp = new Pair(top.node.children.get(top.state),-1);
            st.push(cp);
            top.state++;
        }
    }
    
    System.out.println(Pre);
    System.out.print(Post);
    
    return;
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
    IterativePreandPostOrder(root);
  }

}