package cn.qdd.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qdd
 * @Description: TheShortestString
 * @DateTime: 2026/3/21 08:48
 **/
public class TheShortestString {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        int l=0;
        int valid =0;
        int len = Integer.MAX_VALUE;
        int start =0;
        for (int i =0; i<t.length(); i++){
           tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }

        for (int r = 0; r<s.length(); r++){
            char c = s.charAt(r);
            if (tmap.containsKey(c)){
                int count = smap.getOrDefault(c,0)+1;
                smap.put(c,count);
                if (count == tmap.get(c)){
                    valid++;
                }
            }
            while(valid == tmap.size()){
                if (r-l+1<len){
                    len =r-l+1;
                    start =l;
                }
                char b = s.charAt(l);
                l++;
                if (tmap.containsKey(b)){
                 int count = smap.get(b);
                 if (count==tmap.get(b)){
                     valid--;
                 }
                 smap.put(b,--count);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }
}
