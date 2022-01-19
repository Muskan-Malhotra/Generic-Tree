/**
 * 07 LoLineWise METHOD 2  -- COUNT
 */

// ############################ ALGO ###############################
/**
 * Remove the root from Main Queue
 * Print root
 * Add Root Children in the Child Queue
 * Do the above process till count is 0
 * Time: O(n); Space: O(n)
 */

import java.util.*;

 class LoLineWise2{

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

  // ############################# LEVEL ORDER LINE WISE 2 #############################################//
  public static void LOLW2(Node root){

    ArrayDeque<Node> q = new ArrayDeque<>();

    q.add(root);

    while(q.size()!=0){
      int count = q.size();
      for(int i=0;i<count;i++){
        //remove
        Node rem = q.remove();

        //print
        System.out.print(rem.data+" ");

        //add children
        for(int k=0;k<rem.children.size();k++){
          Node child = rem.children.get(k);
          q.add(child);
        }
      }
      System.out.println();
    }
  }
  

  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    LOLW2(root);
  }
  
}

/* abstract
*
10/
20/30/40/
50/60/70/80/90/100/
110/120/

 */