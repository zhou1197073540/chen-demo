package com.exa.demo.DemoTest.exams;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class SolutionFindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
        for (char ch : p.toCharArray()) {
            needs[ch - 'a']++;
        }
        while (right < s.length()) {
            char chr = s.charAt(right);
            if (needs[chr - 'a'] > 0) {
                window[chr - 'a']++;
                if (window[chr - 'a'] <= needs[chr - 'a']) {
                    total--;
                }
            }
            while (total == 0) {
                char chl = s.charAt(left);
                if (needs[chl - 'a'] > 0) {
                    window[chl - 'a']--;
//                    if (window[chl - 'a'] < needs[chl - 'a']) {
                        total++;
//                    }
                }
                System.out.println(left+"=="+total);
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "oqwehjnbhiashvnclnoiwjgoshvsfjaoksgh", p = "hsv";
        System.out.println(new SolutionFindAnagrams().findAnagrams(s,p));
//        int[] i=new int[26];
//        for(char ss:s.toCharArray()){
//            i[ss-'a']++;
//        }
//        System.out.println(Arrays.toString(i));
//        System.out.println(s.charAt(1));
    }
}
