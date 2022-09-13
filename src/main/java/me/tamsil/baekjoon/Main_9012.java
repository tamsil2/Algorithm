package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
    private static int test_case;
    private static String input;
    private static char left = '(';
    private static char right = ')';

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine());
        Stack<Character> charStack;
        for (int i = 0; i < test_case; i++) {
            charStack = new Stack<>();
            input = br.readLine();
            char[] charArray = input.toCharArray();
            for (char ch : charArray) {
                if (ch == left) {
                    charStack.push(ch);
                } else {
                    if (charStack.isEmpty()) {
                        charStack.push(ch);
                    } else if (charStack.peek() == left) {
                        charStack.pop();
                    } else if (charStack.peek() == right) {
                        charStack.push(ch);
                    }
                }
            }

            if (charStack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
