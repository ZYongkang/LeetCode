package code;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
 *       通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
 *       考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
 *       （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
 *       我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。 
 *       如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。
 *       如果不能，则返回列表 [-1]。
 * @time 2019-06-19 14:41
 */
public class FlipMatchVoyage {

    private List<Integer> resList;
    private Integer index = 0;
    private int[] voyage;

    public static void main(String[] args) {
        FlipMatchVoyage flipMatchVoyage = new FlipMatchVoyage();
        int num = 1;
        TreeNode root = new TreeNode(num);
        root = flipMatchVoyage.initTreeNode(root, 3);
        flipMatchVoyage.voyage = new int[]{1, 3, 7, 6, 2, 4, 5};
        List<Integer> nodeList = flipMatchVoyage.flipMatchVoyage(root, flipMatchVoyage.voyage);
        StringBuilder stringBuilder = new StringBuilder();
        if (nodeList != null && !nodeList.isEmpty()) {
            stringBuilder.append("[");
            for (int i = 0; i < nodeList.size(); i++) {
                if (i == 0) {
                    stringBuilder.append(nodeList.get(i));
                } else {
                    stringBuilder.append(",").append(nodeList.get(i));
                }
            }
            stringBuilder.append("]");
        }
        System.out.println(stringBuilder.toString());
    }

    private List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.index = 0;
        this.voyage = voyage;
        this.resList = new ArrayList<>();
        if (root == null || voyage.length < 2) {
            resList.add(-1);
            return resList;
        }
        dfs(root);
        if (!resList.isEmpty() && resList.get(0) == -1) {
            resList.clear();
            resList.add(-1);
        }
        return resList;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.getVal() != voyage[index++]) {
                resList.clear();
                resList.add(-1);
                return;
            }
            if (index < voyage.length && root.getLeft() != null &&
                    root.getLeft().getVal() != voyage[index]) {
                resList.add(root.getVal());
                dfs(root.getRight());
                dfs(root.getLeft());
            } else {
                dfs(root.getLeft());
                dfs(root.getRight());
            }
        }
    }


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
