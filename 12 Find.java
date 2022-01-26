/**
 * 12 Find
 */

// ############################ ALGO ###############################
/**
 * If the data found on the node standing then return true
 * Travel all the nodes if found true return from there don't travel ahead
 * Time: O(n); where n is the number of nodes in tree (Have travelled all nodes just once)
 * Space: O(1)
 */

import java.util.*;

 class Find{

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

  public static boolean find(Node root, int data){
    if(root.data == data){
      return true;
    }

    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      boolean fic = find(child,data);             //fic == found in child

      if(fic == true){
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {

    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    int data = 130;
    boolean ans = find(root,data);
    System.out.println(ans);
  }

 
}
