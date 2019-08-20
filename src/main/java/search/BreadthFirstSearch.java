package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BreadthFirstSearch
 * @Description 广度优先算法
 * @Author: lijiao73
 * @Date: 2019/8/16 15:52
 * @Version 1.0
 */
public class BreadthFirstSearch {
    private static Queue<TreeNode> queue = new LinkedList<TreeNode>();
    private static List<Integer> list = new ArrayList<Integer>();
    /**
     * 建立一棵树
     *      1
     *   2    3
     * 4  5  6  7
     * 广度优先的顺序应该是：1 2 3 4 5 6 7
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        breadthFirstSearch(node1);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }

    private static void breadthFirstSearch(TreeNode root) {
        if (root != null) {
            queue.add(root);
            list.add(root.value);
        }

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.add(treeNode.left);
                list.add(treeNode.left.value);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
                list.add(treeNode.right.value);
            }
        }

    }


}
