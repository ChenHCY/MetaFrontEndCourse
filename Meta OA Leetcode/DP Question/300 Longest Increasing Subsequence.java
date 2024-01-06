/* 300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing 
subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4
*/
//Time: O(n^2)  Space: O(n)
class Solution {
    /* 思路： DP method
        1. Dp 数组 和 下标的含义：dp[i]表示这nums[] array中 [0, i]的区间的最长递增子序列长度
        2. 状态转移方程(递推公式)：位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列的最大值 + 1。
        ==> dp[i] = Math.max(dp[i], dp[j] + 1); 
        3. DP数组的初始化：每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1. ==>  Arrays.fill(dp, 1); 
        4. 确定遍历的顺序：因为dp[i]的值都是基于dp[0, j] ==> j其实就是遍历0到i-1， 
                          ==> 所以一定是从前往后遍历
        5. 举例推导DP数组.
    */
    public int lengthOfLIS(int[] nums) {
        //the base condition
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int res = 1;
        int n = nums.length;

        int[] dp = new int[n]; // dp[] 储存每个index位置上 最长递增序列的长度
        Arrays.fill(dp, 1); // 给每一个dp[] index位置上设定初始值为1

        //this question is find Longest Increasing Subsequence
        //traverse and check every current number have how many previous numbers less than it
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
