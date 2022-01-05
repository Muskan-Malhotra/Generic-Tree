/**
 * 07 LoLineWise METHOD 1
 */

// ############################ ALGO ###############################
/**
 * Remove the root from Main Queue
 * Print root
 * Add Root Children in the Child Queue
 * When MQ is empty make CQ as MQ
 * Create new CQ
 */

import java.util.*;

 class LoLineWise1{

  public static class Node{
    int  data;
    ArrayList<Node> children = new ArrayList<>();
  }

 
  public static Node construct(int[] arr){
    //function for constructing the genric tree

    Stack<Node> st = new Stack<>();  
    int i = 0;
    Node root=null;

    while(i < arr.length){
      //loop for traversing the array 
      
      if(arr[i] == -1){
        st.pop();                    
      }
      else{
        Node n = new Node();        
        n.data = arr[i];            

        // System.out.println(n);
        if(st.size() == 0){
          root = n;
          // System.out.println(root);
        }
        else{
          st.peek().children.add(n);
        }
        st.push(n);
      }
      i++;
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

  // ############################# LEVEL ORDER LINE WISE 1 #############################################//

  public static void LOLW1(Node root){
    Queue<Node> Mq = new ArrayDeque<>();
    Queue<Node> Cq = new ArrayDeque<>();

    Mq.add(root);

    while(Mq.size()>0){

      //remove 
      Node rem = Mq.remove();

      // print
      System.out.print(rem.data+"/");

      //add children to cq
      for(int i=0;i<rem.children.size();i++){
         Node remchild = rem.children.get(i);
         Cq.add(remchild);
      }

      if(Mq.size() == 0){
        Mq = Cq;                    //Make CQ as MQ
        Cq = new ArrayDeque<>();    //Create new CQ
        System.out.println();
      }
      
    
    }

    }


  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    LOLW1(root);
  }
  
}

/* abstract
*
10/
20/30/40/
50/60/70/80/90/100/
110/120/

 */