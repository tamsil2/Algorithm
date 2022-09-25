package me.tamsil.programmers;

import java.util.Stack;

public class CorrectParenthesis {
    public static void main(String[] args) {
//        String s = "(())()";
//        String s = "(())()";
//        String s = ")()(";
        String s = "(()(";

        boolean answer = new CorrectParenthesis().solution(s);
        System.out.println(answer);
    }

//    boolean solution(String s) {
//        boolean answer = true;
//        Stack<String> stack = new Stack<>();
//        String[] split = s.split("");
//        for (int i = 0; i < split.length; i++) {
//            if (i == 0) {
//                stack.push(split[i]);
//                continue;
//            }
//            if (split[i].equals("(")) {
//                stack.push(split[i]);
//            } else if (split[i].equals(")")) {
//                String peek = stack.peek();
//                if (peek.equals(")")) {
//                    stack.push(split[i]);
//                } else if (peek.equals("(")) {
//                    stack.pop();
//                } else {
//                    answer = false;
//                    break;
//                }
//            }
//        }
//        if (answer) {
//            answer = (stack.isEmpty()) ? true : false;
//        }
//        return answer;
//    }

    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }

        answer = (count == 0) ? true : false;
        return answer;
    }
}
