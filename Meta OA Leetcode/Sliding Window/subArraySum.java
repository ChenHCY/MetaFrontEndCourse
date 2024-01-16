/* Given an array an un-sort arr[] of non-negative integers and an integer sum, find a subarray that adds to the given sum. 

Note: If there is more than one subarray with sum as the given sum, print the first such subarray.
*/

public class Main {
    public static void findSub(int[] arr, int target) {
        // Pick a starting point
        int n = arr.length;
        int windowSum = arr[0];
        int l = 0;
        int r = 1;

        while (r <= n) { //因为要考虑最后一个数字，所以是r<=n
            // 如果窗口sum大于target，缩小左指针，直到窗口和小于target
            if (windowSum > target && l < r - 1) {
                windowSum -= arr[l];
                l++;
                continue;
            }
            
            if (windowSum == target) {
                System.out.println("Sum found between indexes " + l + " and " + (r-1)); //运行步骤每次都会移动一次r指针，所以需要-1
                return;
            }

            // 更新窗口和
            if (r < n) {
                windowSum += arr[r];
            }
            
            r++;
        }

        System.out.println("No subarray found with " + target + " sum");
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 20, 3, 10, 5};
        int sum1 = 33;
        findSub(arr1, sum1); // Sum found between indexes 2 and 4
        int[] arr2 = {1, 4, 0, 0, 3, 10, 5};
        int sum2 = 7;
        findSub(arr2, sum2); // Sum found between indexes 1 and 4
        int[] arr3 = {1, 4};
        int sum3 = 0;
        findSub(arr3, sum3); // No subarray found with 0 Sum
    }
}
