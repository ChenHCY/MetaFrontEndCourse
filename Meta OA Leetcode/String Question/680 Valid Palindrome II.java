/* 680. Valid Palindrome II

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false
 

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
*/
//Time: O(n): 每一个字母只遍历一次
//Space: O(1)
class Solution {
    //判断可以最多删除一个字母的情况下, 字符串s是不是回文
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        //双指针从两端 往中间遍历，检查有多少个字母是不一样的，并且删除之后 能不能保证是回文
        while(l < r){
            //如果遇见不一样的字母
            if(s.charAt(l) != s.charAt(r)){
                //检查跳过这个字母之后，能不能保证是回文字符串
                return checkPalidrome(s, l + 1, r) || checkPalidrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    public static boolean checkPalidrome(String s, int l, int r){
        //如果超过界限，输出false
        if(l >= s.length() && r < 0){
            return false; 
        }

        while(l < r){
            //如果再次遇见不一样的字母，则无法删除一个字母来形成回文
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
