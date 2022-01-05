/**
 * 08 Level Order Line Wise Zig Zag
 */

// ############################ ALGO ###############################
/**
 * Remove the root from Main Queue
 * Print root
 * Add Root Children in the Child Queue ---> L to R for odd && R to L for even
 * When MQ is empty make MQ as CQ
 * Create new CQ
 */

import java.util.*;

 class LOLWZigZig{

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

  public static void LOLWZZ(Node root){

    int lvl = 1;

    Stack<Node> Ms = new Stack<>();
    Stack<Node> Cs = new Stack<>();

    Ms.push(root);

    while(Ms.size()>0){

      //remove
      Node rem = Ms.pop();

      //print
      System.out.print(rem.data+" ");
      
      //Add children
      if(lvl%2==1){

        // if lvl odd then add children L2R so popped R2L
        for(int i=0;i<rem.children.size();i++){
          Node remChild = rem.children.get(i);
          Cs.push(remChild);
        }
      }
      else{
        // if lvl even then add children R2L so popped L2R
        for(int i=rem.children.size()-1;i>=0;i--){  //error is this line size()-1 ✔ only size() X
          Node remChild = rem.children.get(i);
          Cs.push(remChild);
        }
      }
      
      if(Ms.size() == 0){
        Ms = Cs;
        Cs = new Stack<>();
        lvl++;
        System.out.println();
      }
      
    }

  }

  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    LOLWZZ(root);
  }

 
}
