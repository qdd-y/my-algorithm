package cn.qdd.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: qdd
 * @Description: FindAllOrString
 * @DateTime: 2026/3/17 14:09
 **/
public class FindAllOrString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams1(s, p);
        System.out.print(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        //计算p中字符的ascii码和
        int sum = 0;
        for (char c : p.toCharArray()) {
            sum += c;
        }
        //寻找s中长度为p的子串的ascii码和，如果和等于sum则说明是一个异位词
        List<Integer> ans = new java.util.ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int tempSum = 0;
            for (int j = i; j < i + p.length(); j++) {
                tempSum += s.charAt(j);
            }
            if (tempSum == sum) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> list = new ArrayList<>();
        int[] sc = new int[26];
        int[] pc = new int[26];
        for (int i=0; i<m; i++){
            sc[s.charAt(i)-'a']++;
            pc[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(sc,pc)){
            list.add(0);
        }
        for (int i=m; i<n; i++){
            sc[s.charAt(i)-'a']++;
            sc[s.charAt(i-m)-'a']--;
            if (Arrays.equals(sc,pc)){
                list.add(i-m+1);
            }
        }
        return list;

    }
}