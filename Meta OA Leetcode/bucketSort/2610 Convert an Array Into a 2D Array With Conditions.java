/* 2610. Convert an Array Into a 2D Array With Conditions

You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

    · The 2D array should contain only the elements of the array nums.
    · Each row in the 2D array contains distinct integers.
    · The number of rows in the 2D array should be minimal.

Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

Example 1:
Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.

Example 2:
Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 

Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= nums.length
*/
//Time: O(M *N) m is the length of nums[], n is length of bucketSort
//Space: O(N) create a bucketSort space to save all the nums frequences
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        //使用buckSort来统计每个number的数量
        int[] bucketSort = new int[n + 1];
        for(int num : nums){
            bucketSort[num]++;
        }

        while(true){
            List<Integer> list = new ArrayList<>();
            int count = 0; //用来计算是否所有数字都已经加入到最后的结果中

            for(int i = 0; i < bucketSort.length; i++){
                if(bucketSort[i] > 0){
                    list.add(i);
                    bucketSort[i]--;
                } else{ //如果遇见freq已经用完的数字
                    count++; //记录数量
                }
            }
            //所有数字都已经用完了，当前list为空集
            if(count == bucketSort.length){
                break; //不能加入空集
            }

            res.add(list); //把生成的集合加入到结果中
        }

        return res;
    }
}
