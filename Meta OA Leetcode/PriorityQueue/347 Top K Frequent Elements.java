/* 347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
 

Constraints:
1 <= nums.length <= 10^5
-104 <= nums[i] <= 10^4
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
//Time: O(n)  Space: O(n)
class Solution {
    //找到输出nums[]中最多出现次数的前k个数
    // 1. 使用hashMap统计每个数字的freq次数
    // 2. 然后使用 PriorityQueue 基于 每个数字的frequnce的大小进行升序排列，
    // ==> 保证最后前k个最多次数的数字存在于优先队列中
    // 3. 把优先队列里的数字存入结果res[] 输出
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 使用hashMap统计每个数字的freq次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 然后使用 PriorityQueue 基于 每个数字的frequnce的大小进行降序排列
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()){
            pq.offer(num);
            //优先队列里面只存入nums[]的前k个最多frequence的数
            if(pq.size() > k){
                pq.poll(); //remove the smallest one(oldest)
            }
        }

        // 3. 把优先队列里的数字存入结果res[] 输出
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll(); 
        }

        return res;
    }
}
