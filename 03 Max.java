import java.util.*;

public class Max{


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

  
  public static int maximum(Node root){
    int m = 0;

    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      int cm = maximum(child);  //child max   return statemnt as welll /// 50/60 ka post is imp
      // m = Math.max(child.data, cm);    //taken for the overview of mistake so made
      m = Math.max(m, cm);   //ladai tb hogi jab 30 ka ek child 60 bacha hoga tab loop mein aungi and then ladai b/w 30 and 50 and win = 50

    }
    System.out.println("root.data: "+root.data);
    System.out.println("m: "+ m);
    m = Math.max(root.data, m);
    // System.out.println(m);

   
      return m;
   

  }
  public static void main(String[] args){
    int ar[] = {10,20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};

    Node root = construction(ar);

    int ans = maximum(root);
    System.out.println(ans);
  }
}