/* 88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing 
the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, 
nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 
0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9
*/

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
// 此题是把nums1和nums2的数字合并成一个递增数组，m n表示nums1 nums2中的数字数量
// 因为我们是把nums2的数加入到nums1, 所以直接思考遍历和指针加入的位置
// Time: O(n) n is the length of nums1[]
// Space: O(1)
var merge = function(nums1, m, nums2, n) {
    let p1 = m - 1;
    let p2 = n - 1;
    let total = m + n - 1;

    //从两个数组的后面往前遍历，因为nums1 nums2 都是严格递增的
    //然后比较对应index的大小，
    while(p1 >= 0 && p2 >= 0){
        if(nums1[p1] < nums2[p2]){
            nums1[total] = nums2[p2];
            p2--;
        } else{
            nums1[total] = nums1[p1];
            p1--;
        }
        total--;
    }

    //然后加入剩余的数字
    //因为我们是从nums2往nums1加入，所以只需要考虑nums2的剩余情况
    while(p2 >= 0){
        nums1[total] = nums2[p2];
        p2--;
        total--;
    }

    return nums1;
};
