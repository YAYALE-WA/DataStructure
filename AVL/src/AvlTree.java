public class AvlTree {
    AvlNode root;
    int size;

    void AvlTree(){
        root=null;
        size=0;
    }

    void setRoot(AvlNode root){
        this.root=root;
    }

    int getHeight(AvlNode node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    AvlNode searchNode(int val){
        return getNode(root,val);
    }

    AvlNode getNode(AvlNode node,int val){
        if(node==null){
            return null;
        }
        else if(node.val<val){
            return getNode(node.right,val);
        }
        else if(node.val>val){
            return getNode(node.left,val);
        }
        else{
            return node;
        }
    }

    int getBalanceFactor(AvlNode node){
        if(node==null){
            return 0;
        }
        else{
            return getHeight(node.left)-getHeight(node.right);
        }
    }

    AvlNode rRotate(AvlNode n1){
        AvlNode n2=n1.left;
        n1.left=n2.right;
        n2.right=n1;
        n1.height=Math.max(getHeight(n1.left),getHeight(n1.right))+1;
        n2.height=Math.max(getHeight(n2.left),getHeight(n2.right))+1;
        return n2;
    }
    AvlNode lRotate(AvlNode n1){
        AvlNode n2=n1.right;
        n1.right=n2.left;
        n2.left=n1;
        n1.height=Math.max(getHeight(n1.left),getHeight(n1.right))+1;
        n2.height=Math.max(getHeight(n2.left),getHeight(n2.right))+1;
        return n2;
    }
    AvlNode lrRotate(AvlNode n1){
        n1.left=lRotate(n1.left);
        return rRotate(n1);
    }
    AvlNode rlRotate(AvlNode n1){
        n1.right=rRotate(n1.right);
        return lRotate(n1);
    }

    AvlNode add(AvlNode n,int val){
        if(n==null){
            n=new AvlNode();
            n.val=val;
            size+=1;
            return n;
        }
        else{
            if(val>n.val){
                n.right=add(n.right,val);
                if (getHeight(n.right) - getHeight(n.left) == 2) {
                    if(val>n.right.val){
                        n = lRotate(n);
                    }
                    else{
                        n=rlRotate(n);
                    }
                }
            }
            else if(val<n.val) {
                n.left=add(n.left, val);
                if(getHeight(n.left)-getHeight(n.right)==2) {
                    if(val<n.left.val){
                        n = rRotate(n);
                    }
                    else{
                        n=lrRotate(n);
                    }
                }
            }
        }
        n.height=Math.max(getHeight(n.left),getHeight(n.right))+1;
        return n;
    }

    void add(int val){
        root=add(root,val);
    }
    void inOrder(AvlNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print("   "+root.val);
            inOrder(root.right);
        }
    }
    void preOrder(AvlNode root){
        if(root!=null){
            System.out.print("   "+root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
