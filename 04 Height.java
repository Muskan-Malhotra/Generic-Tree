import java.util.*;

class Height{

  public static class Node{
    int data;
    ArrayList<Node> children= new ArrayList<>();
  }


  public static Node construction(int[] ar){
    Node root = null;
    Stack<Node> st = new Stack<>();
    int i = 0;
    while(i<ar.length){
      if(ar[i] == -1){
        st.pop();
      }
      else
      {
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
      i++;
      
    }

    return root;
  }

  public static void display(Node root){

    System.out.print(root.data + "->");
    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      System.out.print(child.data + ",");
    }
    System.out.print(".");
    System.out.println();
    
    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      display(child);
    }
  }

  // --------------------meee --------------------------------
  // static int maxhgt = -1;
  // public static int height(Node root){
  //   int chgt = 0;
  //   for(int i=0;i<root.children.size();i++){
  //     Node child = root.children.get(i);
  //     chgt = height(child);  //child height
  //     // System.out.print("c "+chgt+" ");
  //   }
  //   // System.out.println();
  //   if(chgt > maxhgt){
  //     maxhgt = chgt;
      
  //     // System.out.print("m " +maxhgt+" ");
  //   }

  //   return chgt + 1;
    
  // }  
  ////////////////////////////returned the node number[me]///////////////////////////////////

  // ==============================Mam=====================================

  public static int height(Node root){
    int mhgt = -1;   //if edges are to be calculated (check for 10)
    for(int i=0;i<root.children.size();i++){
      Node child = root.children.get(i);
      int chgt = height(child);  //child height

      if(chgt > mhgt){
        mhgt = chgt;
      }
    }
    
    return mhgt+1;
    
  }




  public static void main(String[] args){
    
    // int ar[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,-1,90,-1,-1,40,100,-1,-1,-1};
    //my code at only 10 returns 1
    // int ar[] = {10,20,50, -1, 60,-1,-1,30,70,-1,-1,40,80,90, -1, -1, -1, -1};
    int ar[] = {10,20,-1,30,40,60,-1,50,-1,-1,-1,70,80,-1,-1,-1};

    Node root = construction(ar);

    // display(root);

    int ans = height(root);
    System.out.println(ans);
  }
}