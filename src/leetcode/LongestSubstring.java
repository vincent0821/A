package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongkuaikuai on 2017/4/10.
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(findIt("ababc"));
    }

    static String findIt(String completeStr) {
        List<Character> longestSubStr = new ArrayList<>();
        List<Character> tempSubStr = new ArrayList<>();
        for (int i = 0; i < completeStr.length(); i++) {
            char thisChar = completeStr.charAt(i);
            if (tempSubStr.contains(thisChar)) {
                //包含这个char
                if (longestSubStr.size() < tempSubStr.size()) {
                    longestSubStr.clear();
                    longestSubStr.addAll(tempSubStr);
                }
                tempSubStr.clear();
            } else {
                //不包含这个char
                tempSubStr.add(thisChar);
            }
            if(i==completeStr.length()-1){
                if (longestSubStr.size() < tempSubStr.size()) {
                    longestSubStr.clear();
                    longestSubStr.addAll(tempSubStr);
                }
            }
        }
        return longestSubStr.toString();
    }
}
