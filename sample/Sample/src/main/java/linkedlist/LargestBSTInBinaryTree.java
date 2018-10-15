package linkedlist;

public class LargestBSTInBinaryTree {
  /*  public int largestBST(Node root){
        MinMax m = largest(root);
        return m.size;
    }*/

  /*  private MinMax largest(Node root){*/
     /*   //if root is null return min as Integer.MAX and max as Integer.MIN
        if(root == null){
            return new MinMax();
        }

        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax =largest(root.right);
        MinMax m = new MinMax();
        if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.data || rightMinMax.min <= root.data)){
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
        m.min = root.left != null ? leftMinMax.min : root.data;
        m.max = root.right != null ? rightMinMax.max : root.data;
        return m;
    }

    public static void main(String args[]){
        LargestBSTInBinaryTree lbi = new LargestBSTInBinaryTree();
        ConstructTreeFromInOrderPreOrder ctf = new ConstructTreeFromInOrderPreOrder();
        //this is just to create a binary tree.
        int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
        int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
        Node root = ctf.createTree(inorder, preorder);
        int largestBSTSize = lbi.largestBST(root);
        System.out.println("Size of largest BST  is " + largestBSTSize);
        assert largestBSTSize == 8;
    }
}
class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;

    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = true;
        size = 0;
    }*/
}
