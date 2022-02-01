/**
 * 16 Are Trees Similar
 */

// ############################ ALGO ###############################
/**
 * First generate the arraylist with both the data so given
 * Traverse the arraylist from the end
 * From AL1 and AL2 find the divergence point
 * The most common point of divergence is the LCA
 * 
 * Time: O(n); where n is the number of nodes in tree (Have travelled all nodes just once)
 * Space: O(1)
 */

import java.util.*;

 class AreTrees{

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
  
  public static boolean ATS(Node n1, Node n2){

    //  System.out.println(n1.data+"size"+n1.children.size());
    //  System.out.println(n2.data+"size"+n2.children.size());

    int sizen1 = size(n1);
    int sizen2 = size(n2);

    if(sizen1 == 0 && sizen2 == 0){
      return true;
    }
    else if(sizen1 == 0 && sizen2 > 0){
      return false;
    }
    else if(sizen1 > 0 && sizen2 == 0){
      return false;
    }

    
      
    for(int i=0,j=0;i<n1.children.size() && j<n2.children.size();i++,j++){
      // System.out.println(n1.data+"size"+n1.children.size());
      // System.out.println(n2.data+"size"+n2.children.size());

      Node child1 = n1.children.get(i);
      Node child2 = n2.children.get(j);

      boolean ans = ATS(child1,child2);

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

    int[] ar1 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    int[] ar2 = {1,2,5,-1,6,-1,-1,3,7,-1,8,11,-1,12,-1,-1,9,-1,-1,4,10,-1,-1,-1};
    int[] sizearr = {10,20,-1,30,-1,40,-1,-1};

    Node root1 = construct(ar1);
    Node root2 = construct(ar2);
    Node root3 = construct(sizearr);
    // display(root1);
    // display(root2);
    boolean ans = ATS(root1,root2);
    System.out.println(ans);
    System.out.println(size(root3));
  }

 
}
