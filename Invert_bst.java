import java.util.*;
public class Invert_bst{

    static class Tree
    {
        int val;
        Tree left;
        Tree right;
        
        Tree()
        {}
        
        Tree(int val)
        {
            this.val=val;
        }
    }
     
      Tree root;
        
       Invert_bst()
       {
          root=null;
       }
       
       void insert(int val)
       {
           root=ins(root,val);
       }
       
       Tree ins (Tree root,int val)
       {
           Tree node=new Tree(val);
           
           if(root==null)
           {
               root=node;
               return root;
           }
           
           if(val<root.val)
           {
               root.left=ins(root.left,val);
           }
           
           if(val>root.val)
           {
               root.right=ins(root.right,val);
           }
           
           return root;
       }
       
       void print (Tree root)
       {
           Tree node=root;
          if(node!=null)
          {
               print(node.left);
               System.out.print(node.val+" ");
               print(node.right);
          }
       }
       
    public Tree invertTree(Tree root)
    {
       if (root == null) {
        return null;
    }
    
    Tree left = invertTree(root.left);
    Tree right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
    
     }
     public static void main(String []args){
         
         Invert_bst tree=new Invert_bst();
         tree.insert(4);
         tree.insert(2);
         tree.insert(7);
         tree.insert(1);
         tree.insert(3);
         tree.insert(6);
         tree.insert(9);
         System.out.println("binary tree before invert");
         tree.print(tree.root);
         Tree node=tree.invertTree(tree.root);
         System.out.println();
         System.out.println("binary tree after invert");
         tree.print(node);
       
     }
}
