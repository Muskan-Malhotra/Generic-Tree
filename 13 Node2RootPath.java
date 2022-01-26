/**
 * 13 NODE TO ROOT PATH
 */

// ############################ ALGO ###############################
/**
 * Similar to find.java
 * if data found on current node --
 *  ----------Create new arraylist and add data
 * Travel through the node
 * create nodetochildpath arraylist(not new one)
 * get n2cp through recurssion
 * Once the al size > 0 that means found the data
 * -----------add the ancestor of the found child as n2rp in n2cp
 * -----------return n2cp
 * else data not found
 * -----------return empty arraylist  == return new ArrayList<>();
 * 
 * Time: O(n); where n is the number of nodes in tree (Have travelled all nodes just once)
 * Space: O(1)
 */

import java.util.*;

 class Node2RootPath{

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

  public static ArrayList<Integer> nodeToRootPath(Node root, int data){
    if(root.data == data){
      //create new arraylist
      ArrayList<Integer> al = new ArrayList<>();
      al.add(data);   //add the data or node.data so found
      return al;
    }

    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      ArrayList<Integer> n2cp = nodeToRootPath(child, data);

      if(n2cp.size()>0){
        //found the element
        n2cp.add(root.data);      //add the root in n2cp once 120 i.e data found add 80 root of 120
        return n2cp;
      }
    }

    return new ArrayList<>();   //returning empty arraylist
  }

  public static void main(String[] args) {

    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    int data = 120;
    ArrayList<Integer> ans = nodeToRootPath(root,data);
    System.out.println(ans);
  }

 
}
