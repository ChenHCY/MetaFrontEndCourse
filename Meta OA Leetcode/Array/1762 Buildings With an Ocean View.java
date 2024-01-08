/* 1762. Buildings With an Ocean View

There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building 
has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.


Example 1:
Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.

Example 2:
Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.

Example 3:
Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.
 

Constraints:
1 <= heights.length <= 10^5
1 <= heights[i] <= 10^9
*/
//Time: O(n）: for-loop整体遍历一次
//Space: O(n)： 开了一个新的arraylist储存能看到海的index位置
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> sawOceac = new ArrayList<>();
        sawOceac.add(heights.length - 1); //最右边的一个building肯定能看到海 
        int max = heights[heights.length - 1]; //最高的一个building

        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i] > max){
                sawOceac.add(i);
                max = heights[i]; //更新最高的building
            }
        }

        int[] res = new int[sawOceac.size()];
        int index = 0;
        for(int j = sawOceac.size() - 1; j >= 0; j--){
            res[index] = sawOceac.get(j);
            index++;
        }

        return res;
    }
}
