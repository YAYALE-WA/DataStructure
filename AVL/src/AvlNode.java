public class AvlNode {
    int val;
    int height=1;
    AvlNode left=null;
    AvlNode right=null;


    int getValue(){
        return val;
    }
    int getHeight(){
        return height;
    }
    AvlNode getLeft() {
        return left;
    }
    AvlNode getRight(){
        return right;
    }
    void AvlNode(int val,AvlNode l,AvlNode r){
        this.val=val;
        this.height=1;
        this.left=l;
        this.right=r;
    }
}
