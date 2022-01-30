/**
 * 14 Lowest Common Ancestor
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

 class Distnc{

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
  public static int LCA(Node root, int d1, int d2){
    ArrayList<Integer> n2rp1 = Node2RP(root, d1);
    ArrayList<Integer> n2rp2 = Node2RP(root,d2);

    int i = n2rp1.size()-1;
    int j = n2rp2.size()-1;

    while(i>=0 && j>=0 && n2rp1.get(i) == n2rp2.get(j)){
      i--;
      j--;

      //keep on decreasing i and j until n2rp1 == n2rp2
    }
    
    return n2rp1.get(i+1);
  }

  public static int DBGN(Node root, int d1, int d2){
    ArrayList<Integer> n2rp1 = Node2RP(root, d1);
    ArrayList<Integer> n2rp2 = Node2RP(root,d2);

    int lca = LCA(root,d1,d2);
    // int i = n2rp1.size()-1;
    // int j = n2rp2.size()-2;
    int i = 0;
    int j = 0;
    int count = 0;

    while(n2rp1.get(i)!=lca){
      count++;
      i++;
    }
    while(n2rp2.get(j)!=lca){
      count++;
      j++;
    }
    // System.out.println(n2rp1);

    return count;


  }

  public static ArrayList<Integer> Node2RP (Node root, int data){
    if(root.data == data){
      //create new arraylist
      ArrayList<Integer> al = new ArrayList<>();
      al.add(data);   //add the data or node.data so found
      return al;
    }

    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      ArrayList<Integer> n2cp = Node2RP(child, data);

      if(n2cp.size()>0){
        //found the element
        n2cp.add(root.data);      //add the root in n2cp once 120 i.e data found add 80 the root of 120
        return n2cp;
      }
    }

    return new ArrayList<>();   //returning empty arraylist
  }

  public static void main(String[] args) {

    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    int d1 = 110;
    int d2 = 100;
    int ans = DBGN(root,d1,d2);
    System.out.println(ans);
  }

 
}
