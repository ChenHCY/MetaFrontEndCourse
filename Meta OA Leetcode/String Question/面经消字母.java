/* 1209. Remove All Adjacent Duplicates in String II 的简化

连续三个相同的candy会消除，请问给一个字符串输入，输出是什么？

*/

import java.util.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static String crushCandies(String input) {
       StringBuilder sb = new StringBuilder(input);
       int[] count = new int[sb.length()]; //使用bucketSort统计字母出现的次数
       
       for(int i = 0; i < sb.length(); i++){
           //如果是首字母，或者相邻的字母不一样，统计次数都为1
           if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)){
               count[i] = 1;
           } else{ //遇见相邻一样的字母，统计相邻一样的数量
               count[i] = count[i - 1] + 1;
               //如果是连续3个一样的字母，使用stringbuilder.delete()删除这个区域
               if(count[i] == 3){
                   sb.delete(i - 3 + 1, i + 1);
                   i = i - 3; //重置i指针到删除区域之前
               }
           }
       }
       
       return sb.toString();
    }

    public static void main(String[] args) {
        // 示例输入
        String input1 = "aaabbbcc";
        String input2 = "aabbbcc";
        String input3 = "aabbcccba";

        // 输出结果
        String output1 = crushCandies(input1);
        String output2 = crushCandies(input2);
        String output3 = crushCandies(input3);

        // 打印结果
        System.out.println("Input: " + input1 + ", Output: " + output1);
        System.out.println("Input: " + input2 + ", Output: " + output2);
        System.out.println("Input: " + input3 + ", Output: " + output3);
    }
}
