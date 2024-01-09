/* 666. Path Sum IV

If the depth of a tree is smaller than 5, then this tree can be represented by an array of three-digit integers. For each integer in this array:

    · The hundreds digit represents the depth d of this node where 1 <= d <= 4.
    · The tens digit represents the position p of this node in the level it belongs to where 1 <= p <= 8. The position is the same as that in a full binary tree.
    · The units digit represents the value v of this node where 0 <= v <= 9.

Given an array of ascending three-digit integers nums representing a binary tree with a depth smaller than 5, return the sum of all paths from the root towards the leaves.

It is guaranteed that the given array represents a valid connected binary tree.

Example 1:
Input: nums = [113,215,221]
Output: 12
Explanation: The tree that the list represents is shown.
The path sum is (3 + 5) + (3 + 1) = 12.

Example 2:
Input: nums = [113,221]
Output: 4
Explanation: The tree that the list represents is shown. 
The path sum is (3 + 1) = 4.
 
Constraints:
1 <= nums.length <= 15
110 <= nums[i] <= 489
nums represents a valid binary tree with depth less than 5.
*/

class Solution {
    int res; // 记录路径的总和
    HashMap<Integer, Integer> map; //使用Hashmap记录节点层级 深度，和 对应的节点值 

    public int pathSum(int[] nums) {
        res = 0;
        map = new HashMap<>();

        for(int num : nums){
            int key = num / 10; // depth 和 position的集合值
            int value = num % 10; // 节点值

            map.put(key, value);
        }

        dfs((nums[0] / 10), 0); //call dfs function
        return res;
    }

    // dfs function: 递归计算所有路径的总和
    public void dfs(int nodeKey, int sum){
        //exit condition: 找不到对应node的key值(高度+位置)
        if(!map.containsKey(nodeKey)){
            return;
        }

        //如果可以找到对应key值(高度+位置)的节点 加入到结果值
        sum += map.get(nodeKey);

        //根据公式：dnext = d + 1; / childLeftP = 2 * p - 1 and childRightP = 2 * p
        //计算这个节点的左右子树key值(高度+位置)
        int currDepth = nodeKey / 10;
        int currPosition = nodeKey % 10;

        int childLeftKey = (currDepth + 1) * 10 + 2 * currPosition - 1;
        int childRightKey = childLeftKey + 1;

        //检查是否存在左右子树的节点，如果都没有，表示已经到达了二叉树的底层，把路径值加入到总结果res
        if(!map.containsKey(childLeftKey) && !map.containsKey(childRightKey)){
            res += sum;
            return;
        }

        //如果当前节点存在左右子树节点，继续递归遍历
        dfs(childLeftKey, sum);
        dfs(childRightKey, sum);
    }
}
