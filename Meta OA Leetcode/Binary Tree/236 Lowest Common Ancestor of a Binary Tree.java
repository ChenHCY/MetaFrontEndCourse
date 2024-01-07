/* 236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as 
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).” 

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [2, 105].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time: O(n) 每个节点都要遍历一次
//Space: O(1) 没开空间
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //exit condition: 迭代找不到null节点, 或者当前节点就是p or q
        if(root == null || root == p || root == q){
            return root;
        }
        //在左右子树部分查找 是否存在 p or q树节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果当前节点的 左子树 右子树都可以找到对应的p q节点，并且不是null
        if(left != null && right != null){
            return root; //当前节点就是p q的最小公共祖先
        }

        //如果左子树没找到对应的p or q, 右子树找到了, 返回right
        if(left == null && right != null){
            return right;
        } else{  //如果右子树没找到对应的p or q, 左子树找到了，返回left
            return left;
        }
    }
}
