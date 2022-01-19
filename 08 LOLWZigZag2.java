/**
 * 08 Level Order Line Wise Zig Zag COUNT 
 */

// ############################ ALGO ###############################
/**
 * Remove the root from Main Queue
 * Print root
 * Add Root Children in the Child Queue ---> L to R for odd && R to L for even
 * With the help of count
 * Time: O(n); Space: O(n);
 */

import java.util.*;

 class LOLWZigZig2{

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

  public static void LOLWZZ2(Node root){

    ArrayDeque<Node> q = new ArrayDeque<>();
    q.add(root);

    
    int lvl = 0;

    while(q.size()!=0){
      int count = q.size();
      ArrayList<Integer> al = new ArrayList<>();
      for(int k=0;k<count;k++){
        //remove
        Node rem = q.remove();

        //add to arrraylist
        al.add(rem.data);

        ////add children
        for(int i=0;i<rem.children.size();i++){
          Node child = rem.children.get(i);
          q.add(child);
        }

      }

      if(lvl%2 == 0){
        for(int i=0;i<al.size();i++){
          System.out.print(al.get(i)+" ");
        }
        System.out.println();
      }
      else{
        for(int i=al.size()-1;i>=0;i--){
          System.out.print(al.get(i)+" ");
        }
        System.out.println();
      }
      lvl++;
    }

  }

  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    LOLWZZ2(root);
  }

 
}
