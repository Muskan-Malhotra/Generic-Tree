import java.util.*;

class Size{


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

  // static int count = 0;
  
  public static int size(Node root){
    int s = 1;

    //demo
    // for(int i=0;i<root.children.size();i++){
    //   count++;
    // }

    // for(int i=0;i<root.children.size();i++){
    //   Node child = root.children.get(i);
    //   size(child);
    // }

    // ma'am
    // for(int i=0;i<root.children.size();i++){
    //     Node child = root.children.get(i);
    //     int size = size(child);
    //     s += size;
    //   }

      //mee
      for(Node child: root.children){
        int cs = size(child);  //child size
        s += cs;

        //just return s if s+=cs is not there kyuki s is the returning value of the func size() so only s values be printed always
      }
      return s;
    // return count+1;

  }
  public static void main(String[] args){
    int ar[] = {10,20,50,-1,-1,-1};

    Node root = construction(ar);

    int ans = size(root);
    System.out.println(ans);
  }
}