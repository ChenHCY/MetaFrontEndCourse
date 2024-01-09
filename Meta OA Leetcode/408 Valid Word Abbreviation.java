/* 408. Valid Word Abbreviation
A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

For example, a string such as "substitution" could be abbreviated as (but not limited to):
· "s10n" ("s ubstitutio n")
· "sub4u4" ("sub stit u tion")
· "12" ("substitution")
· "su3i1u2on" ("su bst i t u ti on")
· "substitution" (no substrings replaced)

The following are not valid abbreviations:
· "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
· "s010n" (has leading zeros)
· "s0ubstitution" (replaces an empty substring)

Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
A substring is a contiguous non-empty sequence of characters within a string.

Example 1:

Input: word = "internationalization", abbr = "i12iz4n"
Output: true
Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").

Example 2:

Input: word = "apple", abbr = "a2e"
Output: false
Explanation: The word "apple" cannot be abbreviated as "a2e".
 

Constraints:
1 <= word.length <= 20
word consists of only lowercase English letters.
1 <= abbr.length <= 10
abbr consists of lowercase English letters and digits.
All the integers in abbr will fit in a 32-bit integer.
*/
//Time: O(n)   Space: O(n)
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] charArr = abbr.toCharArray();
        int num = 0;    // 缩写中的数字，不能出现前导0
        int index = 0;   // 字符串的滑动指针

        for(char c : charArr){
            //首先判断是不是数字
            if(c >= '0' && c <= '9'){
                //在数字里面 判断有没有前导0, 如果存在 属于错误
                if(num == 0 && c == '0'){
                    return false;
                }
                num = num * 10 + (c - '0');
                continue; //统计有多少字母被缩写，如果是数字不执行后续步骤
            }

            index = index + num;
            //然后检查是否和word字符串对应的位置 是一样的字母，有没有超过长度
            if(index >= word.length() || word.charAt(index) != c){
                return false;
            }
            index++;
            num = 0; //更新num值为0
        }

        return index + num == word.length() ? true : false;
    }
}
