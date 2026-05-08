package cn.qdd.algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: qdd
 * @Description: ValidParentheses
 * @DateTime: 2026/5/6 14:40
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        boolean valid = new ValidParentheses().isValid(s);
        System.out.println(valid);
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == ')' || c == ']' || c == '}') return false;
            if( c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.pop() != c){
                    return false;
                }
            }
        }
        return true;
    }
}
