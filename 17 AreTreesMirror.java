/**
 * 16 Are Trees Mirror in Shape
 */

// ############################ ALGO ###############################
/**
 * Similar to Are trees similar just traverse the other tree in reverse order
 * Traverse through the child nodes of both the trees.
 * Once captured check if both the child has equal number of children or not
 * I.e the size of the child nodes are same or not.
 * If same return true as the ans of recursion.
 * If the ans false form any of the child node return false as the ans of recursion
 * 
 * Time: O(n); where n is the number of nodes in tree (Have travelled all nodes just once)
 * Space: O(1)
 */

import java.util.*;

 class AreTreesMirror{

  public static class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static Node construct(int[] ar){
    Node root = null;

    Stack<Node> st = new Stack<>();

    for(int i=0;i<ar.length;i++){

      if(ar[i] == -1){
        st.pop();
      }
      else{
        Node n = new Node();
          n.data = ar[i];
        if(st.size()==0){
          root = n;
        }
        else{
          st.peek().children.add(n);
        }
        st.push(n);
      }
      
    }
    return root;
  }

  public static void display(Node root){
   
    System.out.print(root.data + "->");

    //to print root
    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      System.out.print(child.data+",");
    }
    System.out.print(".");
    System.out.println();

    //to print root nodes
    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      display(child);
    }
  }

  public static int size(Node n){
    int s=0;

    for(int i=0;i<n.children.size();i++){
      Node child = n.children.get(i);
      s += size(child);
      
    }
    s+=1;
    return s;

  }
  
  public static boolean Mirror(Node n1, Node n2){
      
    for(int i=n1.children.size()-1,j=0;i>=0 && j<n2.children.size()-1;i--,j++){
      // System.out.println(n1.data+"size"+n1.children.size());
      // System.out.println(n2.data+"size"+n2.children.size());

      Node child1 = n1.children.get(i);
      Node child2 = n2.children.get(j);

      boolean ans = Mirror(child1,child2);

      if(ans == false){
        return false;
      }
    }

    if(n1.children.size() == n2.children.size()){
      return true;
    }

    return false;

  }

  

  public static void main(String[] args) {

    int[] ar1 = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
    int[] ar2 = {100,200,-1,300,500,-1,600,-1,-1,400,-1,-1};
    

    Node root1 = construct(ar1);
    Node root2 = construct(ar2);
    
    // display(root1);
    // display(root2);
    boolean ans = Mirror(root1,root2);
    System.out.println(ans);
    
  }

 
}


/**
 * import java.io.*;
import java.util.*;

public class Main {
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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static boolean areMirror(Node n1, Node n2) {
    // write your code here
    if(n1.children.size() != n2.children.size()){
        return false;
    }
    for(int i=0;i<n1.children.size();i++){
        int j = n1.children.size()-1-i;
        
        Node child1 = n1.children.get(i);
        Node child2 = n2.children.get(j);
        
        if(areMirror(child1,child2) == false){
            return false;
        }
    }
    
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[] arr1 = new int[n1];
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      arr1[i] = Integer.parseInt(values1[i]);
    }
    Node root1 = construct(arr1);

    int n2 = Integer.parseInt(br.readLine());
    int[] arr2 = new int[n2];
    String[] values2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++) {
      arr2[i] = Integer.parseInt(values2[i]);
    }
    Node root2 = construct(arr2);

    boolean mirror = areMirror(root1, root2);
    System.out.println(mirror);
  }

}
 */
