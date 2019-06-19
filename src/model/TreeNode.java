package model;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 二叉树的一个节点
 * @time 2019-06-19 14:38
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        if (left != null && right != null) {
            return "TreeNode{" +
                    "val=" + val + "\t" +
                    "left=" + left.toString() + "\t" +
                    "right=" + right.toString() +
                    '}';
        }
        if (right == null && left != null) {
            return "TreeNode{" +
                    "val=" + val + "\t" +
                    "left=" + left.toString() +
                    '}';
        }
        if (left == null && right != null) {
            return "TreeNode{" +
                    "val=" + val + "\t" +
                    "right=" + right.toString() +
                    '}';
        }

        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
