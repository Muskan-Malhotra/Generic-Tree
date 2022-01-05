/**
 * 09 Mirror
 */

// ############################ ALGO ###############################
/**
 * 
 */
import java.util.*;

class Mirror {
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

  public static void mirror(Node root){

    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      mirror(child);
    }

    //reversing the array list
    int lo = 0;
    int hi = root.children.size()-1;

    while(lo<hi){
      Node left = root.children.get(lo);
      Node right = root.children.get(hi);

      root.children.set(lo,right);
      root.children.set(hi,left);

      lo++;
      hi--;
    }

// ########################### DIRECT METHOD FOR REVERSE ################################################
    //direct reversing of the arraylist method
    // Collections.reverse(root.children);
    

  }

  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    mirror(root);
    display(root);
    
  }
}