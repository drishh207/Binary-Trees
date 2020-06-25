
package binary_search_tree;


public class tree {
    treenode root;
    public void insert(int value)
    {
        if(root == null)
            root = new treenode(value);
        else
            root.insert(value);
    }
    
    public void in_order()
    {
        if(root != null)
            root.in_order();
    }
    
    public void pre_order()
    {
        if(root != null)
            root.pre_order();
    }
    
    public void post_order()
    {
        if(root != null)
            root.post_order();
    }
    
    public int gets(int value)
    {
        if(root == null)
            return -1;
        else
            return root.gets(value);
    }
    
    public int min()
    {
        if(root == null)
            return Integer.MIN_VALUE;
        else
            return root.min();
    }
    
    public int max()
    {
        if(root == null)
            return Integer.MAX_VALUE;
        else
            return root.max();
    }
    
    public void delete(int value) 
    {
        root = delete(root, value);
    }

    private treenode delete(treenode subtreeRoot, int value) 
    {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) 
        {
            subtreeRoot.setLeftchild(delete(subtreeRoot.getLeftchild(), value));
        }
        
        else if (value > subtreeRoot.getData()) 
        {
            subtreeRoot.setRightchild(delete(subtreeRoot.getRightchild(), value));
        }
        
        else 
        {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftchild() == null) 
            {
                return subtreeRoot.getRightchild();
            }
            else if (subtreeRoot.getRightchild() == null) 
            {
                return subtreeRoot.getLeftchild();
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightchild().min());

            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightchild(delete(subtreeRoot.getRightchild(), subtreeRoot.getData()));
        }

        return subtreeRoot;
    }
   
    
    public static void main(String args[])
    {
        tree t = new tree();
        t.insert(25);
        t.insert(20);
        t.insert(30);
        t.insert(7);
        t.insert(23);
        t.insert(5);
        t.insert(10);
        t.insert(27);
        t.insert(45);
        t.insert(47);
        
        System.out.print("Inorder Traversal: ");
        t.in_order();
        System.out.println("");
        
        System.out.print("Preorder Traversal: ");
        t.pre_order();
        System.out.println("");
        
        System.out.print("Postorder Traversal: ");
        t.post_order();
        System.out.println("");
        
        System.out.println(t.gets(23));
        System.out.println(t.gets(0));
        
        System.out.println("Min value:" + t.min());
        System.out.println("Max value:" + t.max());
        
        t.delete(20);
        System.out.print("Inorder Traversal: ");
        t.in_order();
        System.out.println("");
    }
}
