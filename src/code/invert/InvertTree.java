package code.invert;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-26 17:11
 */
public class InvertTree {

    public static void main(String[] args) {
        int num = 1;
        InvertTree invertTree = new InvertTree();
        TreeNode root = new TreeNode(num);
        root = invertTree.initTreeNode(root, 3);
        root = invertTree.invertTreeByQueue(root);
        System.out.println(root.toString());
    }

    //按照正常递归操作对二叉树进行反转
    private TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invert(root.getLeft());
        invert(root.getRight());
        return root;
    }

    //不实用递归的方式，使用广度优先遍历的方式对二叉树进行遍历到一个数组中（List），遍历的同时对二叉树进行反转
    private TreeNode invertTree(TreeNode root) {
        int crs = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (crs < nodes.size()) {
            TreeNode node = nodes.get(crs);
            if (node != null) {
                swap(node);
                nodes.add(node.getLeft());
                nodes.add(node.getRight());
            }
            crs++;
        }
        return root;
    }

    //不实用递归方式，使用广度优先遍历的方式对二叉树进行遍历到一个队列中（queue），遍历的同时对二叉树进行反转
    private TreeNode invertTreeByQueue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node == null) {
                continue;
            }
            swap(node);
            if (node.getLeft() != null) {
                queue.push(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.push(node.getRight());
            }
        }
        return root;
    }

    //对二叉树的左右字节点进行反转
    private static void swap(TreeNode node) {
        TreeNode temp = node.getRight();
        node.setRight(node.getLeft());
        node.setLeft(temp);
    }

    //对二叉树进行初始化
    private TreeNode initTreeNode(TreeNode root, int steps) {
        steps = steps - 1;
        return createTreeNode(root, steps);
    }
    private TreeNode createTreeNode(TreeNode root, int size) {
        double pow = Math.pow(2, size);
        int num = root.getVal();
        if (num >= pow) {
            return root;
        }
        TreeNode left = new TreeNode(2 * num);
        TreeNode right = new TreeNode(2 * num + 1);
        left = createTreeNode(left, size);
        right = createTreeNode(right, size);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }
}
