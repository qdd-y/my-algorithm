package cn.qdd.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: qdd
 * @Description: TheLongestStringWithoutRepetition
 * @DateTime: 2026/3/16 19:09
 **/
public class TheLongestStringWithoutRepetition {

    public static void main(String[] args) {
        String s = "abcbcbb";
        System.out.println(new TheLongestStringWithoutRepetition().lengthOfLongestSubstring3(s));
    }

    public int lengthOfLongestSubstring(String s) {
        //暴力解法
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                //判断是否存在重复字符
                if(isUnqiue(s,i,j)){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }

    public boolean isUnqiue(String s,int start, int end){
        //使用HashSet检查重复
        Set<Character> set =new HashSet<>();
        for(int i=start;i<=end;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l=0, r=0,ans=0;
        while(r<s.length()){
            //先计算再r再自增
            char ic = s.charAt(r);
            r++;
            Integer count = map.getOrDefault(ic,0);
            map.put(ic,++count);
            while(map.get(ic)>1){
                char oc = s.charAt(l);
                l++;
                count = map.get(oc);
                map.put(oc,--count);
            }
            ans = Math.max(ans,r-l);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n=s.length();
        int l=0,r=0,ans=0;
        while (r<n){
            char ic = s.charAt(r);
            r++;
            int count = map.getOrDefault(ic,0);
            map.put(ic,++count);
            while (map.get(ic)>1){
                char oc = s.charAt(l);
                count = map.get(oc);
                l++;
                map.put(oc,--count);
            }
            ans = Math.max(ans,r-l);
        }
        return ans;
    }
}
