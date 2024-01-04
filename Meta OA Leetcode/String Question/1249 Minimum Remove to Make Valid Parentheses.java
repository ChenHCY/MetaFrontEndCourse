/* 1249. Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

  · It is the empty string, contains only lowercase characters, or
  · It can be written as AB (A concatenated with B), where A and B are valid strings, or
  · It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 
Constraints:
1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
*/

//Solution 1: Used ArrayDeque() + HashSet() + StringBuilder
//Time: O(3n)  Space: O(2n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashSet<Integer> deleteSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        // Travser all the characeter from string s
        for(int i = 0; i < s.length(); i++){
            //当遇见左括号的时候，把下标记录stack中
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')'){
                //1. 当遇见右括号且stack没有能与其配对的左括号时
                // ==> 表示这个右括号是要删除的，加入到deletSet
                if(stack.isEmpty()){
                    deleteSet.add(i);
                } else{ //2. 当stack里面有能配对的左括号的时候, pop掉stack里面的左括号
                    stack.pop();
                }
            }
        }

        //整个遍历结束之后，还要考虑多余左括号的情况：
        while(!stack.isEmpty()){ //把stack剩余的下标都加入到删除set
            deleteSet.add(stack.pop());
        }

        //通过stringbuilder 构建新的string字符串
        for(int i = 0; i < s.length(); i++){
            //如果不在删除列表里面，加入到stringbuilder
            if(!deleteSet.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

//Solution 2: Only used StringBuilder and char[] array
//Time: O(2n)  Space: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        int leftCount = 0;
        int rightCount = 0;
        char[] charArr = s.toCharArray(); //把字符串更改为char array
        StringBuilder sb = new StringBuilder();

        //1. 遍历整个字符串的array, 删除无法配对的右括号
        for(char c : charArr){
            //记录左括号的数量
            if(c == '('){
                leftCount++;
            }

            //当遍历到右括号的时候
            if(c == ')'){
                rightCount++; //统计右括号的数量
                //然后检查是否有能与其配对的左括号
                if(leftCount == 0 || leftCount < rightCount){
                    rightCount--;
                    continue; //如果没有，则删除，跳过后续的加入
                }
            }
            sb.append(c); //把字母加入到stringbuilder
        }

        //2. 在删除多余的右括号之后，再检查删除多余的左括号
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            //遇见左括号的时候，与右括号比较，删除多余的左括号
            if(sb.charAt(i) == '('){
                rightCount--;
                if(rightCount < 0){
                    continue;
                }
            }
            res.append(sb.charAt(i)); //加入到res中
        }

        return res.toString();
    }
}
