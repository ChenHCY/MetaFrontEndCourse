/* 346. Moving Average from Data Stream
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:
  · MovingAverage(int size) Initializes the object with the size of the window size.
  · double next(int val) Returns the moving average of the last size values of the stream.

Example 1:
Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 

Constraints:
1 <= size <= 1000
-105 <= val <= 10^5
At most 10^4 calls will be made to next.
*/

class MovingAverage {
    private double sum = 0.0;
    private int size;
    private Deque<Integer> deque = new ArrayDeque<>();

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(size == deque.size()){
            deque.offer(val);
            sum -= deque.pop(); //删除顶端元素和值，因为只保留size个数字和计算
            sum += val; //添加新值进入总和sum
            return (double) sum / size;
        } else{
            deque.offer(val);
            sum += val;
            return (double) sum / deque.size(); 
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
