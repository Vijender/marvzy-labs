import java.util.ArrayList;

//Node Structure
class TNode {
    int data;
    TNode left;
    TNode right;

    TNode(int x) {
        data = x;
        left = right = null;
    }
}

public class TreeTraversal {

    public static void inOrder(TNode node, ArrayList<Integer> target) {

        if (node == null) { return; }

        inOrder(node.left, target);
        target.add(node.data);
        inOrder(node.right, target);
    }


    public static void preOrder(TNode node, ArrayList<Integer> target) {

        if (node == null) { return; }

        target.add(node.data);
        preOrder(node.left, target);
        preOrder(node.right, target);
    }


    public static void postOrder(TNode node, ArrayList<Integer> target) {

        if (node == null) { return; }

        postOrder(node.left, target);
        postOrder(node.right, target);
        target.add(node.data);

    }

    public static void main(String... args) {
        // Create binary tree
        //       1
        //      /  \
        //    2     3
        //   / \     \
        //  4   5     6
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.right = new TNode(6);

        ArrayList<Integer> target = new ArrayList<>();
        inOrder(root, target);

        for (int i = 0; i < target.size(); i++) {
            System.out.print(target.get(i) + " ");
        }
        System.out.println();

        ArrayList<Integer> target1 = new ArrayList<>();

        preOrder(root, target1);
        for (int i = 0; i < target1.size(); i++) {
            System.out.print(target1.get(i) + " ");
        }
        System.out.println();
        ArrayList<Integer> target2 = new ArrayList<>();
        postOrder(root, target2);
        for (int i = 0; i < target2.size(); i++) {
            System.out.print(target2.get(i) + " ");
        }

    }
}
