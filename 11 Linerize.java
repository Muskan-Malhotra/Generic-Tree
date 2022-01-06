/**
 * 11 Linearize a GT
 */

// ############################ ALGO ###############################
/**
 * Work in preoder
 * Looping in for reverse order traversal
 * Then calling on each child
 * Imp point: Preorder and careful about AL removal 
 */

import java.util.*;

class Linearize {
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

  public static void linearGT(Node root){
    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      
      linearGT(child); 

    }

    
    for(int i=root.children.size()-1;i>=0;i--){
      Node lc = root.children.get(i);
      Node slc = root.children.get(i-1);
      Node slct = slc.children.get(slc.children.size()-1);
      slct.children.add(lc);

    }




    

  }

  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    linearGT(root);
    // display(root);
    
  }
}