/**
 * 06 LevelOrder
 */
// ############################ ALGO ###############################
/**
 * Remove the root from Queue
 * Print root
 * Add Root Children in the Queue
 * Time: O(n); Space: O(n)
 */
import java.util.*;

 class LevelOrder {

  public static class Node{
    int  data;
    ArrayList<Node> children = new ArrayList<>();
  }

 
  public static Node construct(int[] arr){
    //function for constructing the genric tree

    Stack<Node> st = new Stack<>();  //stack for distinguishing the root and its children
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
        
        //special case
        //stack empty

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

  // ############################# LEVEL ORDER #############################################//

  public static void LevelOrder01(Node root){
    Queue<Node> q =  new ArrayDeque<>();

    
    //add node in queue
    q.add(root);

    
    ///ALGO

    while(q.size()>0){
      //remove front node

      Node rem = q.remove();  //the front ele of queue is removed and got in rem(removed element)

      //print the node
      System.out.print(rem.data+" ");

      //add the children of removed node
      for(int i=0;i<rem.children.size();i++){
        Node remChild = rem.children.get(i);
        q.add(remChild);
      }
    }

    System.out.println(". ");

  }
  public static void main(String[] args) {
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    // display(root);
    LevelOrder01(root);
  }
  
}