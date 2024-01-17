/* 543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
 

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-100 <= Node.val <= 100
*/

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 一条路径的长度为该路径经过的节点数减一
// 所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
// dfs遍历每个节点的左右子树，然后递归得到左右子树的最大深度L和R
// ==> 当前节点的最长路径的节点数量为 L + R + 1 ==> 最长的路径不一样要通过root, 所以要记录可能最长的路径节点数量
// ==> 当前节点的最大深度为 Math.max(L, R) + 1, ==> 用来返回上层节点选择
class Solution {
    int res = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        //一条路径的长度为该路径经过的节点数减一
        return res - 1; //所以求最多节点不需要减去1，求链接线需要减去1
    }

    public int dfs(TreeNode node){
        //如果node为null, 到达二叉树的底层
        if(node == null){
            return 0;  // 访问到空节点了，返回0
        }

        int L = dfs(node.left); // 左儿子为根的子树的深度
        int R = dfs(node.right); // 右儿子为根的子树的深度

        res = Math.max(res, L + R + 1);  // 当前节点的最长路径的节点数量为 L + R + 1，更新
        return Math.max(L, R) + 1; // 输出返回当前节点的最大深度
    }
}
