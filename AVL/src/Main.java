public class Main {
    public static void main(String[] args){
        AvlTree tree=new AvlTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(10);
        tree.add(16);
        tree.add(17);
        tree.add(9);
        tree.add(8);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.inOrder(tree.root);
        System.out.println();
        tree.preOrder(tree.root);
    }
}
