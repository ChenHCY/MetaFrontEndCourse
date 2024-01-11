/* 227. Basic Calculator II

Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
 
Constraints:
1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

//Solution 1: Used ArrayDeque<>()
//Time：O(n)   Space：O（n）
class Solution {
    public int calculate(String s) {
        //exit condition
        if(s == null || s.length() == 0){
            return 0;
        }

        int res = 0; //the final result
        int num = 0; //计算的数字
        char numberSign = '+'; // 计算符号
        Deque<Integer> stack = new ArrayDeque<>(); //使用双向队列储存数字结果

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            // Character.isDigit() 判断这个字符是不是数字，如果是的，和前面的组合起来
            if(Character.isDigit(cur)){
                num = num * 10 + cur - '0'; //change the string format into integer
            }//需要得到正确的整数值，前一位是十位

            //如果遇见新的计算符号：('+', '-', '*', '/'), 或者到达字符串的最后位置
            //把当前的知道 数字num 和 计算符号numberSign 组合之后加入到stack中
            if((!Character.isDigit(cur) && cur != ' ') || i == s.length() - 1){
                if(numberSign == '+'){
                    stack.push(num);
                }

                if(numberSign == '-'){
                    stack.push(-num);
                }

                if(numberSign == '*'){
                    stack.push(stack.pop() * num);
                }

                if(numberSign == '/'){
                    stack.push(stack.pop() / num);
                }

                //进行更新符号
                numberSign = cur;
                num = 0;
            }
        }

        //计算队列中的所有数字，得到最后的结果
        while(!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }
}

//Solution 2: Not Used ArrayDeque; Save the space  **********************
//Time：O(n)   Space：O（1）
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int res = 0; //结果值
        int currNum = 0; //当前的数字
        int prevNum = 0; //当前数字 前的一个数字

        char numberSign = '+'; // 计算符号, 数字前的那个符合

        //main travser all the character from string s
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0'; //计算这个数字是多少
            }

            //如果遇见新的计算符号：('+', '-', '*', '/'), 或者到达字符串的最后位置
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(numberSign == '+' || numberSign == '-'){
                   res += prevNum; //把前一个数字计入结果
                   prevNum = numberSign == '+' ? currNum : -currNum; //判断是+还是- 
                }

                if(numberSign == '*'){
                   prevNum = prevNum * currNum;
                } else if(numberSign == '/'){
                    prevNum = prevNum / currNum;
                }

                numberSign = c; //进行更新符号
                currNum = 0; //重新计算下一个数字
            }
        }

        return res + prevNum;
    }
}
