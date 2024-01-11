/*
https://www.1point3acres.com/bbs/thread-1037183-1-1.html

lc 八七五变形，切木头 nums[]表示木头的长度集合 然后给个k， 

在保证每块切下来的木头都是相同长度下并有至少k个木头， 求最大的切割长度：

*/

import java.util.HashMap;

public class MaxSumSubarray {
    public static int maximumLength(int[] nums, int k) {
        int smaLen = 1;  //能切木头的最小长度
        int maxLen = 0; //切木头的最大长度
        
        for(int n : nums){ //找到最大长度
            maxLen = Math.max(maxLen, n);
        }

        //二分遍历
        while(smaLen < maxLen - 1){ //求最大值需要是right-1，避免只剩两个number的时候，死循环
            int mid = smaLen + (maxLen - smaLen) / 2;
            int woods = countWood(nums, mid); //检查按这个长度切，能得到多少木头数量

            //如果木头数量满足要求，增大长度，移动左指针
            if(woods >= k){
                smaLen = mid;
            } else{ //如果不满足，缩小长度 移动右指针
                maxLen = mid - 1;
            }
        }
        
        // 因为是求最大值，所以在检查一次右指针是否满足要求
        // check the maxLen one more time
        if(countWood(nums, maxLen) >= k){
            return maxLen;
        }
        
        return smaLen; //如果右指针不满足要求 输出左指针值
    }

    //small function: 检查使用这个长度能切出来多少木头数量
    public static int countWood(int[] nums, int cutLen){
        int numWood = 0;
        
        for(int n : nums){
            numWood += n / cutLen;
        }
        
        return numWood;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 9, 8, 6};
        int k = 7;
        int result = maximumLength(nums, k);
        System.out.println("Max sum subarray size: " + result);
    }
}
