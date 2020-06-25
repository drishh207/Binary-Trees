package binary_search_tree;

public class treenode 
{
    private int data;
    private treenode leftchild;
    private treenode rightchild;

    public treenode(int data) 
    {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    

    public treenode getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(treenode leftchild) {
        this.leftchild = leftchild;
    }

    public treenode getRightchild() {
        return rightchild;
    }

    public void setRightchild(treenode rightchild) {
        this.rightchild = rightchild;
    }
    
    
    
    
    public void insert(int value)
    {
        //donot allow any duplicate value
        if(value == data)
            return;
         
        if(value < data)
        {
            if(leftchild == null)
                leftchild = new treenode(value);
            else
                leftchild.insert(value);
        }
        
        else
        {
            if(rightchild == null)
                rightchild = new treenode(value);
            else
                rightchild.insert(value);
        }
    }
    
    //in-order recursive
    public void in_order()
    {
        if(leftchild != null)
            leftchild.in_order();
        System.out.print(data + ", ");
        if(rightchild != null)
            rightchild.in_order();
    }
    
    //pre-order recursive
    public void pre_order()
    {
        System.out.print(data + ", ");
        if(leftchild != null)
            leftchild.pre_order();
        if(rightchild != null)
            rightchild.pre_order();
    }
    
    //post-order recursive
    public void post_order()
    {
        if(leftchild != null)
            leftchild.post_order();
        if(rightchild != null)
            rightchild.post_order();
        System.out.print(data + ", ");
    }
    
    public int gets(int value)
    {
        if(data == value)
            return this.getData();
        
        if(value < data){
            if(leftchild != null)
                return leftchild.gets(value);
        }
        
        else
        {
            if(rightchild != null)
                return rightchild.gets(value);
        }
        
        return -1;
    }
    
    public int min()
    {
        if(leftchild != null)
            return leftchild.min();
        else
            return this.getData();
    }
    
    public int max()
    {
        if(rightchild != null)
            return rightchild.max();
        else
            return this.getData();
    }
}
