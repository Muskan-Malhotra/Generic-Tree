import java.util.*;

class construction{

  //Node class constructor for data and children of Nodes

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
        st.pop();                    //if the array element is -1 pop the element at peek in stack.
      }
      else{
        Node n = new Node();        //creating the new Node to link to the parent
        n.data = arr[i];            //adding data to the new node
        
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

  public static void main(String[] args){
    // Scanner scn = new Scanner(System.in);

    
    //input array
    int[] ar = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

    Node root = construct(ar);
    //function calling for construction

    //displaying the generic tree
    display(root);

  }
}