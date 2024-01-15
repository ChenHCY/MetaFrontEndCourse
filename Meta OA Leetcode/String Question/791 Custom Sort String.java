/* 791. Custom Sort String

You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character 
y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

Example 1:
Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

Example 2:
Input: order = "cbafg", s = "abcd"
Output: "cbad"
 

Constraints:
1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.
*/
//Time: O(n + m) Space: O(n) 
// n is the length of string s, m is the length of string order
class Solution {
    // order 的所有字母都是 唯一 的, 按照order的数据构造String s，不存在于String order中的字母放在任意位置
    public String customSortString(String order, String s) {
        //首先统计String s中每个字母的出现次数
        int[]  cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c - 'a']++; 
        }

        //然后按照String order的顺序构造新字符串
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            //如果order String存在当前字符串s中的字符，全部添加进stringbuilder（新字符串）
            while(cnt[c - 'a'] > 0){
                sb.append(c);
                cnt[c - 'a']--;
            }
        }

        //最后放入剩下不存于字符串order里面的字母
        for(int i = 0; i < 26; i++){
            while(cnt[i] > 0){
                sb.append((char) (i + 'a'));
                cnt[i]--;
            }
        }

        return sb.toString();
    }
}
