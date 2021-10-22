import java.util.*;

class PrePostOrder{

  public static class Node{
    
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static Node construction(int[] ar){
    Stack<Node> st = new Stack<>();
    Node root = null;

    for(int i=0;i<ar.length;i++){
      
      if(ar[i] == -1){
        st.pop();
      }
      else{
        Node n = new Node();
        n.data = ar[i];

        if(st.size() == 0){
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

  public static void PrePost(Node root){
    System.out.println("Node Pre " + root.data);

    for(int i=0;i<root.children.size();i++){

      //pre order
      Node child = root.children.get(i);
      System.out.println("Edge Pre " + root.data + "--" + child.data);

      //call the recurssion [in]
      PrePost(child);

      //post order
      System.out.println("Edge Post " + root.data + "--" + child.data);
    }

    System.out.println("Node Post "+ root.data);
  }
  
  
  public static void main(String[] args){
    int ar[] = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};

    Node root = construction(ar);

    PrePost(root);
    
  }
}