/* 875. Koko Eating Bananas
  
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the 
pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 
Constraints:
1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9
*/
//Time: O(N * logN)  Space: O(1)
class Solution {
    //管理员离开h小时，计算猴子吃香蕉的最小速度
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        //首先找到最大速度
        for(int n : piles){
            right = Math.max(right, n); //koko每次最多吃掉一堆香蕉的数量
        }

        //然后二分法，开始计算最小速度， Time: O(logN)
        while(left < right){
            int mid = left + (right - left) / 2;
            int hours = countHours(piles, mid);

            if(hours <= h){ //可以在规定时间内吃完，移动右指针 缩小速率
                right = mid; //但是mid需要保留
            } else{ //如果不能在规定时间内吃完，移动左指针
                left = mid + 1; //不保留mid
            }
        }
        
        return left;
    }
    //small function: 计算需要的时间 ==> Time: O(n)
    public static int countHours(int[] nums, int k){
        int hours = 0; //需要的时间

        for(int n : nums){
            if(n % k == 0){ //是k的倍数，则可以完整吃完
                hours += n / k;
            } else{ //不是k的倍数, 需要额外多一小时
                hours += (n / k) + 1;
            }
        }

        return hours; //当前k速度小，需要的时间
    }
}
